package com.example.mah;

public class Listitem {
    private String head;
    private String desc;
    private int imageurl;

    public Listitem(String head, String desc, int imageurl) {
        this.head = head;
        this.desc = desc;
        this.imageurl=imageurl;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getDesc() {
        return desc;
    }

    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
