package com.annie.annieforchild.entity;

public class StroyBean {
    public  String imageUrl;
    public  String title;
    public  String collectTv;
    public  String addBookTv;
    public  String addTableTv;
    public  String number;

    public StroyBean(String imageUrl, String title, String collectTv, String addBookTv, String addTableTv, String number) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.collectTv = collectTv;
        this.addBookTv = addBookTv;
        this.addTableTv = addTableTv;
        this.number = number;
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

    public String getCollectTv() {
        return collectTv;
    }

    public void setCollectTv(String collectTv) {
        this.collectTv = collectTv;
    }

    public String getAddBookTv() {
        return addBookTv;
    }

    public void setAddBookTv(String addBookTv) {
        this.addBookTv = addBookTv;
    }

    public String getAddTableTv() {
        return addTableTv;
    }

    public void setAddTableTv(String addTableTv) {
        this.addTableTv = addTableTv;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
