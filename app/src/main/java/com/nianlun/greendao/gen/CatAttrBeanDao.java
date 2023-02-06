package com.nianlun.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.cat.bean.CatAttrBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "cat_attr".
*/
public class CatAttrBeanDao extends AbstractDao<CatAttrBean, Void> {

    public static final String TABLENAME = "cat_attr";

    /**
     * Properties of entity CatAttrBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Field1 = new Property(0, String.class, "field1", false, "FIELD1");
        public final static Property Theme = new Property(1, String.class, "theme", false, "field2");
        public final static Property Field3 = new Property(2, String.class, "field3", false, "FIELD3");
        public final static Property Field4 = new Property(3, String.class, "field4", false, "FIELD4");
        public final static Property Field5 = new Property(4, String.class, "field5", false, "FIELD5");
        public final static Property Field6 = new Property(5, String.class, "field6", false, "FIELD6");
        public final static Property Field7 = new Property(6, String.class, "field7", false, "FIELD7");
    }


    public CatAttrBeanDao(DaoConfig config) {
        super(config);
    }
    
    public CatAttrBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CatAttrBean entity) {
        stmt.clearBindings();
 
        String field1 = entity.getField1();
        if (field1 != null) {
            stmt.bindString(1, field1);
        }
 
        String theme = entity.getTheme();
        if (theme != null) {
            stmt.bindString(2, theme);
        }
 
        String field3 = entity.getField3();
        if (field3 != null) {
            stmt.bindString(3, field3);
        }
 
        String field4 = entity.getField4();
        if (field4 != null) {
            stmt.bindString(4, field4);
        }
 
        String field5 = entity.getField5();
        if (field5 != null) {
            stmt.bindString(5, field5);
        }
 
        String field6 = entity.getField6();
        if (field6 != null) {
            stmt.bindString(6, field6);
        }
 
        String field7 = entity.getField7();
        if (field7 != null) {
            stmt.bindString(7, field7);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CatAttrBean entity) {
        stmt.clearBindings();
 
        String field1 = entity.getField1();
        if (field1 != null) {
            stmt.bindString(1, field1);
        }
 
        String theme = entity.getTheme();
        if (theme != null) {
            stmt.bindString(2, theme);
        }
 
        String field3 = entity.getField3();
        if (field3 != null) {
            stmt.bindString(3, field3);
        }
 
        String field4 = entity.getField4();
        if (field4 != null) {
            stmt.bindString(4, field4);
        }
 
        String field5 = entity.getField5();
        if (field5 != null) {
            stmt.bindString(5, field5);
        }
 
        String field6 = entity.getField6();
        if (field6 != null) {
            stmt.bindString(6, field6);
        }
 
        String field7 = entity.getField7();
        if (field7 != null) {
            stmt.bindString(7, field7);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public CatAttrBean readEntity(Cursor cursor, int offset) {
        CatAttrBean entity = new CatAttrBean( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // field1
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // theme
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // field3
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // field4
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // field5
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // field6
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // field7
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CatAttrBean entity, int offset) {
        entity.setField1(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setTheme(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setField3(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setField4(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setField5(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setField6(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setField7(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(CatAttrBean entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(CatAttrBean entity) {
        return null;
    }

    @Override
    public boolean hasKey(CatAttrBean entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
