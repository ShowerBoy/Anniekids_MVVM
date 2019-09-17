package com.annie.annieforchild.entity;


public class HomeGrideBean {

//    public int type;
//    public int id;
//    public String title;
//    public List<HomeGrideBean> grideList;
//
//    public HomeGrideBean(int type, int id, String title, List<HomeGrideBean> grideList) {
//        this.type = type;
//        this.id = id;
//        this.title = title;
//        this.grideList = grideList;
//    }

    public int type;
    public int resId;
    public String title;


    public HomeGrideBean(int type, int resId, String title) {
        this.type = type;
        this.resId = resId;
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
