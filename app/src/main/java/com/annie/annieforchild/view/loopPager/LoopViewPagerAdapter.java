package com.annie.annieforchild.view.loopPager;

import android.content.res.Resources;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.annie.annieforchild.R;
import com.annie.annieforchild.utils.ImageLoader;
import com.annie.annieforchild.utils.glide.HolderType;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.base.BaseApplication;

/**
 * 适配
 */
public class LoopViewPagerAdapter extends BaseLoopPagerAdapter {

    private final List<LooperBaseBean> mPoints;

    private final ViewGroup mIndicators;

    private int mLastPosition;

    private LoopViewClickListener mLoopViewClickListener;

    private boolean isShowTitle;//是否需要显示标题，默认不需要，微视频需要显示标题

    public LoopViewPagerAdapter(ViewPager viewPager, ViewGroup indicators) {
        super(viewPager);
        mIndicators = indicators;
        mPoints = new ArrayList<>();
    }

    public void setIsShowTitile(boolean b){
        this.isShowTitle = b;
    }

    public void setList(List<? extends LooperBaseBean> points) {
        mPoints.clear();
        mPoints.addAll(points);
        notifyDataSetChanged();
    }

    /**
     * oh shit! An indicator view is badly needed!
     * this shit have no animation at all.
     */
    private void initIndicators() {
        if (mIndicators.getChildCount() != mPoints.size() && mPoints.size() > 1) {
            mIndicators.removeAllViews();
            Resources res = mIndicators.getResources();
            int margin = res.getDimensionPixelOffset(R.dimen.indicator_margin);
            for (int i = 0; i < getPagerCount(); i++) {
                ImageView indicator = new ImageView(mIndicators.getContext());
                indicator.setAlpha(180);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(margin, 0, 0, 0);
                lp.gravity = Gravity.CENTER;
                indicator.setLayoutParams(lp);
                indicator.setImageResource(R.drawable.viewpager_indicator_n);
                mIndicators.addView(indicator);
            }
        }
    }

    @Override
    public void notifyDataSetChanged() {
        initIndicators();
        super.notifyDataSetChanged();
    }

    @Override
    public int getPagerCount() {
        return mPoints.size();
    }

    @Override
    public LooperBaseBean getItem(int position) {
        return mPoints.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewpager, parent, false);
            holder = new ViewHolder();
            holder.ivBanner = (ImageView) convertView.findViewById(R.id.ivBanner);
//            holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mLoopViewClickListener!=null){
                    mLoopViewClickListener.callback(position);
                }
            }
        });


//        if(isShowTitle){
//            holder.tvName.setVisibility(View.VISIBLE);
//            if(!TextUtils.isEmpty(mPoints.get(position).getTile())){
//                holder.tvName.setText(mPoints.get(position).getTile());
//            }
//        }else {
//            holder.tvName.setVisibility(View.GONE);
//        }

        new ImageLoader(BaseApplication.getInstance(),holder.ivBanner,mPoints.get(position).getImgUrl()).holderType( HolderType.RECTANGEL_IMAGE).show();

        // FIXME: 17/1/5   待检查
        return convertView;
    }

    @Override
    public void onPageItemSelected(int position) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
//            mIndicators.getChildAt(mLastPosition).setActivated(false);
//            mIndicators.getChildAt(position).setActivated(true);
            ((ImageView)mIndicators.getChildAt(mLastPosition)).setImageResource(R.drawable.viewpager_indicator_n);
            ((ImageView)mIndicators.getChildAt(position)).setImageResource(R.drawable.viewpager_indicator_s);
        }
        mLastPosition = position;
    }

    public static class ViewHolder {
        ImageView ivBanner;
        TextView tvName;
    }

    public void setLoopViewClickListener(LoopViewClickListener loopViewClickListener){
        mLoopViewClickListener = loopViewClickListener;
    }

    public interface LoopViewClickListener{
        void callback(int position);
    }
}
