package com.annie.annieforchild.entity;

import java.util.List;

public class HomeAnimitorBean {


//    public int type;
//    public int id;
//    public String title;
//    public List<HomeAnimitorBean> animitor;
//
//    public HomeAnimitorBean(int type, int id, String title, List<HomeAnimitorBean> animitor) {
//        this.type = type;
//        this.id = id;
//        this.title = title;
//        this.animitor = animitor;
//    }

    public int id;
    public int type;
    public String imageUrl;
    public String title;

    public HomeAnimitorBean(int id, String imageUrl, String title) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
