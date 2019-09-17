package com.annie.annieforchild.entity;

import com.annie.annieforchild.view.loopPager.LooperBaseBean;

public class Banner  extends  LooperBaseBean {
//    private String url;
//    private String imageUrl;
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }


    public String imageUrl;
    public  int id;

    public Banner(String imageUrl, int id) {
        this.imageUrl = imageUrl;
        this.id = id;
    }

    @Override
    public String getImgUrl() {
        return imageUrl;
    }
}
