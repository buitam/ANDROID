package com.t3h.bai1;

import java.util.Date;

public class New {
    private String title;
    private String linkDetail;
    private String imgLink;
    private String date;

    public New(String title, String linkDetail, String imgLink, String date) {
        this.title = title;
        this.linkDetail = linkDetail;
        this.imgLink = imgLink;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getLinkDetail() {
        return linkDetail;
    }

    public String getImgLink() {
        return imgLink;
    }

    public String getDate() {
        return date;
    }

    public void inThongTin(){
        System.out.println("Title: " + title);
        System.out.println("Link Detail: " + linkDetail);
        System.out.println("Img Link: " + imgLink);
        System.out.println("Date: " + date);
    }
}
