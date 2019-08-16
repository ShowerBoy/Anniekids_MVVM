package com.annie.annieforchild.entity;

import java.util.List;

public class RecommendBean {
    private String tagName;
    private List<Book> dataList;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<Book> getDataList() {
        return dataList;
    }

    public void setDataList(List<Book> dataList) {
        this.dataList = dataList;
    }
}
