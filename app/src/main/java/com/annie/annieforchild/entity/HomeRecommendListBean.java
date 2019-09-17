package com.annie.annieforchild.entity;



public class HomeRecommendListBean {

    public int id;
    public int type;
    public String imageUrl;
    public  String title;

    public HomeRecommendListBean(int id,  String imageUrl, String title) {
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
