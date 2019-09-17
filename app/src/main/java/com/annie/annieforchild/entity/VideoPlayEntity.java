package com.annie.annieforchild.entity;

/**
 * Created by shen
 * on 2019/8/27
 */


public class VideoPlayEntity {

    private String title;

    private String url;


    private boolean isLive;

    private int imageResc;

    public VideoPlayEntity(String title, String url, boolean isLive, int imageResc) {
        this.title = title;
        this.url = url;
        this.isLive = isLive;
        this.imageResc = imageResc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public int getImageResc() {
        return imageResc;
    }

    public void setImageResc(int imageResc) {
        this.imageResc = imageResc;
    }
}
