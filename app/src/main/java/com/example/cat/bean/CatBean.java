package com.example.cat.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(createInDb = false,nameInDb = "cat")
public class CatBean {

    @Id
    String theme;

    @Property
    String type;
    @Property
    String ear;

    @Property
    String eye;
    @Property
    String mouse;

    @Property
    String huawen;
    @Property
    String skin;
    @Property
    String tail;

    @Generated(hash = 1348218743)
    public CatBean(String theme, String type, String ear, String eye, String mouse,
                   String huawen, String skin, String tail) {
        this.theme = theme;
        this.type = type;
        this.ear = ear;
        this.eye = eye;
        this.mouse = mouse;
        this.huawen = huawen;
        this.skin = skin;
        this.tail = tail;
    }

    @Generated(hash = 1152680801)
    public CatBean() {
    }

    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEar() {
        return this.ear;
    }

    public void setEar(String ear) {
        this.ear = ear;
    }

    public String getEye() {
        return this.eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public String getMouse() {
        return this.mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public String getHuawen() {
        return this.huawen;
    }

    public void setHuawen(String huawen) {
        this.huawen = huawen;
    }

    public String getSkin() {
        return this.skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getTail() {
        return this.tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }


    @Override
    public String toString() {
        return "CatBean{" +
                "theme='" + theme + '\'' +
                ", type='" + type + '\'' +
                ", ear='" + ear + '\'' +
                ", eye='" + eye + '\'' +
                ", mouse='" + mouse + '\'' +
                ", huawen='" + huawen + '\'' +
                ", skin='" + skin + '\'' +
                ", tail='" + tail + '\'' +
                '}';
    }
}
