package com.annie.annieforchild.entity;

public class Book {
    private String bookName;
    private String bookImageUrl;
    private int bookId;
    private int browseNums;
    private int appType;
    private int jurisdiction;
    private int isAnimation;
    private int isShowPk;
    private int isShowRank;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookImageUrl() {
        return bookImageUrl;
    }

    public void setBookImageUrl(String bookImageUrl) {
        this.bookImageUrl = bookImageUrl;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBrowseNums() {
        return browseNums;
    }

    public void setBrowseNums(int browseNums) {
        this.browseNums = browseNums;
    }

    public int getAppType() {
        return appType;
    }

    public void setAppType(int appType) {
        this.appType = appType;
    }

    public int getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(int jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public int getIsAnimation() {
        return isAnimation;
    }

    public void setIsAnimation(int isAnimation) {
        this.isAnimation = isAnimation;
    }

    public int getIsShowPk() {
        return isShowPk;
    }

    public void setIsShowPk(int isShowPk) {
        this.isShowPk = isShowPk;
    }

    public int getIsShowRank() {
        return isShowRank;
    }

    public void setIsShowRank(int isShowRank) {
        this.isShowRank = isShowRank;
    }
}
