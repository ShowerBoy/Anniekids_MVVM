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

    public HomeAnimitorBean(int id, String imageUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
    }
}
