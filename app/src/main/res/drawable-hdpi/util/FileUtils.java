package com.shixi.shixitraining.shixitraining.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by shenyan on 2018/9/17.
 */
public class FileUtils {

    public static final String APP_PATH = Environment
            .getExternalStorageDirectory()
            + File.separator
            + "shixiTraining"
            + File.separator;

    /*** 默认存放图片的路径*/
    public final static String DEFAULT_IMAGE_PATH = APP_PATH
            + "camera"
            + File.separator;

    /*** 默认存放文件的路径*/
    public final static String DEFAULT_CACHE_PATH = APP_PATH
            + "cache"
            + File.separator;


    public static void initFilePath(){
        if(!isFileExist(DEFAULT_IMAGE_PATH)){
            createDir(DEFAULT_IMAGE_PATH);
        }
        if(!isFileExist(DEFAULT_CACHE_PATH)){
            createDir(DEFAULT_CACHE_PATH);
        }
    }


    /**
     * 在SD卡上创建文件
     * @param filePath
     * @return
     * @throws IOException
     */
    public static File createFile(String filePath) throws IOException {
        File file = new File(filePath);
        file.createNewFile();
        return file;
    }

    /**
     * 在SD卡上创建目录
     * @param filePath
     * @return
     */
    public static File createDir(String filePath){
        File dir = new File(filePath);
        dir.mkdirs();
        return dir;
    }

    /**
     * 判断SD卡上的文件夹是否存在
     * @param filePath
     * @return
     */
    public static boolean isFileExist(String filePath){
        File file = new File(filePath);
        return file.exists();
    }


    /**
     * 根据文件路径获取byte数组
     * @param filePath
     * @return
     */
    public static byte[] readFileContent(String filePath) {

        byte[] ret = null;
        if(!TextUtils.isEmpty(filePath)){
            File file = new File(filePath);
            if(isFileExist(filePath)){
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                try {

                    InputStream is = new BufferedInputStream(new FileInputStream(file));
                    byte[] buf = new byte[1024];
                    int read;
                    while ((read = is.read(buf, 0, buf.length)) != -1) {
                        bos.write(buf, 0, read);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return bos.toByteArray();
            }
        }

        return ret;

    }

    /**
     * 通过uri获取文件路径
     *
     * @param mUri
     * @return
     */
    public static String getFilePath(Context context, Uri mUri) {
        try {
            if (mUri.getScheme().equals("file")) {
                return mUri.getPath();
            } else {
                return getFilePathByUri(context, mUri);
            }
        } catch (FileNotFoundException ex) {
            return null;
        }
    }

    // 获取文件路径通过url
    private static String getFilePathByUri(Context context, Uri mUri) throws FileNotFoundException {
        Cursor cursor = context.getContentResolver()
                .query(mUri, null, null, null, null);
        cursor.moveToFirst();
        return cursor.getString(1);
    }


    /**
     * 从inputStrean中读取文本
     * @param inputStream
     * @return
     */
    public static String readTextFile(InputStream inputStream) {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];

        int len;

        try {

            while ((len = inputStream.read(buf)) != -1) {

                outputStream.write(buf, 0, len);

            }

            outputStream.close();

            inputStream.close();

        } catch (IOException e) {

        }

        return outputStream.toString();

    }
}
