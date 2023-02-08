package com.example.cat.bean;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

public class PicBean {

    public int url;
    public String theme;


    public PicBean(int url, String theme) {
        this.url = url;
        this.theme = theme;
    }
}
