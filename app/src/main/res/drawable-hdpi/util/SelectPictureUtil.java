package com.shixi.shixitraining.shixitraining.util;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;

/**
 * Created by shenyan on 2018/9/17.
 */
public class SelectPictureUtil {

    /**
     * 临时存放图片的地址，如需修改，请记得创建该路径下的文件夹
     */
    public static String lsimg = com.shixi.shixitraining.shixitraining.util.FileUtils.DEFAULT_IMAGE_PATH + android.text.format.DateFormat
            .format("yyyyMMddkkmmss",
                    new Date()).toString() + ".jpg";
    ;
    public static String outputlsimg;

    public static final int GET_BY_ALBUM = 801;//如果有冲突，记得修改
    public static final int GET_BY_CAMERA = 802;//如果有冲突，记得修改
    public static final int CROP = 803;//如果有冲突，记得修改

    /**
     * 从相册获取图片
     */
    public static void getByAlbum(Activity act) {
        Intent getAlbum = new Intent(Intent.ACTION_PICK, null);
        getAlbum.setType("image/*");
        act.startActivityForResult(getAlbum, GET_BY_ALBUM);
    }

    /**
     * 通过拍照获取图片
     */
    public static void getByCamera(Activity act) {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            onCamera(act);
            /*Intent getImageByCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            getImageByCamera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.parse(lsimg));
            getImageByCamera.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0);
            act.startActivityForResult(getImageByCamera, GET_BY_CAMERA);*/
        } else {
        }
    }

    private static void onCamera(Activity act) {

        File file = new File(com.shixi.shixitraining.shixitraining.util.FileUtils.DEFAULT_IMAGE_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        lsimg = com.shixi.shixitraining.shixitraining.util.FileUtils.DEFAULT_IMAGE_PATH + System.currentTimeMillis() + ".jpg";
        File imagFile = new File(lsimg);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                (!com.shixi.shixitraining.shixitraining.util.PermissionUtil.selfPermissionGranted(act, Manifest.permission.WRITE_EXTERNAL_STORAGE) ||
                        !com.shixi.shixitraining.shixitraining.util.PermissionUtil.selfPermissionGranted(act, Manifest.permission.CAMERA) ||
                        !com.shixi.shixitraining.shixitraining.util.PermissionUtil.selfPermissionGranted(act, Manifest.permission.READ_EXTERNAL_STORAGE))) {
            act.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
        } else {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(act.getPackageManager()) != null) {
                if (imagFile != null) {
                    /*获取当前系统的android版本号*/
                    int currentapiVersion = Build.VERSION.SDK_INT;
                    if (currentapiVersion < 24) {
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagFile));
                        act.startActivityForResult(intent, com.shixi.shixitraining.shixitraining.util.SelectPictureUtil.GET_BY_CAMERA);
                    } else {
                        ContentValues contentValues = new ContentValues(1);
                        contentValues.put(MediaStore.Images.Media.DATA, imagFile.getAbsolutePath());
                        Uri uri = act.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                        act.startActivityForResult(intent, com.shixi.shixitraining.shixitraining.util.SelectPictureUtil.GET_BY_CAMERA);
                    }
                }
            }
        }
    }

    /**
     * 处理获取的图片，注意判断空指针，默认大小480*480，比例1:1
     */
    public static Bitmap onActivityResult(Activity act, int requestCode, int resultCode, Intent data) {
        return onActivityResult(act, requestCode, resultCode, data, 0, 0);
    }

    /**
     * 处理获取的图片，注意判断空指针
     */
    public static Bitmap onActivityResult(Activity act, int requestCode, int resultCode, Intent data,
                                          int aspectX, int aspectY) {
        Bitmap bm = null;
        if (resultCode == Activity.RESULT_OK) {
            Uri uri = null;
            switch (requestCode) {
                case GET_BY_ALBUM:
                    uri = data.getData();
                    act.startActivityForResult(crop(0,uri, aspectX, aspectY, act), CROP);
                    break;
                case GET_BY_CAMERA:
                    uri = Uri.parse(lsimg);
                    act.startActivityForResult(crop(1,uri,  aspectX, aspectY, act), CROP);
                    break;
                case CROP:
                    bm = dealCrop(act);
                    break;
            }
        }
        return bm;
    }

    /**
     * 默认裁剪输出480*480，比例1:1
     */
//    //public static Intent crop(Uri uri, Activity act) {
//        return crop(uri, 1, 1, act);
//    }

    /**
     * 裁剪，例如：输出100*100大小的图片，宽高比例是1:1
     *
     *
     * @param aspectX 宽比例
     * @param aspectY 高比例
     */
    public static Intent crop(int type, Uri uri, int aspectX, int aspectY, Activity act) {
        outputlsimg = com.shixi.shixitraining.shixitraining.util.FileUtils.DEFAULT_IMAGE_PATH + System.currentTimeMillis() + ".jpg";
//        if (w == 0 && h == 0) {
//            w = h = 480;
//        }
//        if (aspectX == 0 && aspectY == 0) {
//            aspectX = aspectY = 1;
//        }
        Uri tUri = null;
        if (type == 0){//相册
            tUri = uri;
        }else if (type == 1){//相机
            tUri = getImageContentUri(act,new File(lsimg));
        }
        Intent intent = new Intent("com.android.camera.action.CROP");
        // 照片URL地址
        intent.setDataAndType(tUri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", aspectX);
        intent.putExtra("aspectY", aspectY);
//        intent.putExtra("outputX", w);
//        intent.putExtra("outputY", h);
        intent.putExtra("scale", true);
        // 输出路径
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(outputlsimg)));
        // 输出格式
        intent.putExtra("outputFormat", "JPEG");
        // 不启用人脸识别
        intent.putExtra("noFaceDetection", true);
        intent.putExtra("return-data", false);
        return intent;
    }

    /**
     * 处理裁剪，获取裁剪后的图片
     */
    public static Bitmap dealCrop(Context context) {
        // 裁剪返回
        Uri uri = Uri.parse(lsimg);
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public static Uri getImageContentUri(Context context, File imageFile) {
        String filePath = imageFile.getAbsolutePath();
        Cursor cursor = context.getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Images.Media._ID},
                MediaStore.Images.Media.DATA + "=? ",
                new String[]{filePath}, null);

        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor
                    .getColumnIndex(MediaStore.MediaColumns._ID));
            Uri baseUri = Uri.parse("content://media/external/images/media");
            return Uri.withAppendedPath(baseUri, "" + id);
        } else {
            if (imageFile.exists()) {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.DATA, filePath);
                return context.getContentResolver().insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            } else {
                return null;
            }
        }
    }




}
