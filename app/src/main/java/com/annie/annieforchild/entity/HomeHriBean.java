package com.annie.annieforchild.entity;

public class HomeHriBean {

    public  int type;
    public  String imageUrl;

    public HomeHriBean(int type, String imageUrl) {
        this.type = type;
        this.imageUrl = imageUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
