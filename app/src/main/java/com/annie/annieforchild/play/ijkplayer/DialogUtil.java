package com.annie.annieforchild.play.ijkplayer;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.annie.annieforchild.R;


/**
 *
 * @Description:  图片选择D
 */


public class DialogUtil extends Dialog {


    private Listener mListener;

    public DialogUtil(Context context, Listener l, String text) {
        super(context, R.style.style_dialog);
        setContentView(R.layout.pop_tips);

        Window window = getWindow();
        window.setGravity(Gravity.CENTER);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        mListener = l;

        TextView tipTv = (TextView) findViewById(R.id.tv_tip);
        tipTv.setText(text);
        TextView cancel = (TextView) findViewById(R.id.btn_cancel);
        TextView ok = (TextView) findViewById(R.id.btn_ok);
        cancel.setText("取消");
        ok.setText("确定");

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener!=null){
                    mListener.cancel();
                }
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener!=null){
                    mListener.ok();
                }
            }
        });





    }

    public interface Listener {
        void ok();
        void cancel();
    }

}
