package com.example.cat.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(createInDb = false, nameInDb = "cat_attr")
public class CatAttrBean {
    @Property
    String field1;
    @Property(nameInDb = "field2")
    String theme;
    @Property
    String field3;
    @Property
    String field4;
    @Property
    String field5;
    @Property
    String field6;
    @Property
    String field7;

    @Generated(hash = 1490816519)
    public CatAttrBean(String field1, String theme, String field3, String field4,
                       String field5, String field6, String field7) {
        this.field1 = field1;
        this.theme = theme;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
        this.field6 = field6;
        this.field7 = field7;
    }

    @Generated(hash = 1372507243)
    public CatAttrBean() {
    }

    public String getField1() {
        return this.field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }


    public String getField3() {
        return this.field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return this.field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return this.field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public String getField6() {
        return this.field6;
    }

    public void setField6(String field6) {
        this.field6 = field6;
    }

    public String getField7() {
        return this.field7;
    }

    public void setField7(String field7) {
        this.field7 = field7;
    }

    @Override
    public String toString() {
        return "CatAttrBean{" +
                "field1='" + field1 + '\'' +
                ", field2='" + theme + '\'' +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5='" + field5 + '\'' +
                ", field6='" + field6 + '\'' +
                ", field7='" + field7 + '\'' +
                '}';
    }

    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
