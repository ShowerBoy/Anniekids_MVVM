package com.annie.annieforchild.entity;

import java.util.List;

public class ResourceBean {
    private String title;
    private String subtitle;
    private List<Book> resourceList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List<Book> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Book> resourceList) {
        this.resourceList = resourceList;
    }
}
