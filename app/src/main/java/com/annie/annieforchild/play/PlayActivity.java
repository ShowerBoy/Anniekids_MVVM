package com.annie.annieforchild.play;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.annie.annieforchild.R;
import com.annie.annieforchild.entity.VideoPlayEntity;
import com.annie.annieforchild.play.ijkplayer.IjkVideoView;


public class PlayActivity extends AppCompatActivity {

    private String test = "http://101.201.103.171:8091/uploads/video/20180320/bb.mp4";
    private PlayerPresenter playerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        initView();
    }

    private void initView(){

//        JzvdStd myJzvdStd = findViewById(R.id.videoplayer);
//        myJzvdStd.setUp("http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4"
//                , "饺子快长大", JzvdStd.SCREEN_NORMAL);
//        Glide.with(this).load("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png").into(myJzvdStd.thumbImageView);
        IjkVideoView playerView = findViewById(R.id.player_ijk_view);
        playerPresenter = new PlayerPresenter(this,findViewById(R.id.video_player_container));
        playerPresenter.requestPlay(new VideoPlayEntity("视频测试",test,false, R.drawable.login_background));
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (playerPresenter!=null){
            playerPresenter.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (playerPresenter!=null){
            playerPresenter.onDestory();
        }

    }

    @Override
    public void onBackPressed() {
        if (playerPresenter!=null && playerPresenter.onBackPressed()){
            return;
        }
        super.onBackPressed();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

}
