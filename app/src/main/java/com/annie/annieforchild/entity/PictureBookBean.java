package com.annie.annieforchild.entity;

/**
 * Created by shen
 * on 2019/8/31
 */


public class PictureBookBean {

    private  String image;
    private  String title;
    private  String number;

    public PictureBookBean(String image, String title, String number) {
        this.image = image;
        this.title = title;
        this.number = number;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
