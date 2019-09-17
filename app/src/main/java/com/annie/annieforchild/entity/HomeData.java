package com.annie.annieforchild.entity;

import java.util.List;

public class HomeData {
    private List<Banner> banner;
    private OrderInfo orderInfo;
    private List<RecommendBean> recommend;
    private List<AnimationBean> animation;
    private List<Label> label;
    private List<ResourceBean> resource;

    public List<Banner> getBanner() {
        return banner;
    }

    public void setBanner(List<Banner> banner) {
        this.banner = banner;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public List<RecommendBean> getRecommend() {
        return recommend;
    }

    public void setRecommend(List<RecommendBean> recommend) {
        this.recommend = recommend;
    }

    public List<AnimationBean> getAnimation() {
        return animation;
    }

    public void setAnimation(List<AnimationBean> animation) {
        this.animation = animation;
    }

    public List<Label> getLabel() {
        return label;
    }

    public void setLabel(List<Label> label) {
        this.label = label;
    }

    public List<ResourceBean> getResource() {
        return resource;
    }

    public void setResource(List<ResourceBean> resource) {
        this.resource = resource;
    }

}
