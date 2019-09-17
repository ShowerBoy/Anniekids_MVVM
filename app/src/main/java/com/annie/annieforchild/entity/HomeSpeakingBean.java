package com.annie.annieforchild.entity;

/**
 * Created by shen
 * on 2019/8/27
 */


public class HomeSpeakingBean {

    public int id;
    public String title;
    public  String imageUrl;

    public HomeSpeakingBean(int id, String title, String imageUrl) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
