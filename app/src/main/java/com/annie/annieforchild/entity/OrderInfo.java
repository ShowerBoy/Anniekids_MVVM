package com.annie.annieforchild.entity;

import java.util.List;

public class OrderInfo {
    private String nextTime;
    private List<MyNetClazz> myNetClass;
    private int todoNum;

    public String getNextTime() {
        return nextTime;
    }

    public void setNextTime(String nextTime) {
        this.nextTime = nextTime;
    }

    public List<MyNetClazz> getMyNetClass() {
        return myNetClass;
    }

    public void setMyNetClass(List<MyNetClazz> myNetClass) {
        this.myNetClass = myNetClass;
    }

    public int getTodoNum() {
        return todoNum;
    }

    public void setTodoNum(int todoNum) {
        this.todoNum = todoNum;
    }
}
