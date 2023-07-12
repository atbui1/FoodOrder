package com.ui.foodorder.model;

public class Member {
    private String title;
    private int point;
    private int status;

    public Member(String title, int point, int status) {
        this.title = title;
        this.point = point;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
