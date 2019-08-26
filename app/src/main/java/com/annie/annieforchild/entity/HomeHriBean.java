package com.annie.annieforchild.entity;

public class HomeHriBean {

    public  int type;
    public  String url;

    public HomeHriBean(int type, String url) {
        this.type = type;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
