package com.nianlun.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.cat.bean.CatBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "cat".
*/
public class CatBeanDao extends AbstractDao<CatBean, String> {

    public static final String TABLENAME = "cat";

    /**
     * Properties of entity CatBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Theme = new Property(0, String.class, "theme", true, "THEME");
        public final static Property Type = new Property(1, String.class, "type", false, "TYPE");
        public final static Property Ear = new Property(2, String.class, "ear", false, "EAR");
        public final static Property Eye = new Property(3, String.class, "eye", false, "EYE");
        public final static Property Mouse = new Property(4, String.class, "mouse", false, "MOUSE");
        public final static Property Huawen = new Property(5, String.class, "huawen", false, "HUAWEN");
        public final static Property Skin = new Property(6, String.class, "skin", false, "SKIN");
        public final static Property Tail = new Property(7, String.class, "tail", false, "TAIL");
        public final static Property Picname = new Property(8, String.class, "picname", false, "PICNAME");
    }


    public CatBeanDao(DaoConfig config) {
        super(config);
    }
    
    public CatBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CatBean entity) {
        stmt.clearBindings();
 
        String theme = entity.getTheme();
        if (theme != null) {
            stmt.bindString(1, theme);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(2, type);
        }
 
        String ear = entity.getEar();
        if (ear != null) {
            stmt.bindString(3, ear);
        }
 
        String eye = entity.getEye();
        if (eye != null) {
            stmt.bindString(4, eye);
        }
 
        String mouse = entity.getMouse();
        if (mouse != null) {
            stmt.bindString(5, mouse);
        }
 
        String huawen = entity.getHuawen();
        if (huawen != null) {
            stmt.bindString(6, huawen);
        }
 
        String skin = entity.getSkin();
        if (skin != null) {
            stmt.bindString(7, skin);
        }
 
        String tail = entity.getTail();
        if (tail != null) {
            stmt.bindString(8, tail);
        }
 
        String picname = entity.getPicname();
        if (picname != null) {
            stmt.bindString(9, picname);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CatBean entity) {
        stmt.clearBindings();
 
        String theme = entity.getTheme();
        if (theme != null) {
            stmt.bindString(1, theme);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(2, type);
        }
 
        String ear = entity.getEar();
        if (ear != null) {
            stmt.bindString(3, ear);
        }
 
        String eye = entity.getEye();
        if (eye != null) {
            stmt.bindString(4, eye);
        }
 
        String mouse = entity.getMouse();
        if (mouse != null) {
            stmt.bindString(5, mouse);
        }
 
        String huawen = entity.getHuawen();
        if (huawen != null) {
            stmt.bindString(6, huawen);
        }
 
        String skin = entity.getSkin();
        if (skin != null) {
            stmt.bindString(7, skin);
        }
 
        String tail = entity.getTail();
        if (tail != null) {
            stmt.bindString(8, tail);
        }
 
        String picname = entity.getPicname();
        if (picname != null) {
            stmt.bindString(9, picname);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public CatBean readEntity(Cursor cursor, int offset) {
        CatBean entity = new CatBean( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // theme
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // type
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // ear
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // eye
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // mouse
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // huawen
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // skin
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // tail
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // picname
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CatBean entity, int offset) {
        entity.setTheme(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setType(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setEar(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setEye(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setMouse(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setHuawen(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setSkin(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setTail(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setPicname(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    @Override
    protected final String updateKeyAfterInsert(CatBean entity, long rowId) {
        return entity.getTheme();
    }
    
    @Override
    public String getKey(CatBean entity) {
        if(entity != null) {
            return entity.getTheme();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(CatBean entity) {
        return entity.getTheme() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
