package com.annie.annieforchild.play;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;


import com.annie.annieforchild.R;
import com.annie.annieforchild.entity.VideoPlayEntity;
import com.annie.annieforchild.play.ijkplayer.DialogUtil;
import com.annie.annieforchild.play.ijkplayer.IjkVideoView;

import tv.danmaku.ijk.media.player.IMediaPlayer;

/**
 * Created by shen
 */

public class PlayerPresenter {

    private Activity activity;
    private VideoPlayEntity entity;
    private IjkVideoView videoView;

    private View playLayoutView;
    private AudioManager audioManager;
    private Query $;

    private int w;
    private int h;
    private int adjust_16_9;
    private int adjust_4_3;

    private int defaultTime = 3000;

    private final int MESSAHE_SHOW_DIALOG = 0;
    private final int MESSAHE_SHOW_PROGRESS = 1;
    private final int MESSAHE_FADE_OUT = 2;
    private final int MESSAHE_SEEK_NEW_POSITION = 3;
    private final int MESSAHE_HIDE_CENTER_BOX = 4;
    private final int MESSAHE_ORITATION_CHANGE = 5;

    private int mMaxVolume;//最大声音
    private long newPosition = -1;
    private int volume = -1;//音量
    private float brightness = -1;//亮度
    private int currentPosition;

    private int STATUS_ERROR = -1;
    private int STATUS_IDLE = 0;
    private int STATUS_LOADING = 1;
    private int STATUS_PLAYING = 2;
    private int STATUS_PAUSE = 3;
    private int STATUS_COMPLETED = 4;
    private int status = STATUS_IDLE;

    private OrientationEventListener orientationEventListener;

    private InternetReceiver internetReceiver;//网络状态变化广播


    private boolean isLock;//锁屏开关
    private boolean isLive;//是否直播
    private boolean isPauseInPlaying;//onPause的时候视频是否在播放
    private boolean isRegisterNet;//监听了网络变化
    private boolean isShowingControllerLayout;//控制器是否显示

    private DialogUtil errorDialog;//错误提示对话框

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MESSAHE_SHOW_DIALOG:
                    String message = msg.getData().getString("msg");
                    errorDialog = new DialogUtil(activity, new DialogUtil.Listener() {
                        @Override
                        public void ok() {
                            errorDialog.dismiss();
                        }

                        @Override
                        public void cancel() {
                            activity.finish();
                        }
                    }, message);
                    errorDialog.setCancelable(false);
                    errorDialog.show();

                    break;
                case MESSAHE_FADE_OUT:
                    hide();
                    break;
                case MESSAHE_HIDE_CENTER_BOX:
                    $.id(R.id.player_center_brightness_layout).gone();
                    $.id(R.id.player_center_volumn_layout).gone();
                    $.id(R.id.player_center_fast_layout).gone();
                    break;
                case MESSAHE_SHOW_PROGRESS:
                    setProgress();
                    if (!isDragging && isShowingControllerLayout) {
                        msg = obtainMessage(MESSAHE_SHOW_PROGRESS);
                        sendMessageDelayed(msg, 1000);
                        updatePausePlayIcon();
                    }
                    break;
                case MESSAHE_SEEK_NEW_POSITION:
                    if (entity != null) {
                        if (!entity.isLive() && newPosition >= 0) {
                            videoView.seekTo((int) newPosition);
                            doStartVideo();
                            newPosition = -1;
                        }
                    }
                    break;
                case MESSAHE_ORITATION_CHANGE:
                    orientationEventListener.enable();
                    break;
            }

        }
    };

    private synchronized void sendErrorMessage(String info) {
//        if (errorDialog != null && errorDialog.isShowing()) {
//            return;
//        }
        Message msg = new Message();
        Bundle data = new Bundle();
        data.putString("msg", info);
        msg.setData(data);
        msg.what = MESSAHE_SHOW_DIALOG;
        handler.sendMessage(msg);
    }

    public PlayerPresenter(Activity act, View view) {

        this.activity = act;
        playLayoutView = view;

        videoView = (IjkVideoView) playLayoutView.findViewById(R.id.player_ijk_view);
        audioManager = (AudioManager) activity.getSystemService(Context.AUDIO_SERVICE);
        mMaxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        $ = new Query();

        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//让屏幕保持常亮

        w = getScreenWidthPixels(activity);
        h = getScreenHeightPixels(activity);

        float ratio16_19 = (float) 16 / 9;
        adjust_16_9 = (int) Math.ceil((float) w / ratio16_19);


        float ratio4_3 = (float) 4 / 3;
        adjust_4_3 = (int) Math.ceil((float) w / ratio4_3);

        set16_9();

        SeekBar seekBar = (SeekBar) $.id(R.id.player_bottom_seekbar).view;
        seekBar.setMax(1000);
        seekBar.setOnSeekBarChangeListener(seekBarListener);

        final GestureDetector gestureDetector = new GestureDetector(activity, new PlayerGestureListener());
        playLayoutView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (gestureDetector.onTouchEvent(motionEvent))
                    return true;

                // 处理手势结束
                switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_UP:
                        endGesture();
                        break;
                }

                return false;
            }
        });

        $.id(R.id.player_bottom_play_btn).clicked(onClickListener);
        $.id(R.id.player_bottom_full_btn).clicked(onClickListener);
        $.id(R.id.player_top_back_img).clicked(onClickListener);


        videoView.setOnCompletionListener(new IMediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                statusChange(STATUS_COMPLETED);
            }
        });

        videoView.setOnErrorListener(new IMediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(IMediaPlayer iMediaPlayer, int i, int i1) {
                statusChange(STATUS_ERROR);

                return true;
            }
        });

        videoView.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                iMediaPlayer.setOnInfoListener(new IMediaPlayer.OnInfoListener() {
                    @Override
                    public boolean onInfo(IMediaPlayer iMediaPlayer, int what, int extra) {
                        switch (what) {
                            case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                                statusChange(STATUS_LOADING);
                                break;
                            case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                                $.id(R.id.player_default_image).gone();
                                statusChange(STATUS_PLAYING);
                                break;
                            case MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START:
                                $.id(R.id.player_default_image).gone();
                                statusChange(STATUS_PLAYING);
                                break;
                        }
                        return false;
                    }
                });
            }
        });

        orientationEventListener = new OrientationEventListener(activity) {
            @Override
            public void onOrientationChanged(int orientation) {
                if (orientation >= 0 && orientation <= 30 || orientation >= 330 || (orientation >= 150 && orientation <= 210)) {
                    //竖屏
                    if (isScreenPortrait()) {
                        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
                        orientationEventListener.disable();
                    }
                } else if ((orientation >= 90 && orientation <= 120) || (orientation >= 240 && orientation <= 300)) {
                    if (!isScreenPortrait()) {
                        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
                        orientationEventListener.disable();
                    }
                }
            }
        };
        handler.sendEmptyMessageDelayed(MESSAHE_ORITATION_CHANGE, 1000);

    }

    public void set16_9() {
        ViewGroup.LayoutParams layoutParams = playLayoutView.getLayoutParams();
        layoutParams.width = w;
        layoutParams.height = adjust_16_9;
        playLayoutView.setLayoutParams(layoutParams);
    }

    public void set4_3() {
        ViewGroup.LayoutParams layoutParams = playLayoutView.getLayoutParams();
        layoutParams.width = w;
        layoutParams.height = adjust_4_3;
        playLayoutView.setLayoutParams(layoutParams);
    }

    private void statusChange(int newStatus) {
        status = newStatus;
        if (status == STATUS_COMPLETED) {
            handler.removeMessages(MESSAHE_SHOW_PROGRESS);
            hideAll();
        } else if (status == STATUS_ERROR) {
            sendErrorMessage("播放异常，是否重试");
        } else if (status == STATUS_LOADING) {
            hideAll();
            showLoadingProgress();
        } else if (status == STATUS_PLAYING) {
            hideAll();
        }

    }

    // 重置状态栏
    public void reSetStatusBar() {
        if (activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            hideStatusBar();
        } else {
            setDecorVisible();
        }
    }

    // 隐藏状态栏
    public void hideStatusBar() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            View decorView = activity.getWindow().getDecorView();
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    // 恢复为不全屏状态
    public void setDecorVisible() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            View decorView = activity.getWindow().getDecorView();
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            int uiOptions = View.SYSTEM_UI_FLAG_VISIBLE;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    protected View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.player_bottom_full_btn://全屏
                    if (isScreenPortrait()) {
                        changeToLandscape();
                    } else {
                        changeToPortrait();
                    }
                    break;
                case R.id.player_bottom_play_btn://播放、暂停
                    doPauseResume();
                    show(defaultTime);
                    break;
                case R.id.player_top_back_img://返回
                    if (!onBackPressed()) {
                        activity.finish();
                    }
                    break;
            }

        }
    };



    /**
     * 点击播放、暂停按钮
     */
    private void doPauseResume() {
        if (videoView.isPlaying()) {
            doPauseVideo();

        } else {
            doStartVideo();

        }
        updatePausePlayIcon();
    }

    /**
     * 暂停播放
     */
    public void doPauseVideo() {
        videoView.pause();
        statusChange(STATUS_PAUSE);
    }

    /**
     * 开始播放视频
     */
    public void doStartVideo() {
        videoView.start();
    }


    private AnimationDrawable animaDrawable;

    /**
     * 更新播放暂停的图标
     */
    private void updatePausePlayIcon() {
        if (videoView != null) {

            if (videoView.isPlaying()) {
                updatePlayIconAnimation(1);
            } else {
                updatePlayIconAnimation(2);
            }
        }
    }

    /**
     * @param flag 1.播放 2.暂停
     */
    private void updatePlayIconAnimation(int flag) {
        ImageView playbtn = (ImageView) $.id(R.id.player_bottom_play_btn).view;
        if (flag == 1) {
            playbtn.setImageResource(R.drawable.video_stop);

        } else {
            playbtn.setImageResource(R.drawable.video_start);

        }
//        animaDrawable = (AnimationDrawable) playbtn.getDrawable();
       // animaDrawable.start();
    }

    public void onPause() {

        if (videoView != null && videoView.isPlaying()) {
            isPauseInPlaying = true;
        } else {
            isPauseInPlaying = false;
        }

        if (entity != null && !entity.isLive()) {
            currentPosition = videoView.getCurrentPosition();
        }

        doPauseVideo();


    }

    public void onDestory() {
        doUnregisterReceiver();
        if (videoView != null) {
            videoView.stopPlayback();
        }
    }


    public void onResume() {

        if (entity != null && !entity.isLive()) {
            videoView.seekTo(currentPosition);
        }

        if (videoView != null && isPauseInPlaying) {
            doStartVideo();
        }
    }

    public void doNextPlay(VideoPlayEntity videoPlayEntiy) {
        doPauseVideo();
        requestPlay(videoPlayEntiy);
    }

    /**
     * 请求播放视频
     */
    public void requestPlay(VideoPlayEntity videoPlayEntiy) {
        if (videoPlayEntiy == null || (TextUtils.isEmpty(videoPlayEntiy.getUrl()))) {
            return;
        }
//
//        if (videoPlayEntiy!=null && videoPlayEntiy.isLive()==true){
//            set4_3();
//        }else {
//            set16_9();
//        }

        hideAll();
        statusChange(STATUS_IDLE);
        $.id(R.id.player_default_image).visible();
        showLoadingProgress();

        this.entity = videoPlayEntiy;

        setTitle(videoPlayEntiy.getTitle());

        doRegisterInter();

        playContent();

    }

    /**
     * 播放要播放的视频
     */
    private void playContent() {
        if (entity != null) {
            showLoadingProgress();

            videoView.setVideoPath(entity.getUrl());
            // videoView.setVideoURI(Uri.parse(entity.getUrl()));
            doStartVideo();

        }
    }

    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitle(CharSequence title) {
        $.id(R.id.player_top_title_tv).text(title);
    }


    /**
     * 切换到横屏
     */
    public void changeToLandscape() {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    }


    public void changeToLandscpaeLayout() {
        // 由于切换到横屏获取到的宽高可能和竖屏的不一样，所以需要重新获取宽高
        ViewGroup.LayoutParams layoutParams = playLayoutView.getLayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = getScreenHeightPixels(activity);
        playLayoutView.setLayoutParams(layoutParams);
    }

    /**
     * 切换到竖屏
     */
    public void changeToPortrait() {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    public void changeToPortraitLayout() {
        ViewGroup.LayoutParams layoutParams = playLayoutView.getLayoutParams();
        layoutParams.width = w;
        layoutParams.height = adjust_16_9;
        playLayoutView.setLayoutParams(layoutParams);
    }

    private boolean mAutoRotateOn;
    /**
     * 屏幕旋转
     */
    public void onConfigurationChanged() {
        // 隐藏或显示状态栏
        reSetStatusBar();
        doUpdataBottomLayout();
        doUpdateFullScreenButton();
        if (isScreenPortrait()) {
            changeToPortraitLayout();
        } else {
            changeToLandscpaeLayout();
        }
        mAutoRotateOn = (Settings.System.getInt(activity.getContentResolver(), Settings.System.ACCELEROMETER_ROTATION, 0) == 1);
        //检查系统是否开启自动旋转
        if (mAutoRotateOn) {
           // orientationEventListener.enable();
        }

    }

    private void doUpdateFullScreenButton() {
        if (activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            $.id(R.id.player_bottom_full_btn).gone();
        } else {
            $.id(R.id.player_bottom_full_btn).visible();
        }
    }



    /**
     * 屏幕切换更新底部布局
     */
    public void doUpdataBottomLayout() {
        if (isShowingControllerLayout) {
            if (entity != null) {
                showBottomControl(true);
            }
        }
    }

    /**
     * 点击返回键
     */
    public boolean onBackPressed() {
        if (!isScreenPortrait()) {
            changeToPortrait();
            return true;
        }
        return false;
    }

    private void endGesture() {
        volume = -1;
        brightness = -1f;
        if (newPosition >= 0) {
            handler.removeMessages(MESSAHE_SEEK_NEW_POSITION);
            handler.sendEmptyMessage(MESSAHE_SEEK_NEW_POSITION);
        }
        handler.removeMessages(MESSAHE_HIDE_CENTER_BOX);
        handler.sendEmptyMessageDelayed(MESSAHE_HIDE_CENTER_BOX, 500);
    }

    public class PlayerGestureListener extends GestureDetector.SimpleOnGestureListener {
        private boolean firstTouch;
        private boolean volumeControl;
        private boolean toSeek;

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            if (isShowingControllerLayout) {
                hide();
            } else {
                show(defaultTime);
            }
            return true;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            firstTouch = true;
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            float mOldX = e1.getX(), mOldY = e1.getY();
            float deltaY = mOldY - e2.getY();
            float deltaX = mOldX - e2.getX();
            if (firstTouch) {
                toSeek = Math.abs(distanceX) >= Math.abs(distanceY);
                int screenWidthPixels = getScreenWidthPixels(activity);
                volumeControl = mOldX > screenWidthPixels * 0.5f;
                firstTouch = false;
            }


            if (toSeek) {
                if (entity != null && !entity.isLive()) {
                    onProgressSlide(-deltaX / videoView.getWidth());
                }
            } else {
                float percent = deltaY / videoView.getHeight();
                if (volumeControl) {
                    onVolumeSlide(percent);
                } else {
                    onBrightnessSlide(percent);
                }


            }
            return super.onScroll(e1, e2, distanceX, distanceY);
        }
    }

    private long duration;
    private boolean instantSeeking;
    private boolean isDragging;//是否在拖拽
    private SeekBar.OnSeekBarChangeListener seekBarListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (!fromUser)
                return;
            int newPosition = (int) ((duration * progress * 1.0) / 1000);
            if (instantSeeking) {
                videoView.seekTo(newPosition);
            }
            String time = generateTime(newPosition);
            $.id(R.id.player_bottom_start_time).text(time);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            isDragging = true;
            show(3600000);
            handler.removeMessages(MESSAHE_SHOW_PROGRESS);
            if (instantSeeking) {
                audioManager.setStreamMute(AudioManager.STREAM_MUSIC, true);
            }
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!instantSeeking) {
                videoView.seekTo((int) ((duration * seekBar.getProgress() * 1.0) / 1000));
                doStartVideo();
            }
            show(defaultTime);
            handler.removeMessages(MESSAHE_SHOW_PROGRESS);
            audioManager.setStreamMute(AudioManager.STREAM_MUSIC, false);
            isDragging = false;
            handler.sendEmptyMessageDelayed(MESSAHE_SHOW_PROGRESS, 1000);
        }
    };


    private String generateTime(long time) {
        int totalSeconds = (int) (time / 1000);
        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;
        return hours > 0 ? String.format("%02d:%02d:%02d", hours, minutes, seconds) : String.format("%02d:%02d", minutes, seconds);
    }


    /**
     * 设置点播的播放进度条跟文字
     *
     * @return
     */
    private long setProgress() {
        if (isDragging) {
            return 0;
        }


        long position = 0;
        if (videoView != null) {
            position = videoView.getCurrentPosition();
            long duration = videoView.getDuration();
            SeekBar seekBar = (SeekBar) $.id(R.id.player_bottom_seekbar).view;
            if (seekBar != null) {
                if (duration > 0) {
                    long pos = 1000L * position / duration;
                    seekBar.setProgress((int) pos);
                }
                int percent = videoView.getBufferPercentage();
                seekBar.setSecondaryProgress(percent * 10);
            }

            this.duration = duration;
            $.id(R.id.player_bottom_start_time).text(generateTime(position));
            $.id(R.id.player_bottom_end_time).text(generateTime(this.duration));
        }


        return position;
    }

    /**
     * 滑动改变声音大小
     *
     * @param percent
     */
    private void onVolumeSlide(float percent) {
        if (volume == -1) {
            volume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            if (volume < 0)
                volume = 0;
        }
        hide();

        int index = (int) (percent * mMaxVolume) + volume;
        if (index > mMaxVolume)
            index = mMaxVolume;
        else if (index < 0)
            index = 0;

        // 变更声音
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, index, 0);

        // 变更进度条
        int i = (int) (index * 1.0 / mMaxVolume * 100);
        String s = i + "%";
        if (i == 0) {
            s = "off";
        }
        // 显示
        $.id(R.id.player_center_volumn_mig).image(i == 0 ? R.drawable.ic_volume_off_white_36dp : R.drawable.ic_volume_up_white_36dp);
        $.id(R.id.player_center_brightness_layout).gone();
        $.id(R.id.player_center_fast_layout).gone();
        $.id(R.id.player_center_volumn_layout).visible();
        $.id(R.id.player_center_volumn_mig).visible();
        $.id(R.id.player_center_volumn_persent).text(s).visible();
    }


    /**
     * 快进快退
     *
     * @param percent
     */
    private void onProgressSlide(float percent) {
        long position = videoView.getCurrentPosition();
        long duration = videoView.getDuration();
        long deltaMax = Math.min(100 * 1000, duration - position);
        long delta = (long) (deltaMax * percent);


        newPosition = delta + position;
        if (newPosition > duration) {
            newPosition = duration;
        } else if (newPosition <= 0) {
            newPosition = 0;
            delta = -position;
        }
        int showDelta = (int) delta / 1000;
        if (showDelta != 0) {
            $.id(R.id.player_center_fast_layout).visible();
            $.id(R.id.player_center_fast_mig).visible();
            $.id(R.id.player_center_fast_persent).visible();
            $.id(R.id.player_center_brightness_layout).gone();
            $.id(R.id.player_center_volumn_layout).gone();
            String text = showDelta > 0 ? ("+" + showDelta) : "" + showDelta;
            $.id(R.id.player_center_fast_persent).text(generateTime(newPosition) + "/" + generateTime(duration));
        }
        if (showDelta > 0) {
            $.id(R.id.player_center_fast_mig).image(R.drawable.player_fast_forward);
        } else {
            $.id(R.id.player_center_fast_mig).image(R.drawable.player_fast_reverse);
        }
    }

    /**
     * 滑动改变亮度
     *
     * @param percent
     */
    private void onBrightnessSlide(float percent) {
        if (brightness < 0) {
            brightness = activity.getWindow().getAttributes().screenBrightness;
            if (brightness <= 0.00f) {
                brightness = 0.50f;
            } else if (brightness < 0.01f) {
                brightness = 0.01f;
            }
        }
        $.id(R.id.player_center_brightness_layout).visible();
        $.id(R.id.player_center_brightness_persent).visible();
        $.id(R.id.player_center_brightness_layout).visible();
        $.id(R.id.player_center_fast_layout).gone();
        $.id(R.id.player_center_volumn_layout).gone();
        WindowManager.LayoutParams lpa = activity.getWindow().getAttributes();
        lpa.screenBrightness = brightness + percent;
        if (lpa.screenBrightness > 1.0f) {
            lpa.screenBrightness = 1.0f;
        } else if (lpa.screenBrightness < 0.01f) {
            lpa.screenBrightness = 0.01f;
        }
        $.id(R.id.player_center_brightness_persent).text(((int) (lpa.screenBrightness * 100)) + "%");
        activity.getWindow().setAttributes(lpa);

    }

    /**
     * 显示控制层布局
     *
     * @param timeout
     */
    public void show(int timeout) {
        if (entity != null) {
            if (!isShowingControllerLayout) {
                $.id(R.id.player_top_layout).visible();
                showBottomControl(true);
                isShowingControllerLayout = true;
            }
            handler.sendEmptyMessage(MESSAHE_SHOW_PROGRESS);
            handler.removeMessages(MESSAHE_FADE_OUT);
            if (timeout != 0) {
                handler.sendMessageDelayed(handler.obtainMessage(MESSAHE_FADE_OUT), timeout);
            }
        }


    }

    /**
     * 隐藏控制层布局
     */
    public void hide() {
        if (isShowingControllerLayout) {
            handler.removeMessages(MESSAHE_SHOW_PROGRESS);
            showBottomControl(false);
            $.id(R.id.player_top_layout).gone();
            isShowingControllerLayout = false;
        }
    }

    private void showBottomControl(boolean show) {
        if (entity != null) {
            if (show) {
                if (isScreenPortrait()) {//半屏
                    if (entity.isLive()) {
                        $.id(R.id.player_bottom_layout).visible();
                        $.id(R.id.player_bottom_play_btn).visible();
                        $.id(R.id.player_bottom_start_time).invisible();
                        $.id(R.id.player_bottom_end_time).invisible();
                        $.id(R.id.player_bottom_seekbar).invisible();
                        $.id(R.id.player_bottom_full_btn).visible();
                    } else {
                        $.id(R.id.player_bottom_layout).visible();
                        $.id(R.id.player_bottom_play_btn).visible();
                        $.id(R.id.player_bottom_start_time).visible();
                        $.id(R.id.player_bottom_end_time).visible();
                        $.id(R.id.player_bottom_seekbar).visible();
                        $.id(R.id.player_bottom_full_btn).visible();
                    }
                } else {//全屏
                    if (entity.isLive()) {
                        $.id(R.id.player_bottom_layout).visible();
                        $.id(R.id.player_bottom_play_btn).visible();
                        $.id(R.id.player_bottom_start_time).invisible();
                        $.id(R.id.player_bottom_end_time).invisible();
                        $.id(R.id.player_bottom_seekbar).invisible();
                        $.id(R.id.player_bottom_full_btn).invisible();

                    } else {
                        $.id(R.id.player_bottom_layout).visible();
                        $.id(R.id.player_bottom_play_btn).visible();
                        $.id(R.id.player_bottom_start_time).visible();
                        $.id(R.id.player_bottom_seekbar).visible();
                        $.id(R.id.player_bottom_end_time).visible();
                        $.id(R.id.player_bottom_full_btn).gone();

                    }
                }
            } else {
                $.id(R.id.player_bottom_layout).gone();
            }
        }
    }

    /**
     * 隐藏所有布局
     */
    private void hideAll() {
        $.id(R.id.player_bottom_layout).gone();
        $.id(R.id.player_top_layout).gone();
        $.id(R.id.player_default_image).gone();
        hideLoadingProgress();
    }

    public void showLoadingProgress() {

        $.id(R.id.player_loading_bar).visible();
        RotateAnimation loadAnimation = (RotateAnimation) AnimationUtils.loadAnimation(activity, R.anim.rotate_vieo_loading);
        $.id(R.id.player_loading_bar).view.setAnimation(loadAnimation);
        loadAnimation.start();
    }

    public void hideLoadingProgress() {
        $.id(R.id.player_loading_bar).gone();
        $.id(R.id.player_loading_bar).view.clearAnimation();

    }

    /**
     * 是否是半屏
     *
     * @return
     */
    private boolean isScreenPortrait() {
        return activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }

    class Query {

        public View view;

        public Query() {

        }

        public Query id(int id) {
            view = playLayoutView.findViewById(id);
            return this;
        }

        public Query image(int resId) {
            if (view instanceof ImageView) {
                ((ImageView) view).setImageResource(resId);
            }
            return this;
        }

        public Query visible() {
            if (view != null) {
                view.setVisibility(View.VISIBLE);
            }
            return this;
        }

        public Query gone() {
            if (view != null) {
                view.setVisibility(View.GONE);
            }
            return this;
        }

        public Query invisible() {
            if (view != null) {
                view.setVisibility(View.INVISIBLE);
            }
            return this;
        }

        public Query visibility(int visible) {
            if (view != null) {
                view.setVisibility(visible);
            }
            return this;
        }

        public Query clicked(View.OnClickListener handler) {
            if (view != null) {
                view.setOnClickListener(handler);
            }
            return this;
        }

        public Query text(CharSequence text) {
            if (view != null && view instanceof TextView) {
                ((TextView) view).setText(text);
            }
            return this;
        }

        public String getText() {
            if (view != null && view instanceof TextView) {
                return ((TextView) view).getText().toString();
            }
            return null;
        }
    }


    /**
     * 获取屏幕宽度
     */
    public int getScreenWidthPixels(Activity context) {
        DisplayMetrics metric = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric.widthPixels;
    }

    /**
     * 获取屏幕高度
     */
    public int getScreenHeightPixels(Activity context) {
        DisplayMetrics metric = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric.heightPixels;
    }


    class InternetReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null) {
                // 网络状态变化
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    doReceiveInternetChange();
                }
            }
        }
    }


    private synchronized void doReceiveInternetChange() {
        if (videoView.isPlaying() || status == STATUS_PAUSE) {
            NetworkInfo info = getNetworkInfo();
            if (info != null) {
                int type = info.getType();
                if (type != ConnectivityManager.TYPE_WIFI) {
                    doPauseVideo();
                    showInternetHint();

                } else {
                    // wifi网络

                    if (status == STATUS_PAUSE) {
                        doStartVideo();
                    }
                }
            } else {
                // 无网络
                doPauseVideo();

            }
        }

    }


    public void showInternetHint() {
//        if (mNetworkHintDialog == null || !mNetworkHintDialog.isShowing()) {
//            mNetworkHintDialog = new SimpleDialogUtil(activity);
//            mNetworkHintDialog
//                    .setMessage(activity.getString(R.string.use_network_hint))
//                    .setNegativeButtom("确定", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            doStartVideo();
//                            mNetworkHintDialog.dismiss();
//                        }
//                    })
//                    .setPositiveButtom("取消", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            mNetworkHintDialog.dismiss();
//                            activity.finish();
//                        }
//                    });
//            mNetworkHintDialog.show();
//        }
    }

    /**
     * 3G 2G 4G网络
     */
    public boolean isTypeInternet() {
        NetworkInfo info = getNetworkInfo();
        if (info != null) {
            int type = info.getType();
            if (type != ConnectivityManager.TYPE_WIFI) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取网络信息
     *
     * @return
     */
    private NetworkInfo getNetworkInfo() {
        ConnectivityManager connectivityManager = (ConnectivityManager) activity
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        return info;
    }

    public synchronized void doUnregisterReceiver() {
        try {
            if (isRegisterNet) {
                if (internetReceiver != null) {
                    activity.unregisterReceiver(internetReceiver);
                    isRegisterNet = false;
                }
            }

        } catch (Exception e) {
        }

    }

    public synchronized void doRegisterInter() {
        try {
            if (!isRegisterNet) {
                isRegisterNet = true;
                internetReceiver = new InternetReceiver();
                IntentFilter filter = new IntentFilter();
                // 网络监听
                filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                filter.addAction("android.media.VOLUME_CHANGED_ACTION");
                activity.registerReceiver(internetReceiver, filter);
            }
        } catch (Exception e) {
        }
    }

}
