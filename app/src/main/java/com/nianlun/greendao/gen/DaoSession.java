package com.nianlun.greendao.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.cat.bean.CatAttrBean;
import com.example.cat.bean.CatBean;

import com.nianlun.greendao.gen.CatAttrBeanDao;
import com.nianlun.greendao.gen.CatBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig catAttrBeanDaoConfig;
    private final DaoConfig catBeanDaoConfig;

    private final CatAttrBeanDao catAttrBeanDao;
    private final CatBeanDao catBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        catAttrBeanDaoConfig = daoConfigMap.get(CatAttrBeanDao.class).clone();
        catAttrBeanDaoConfig.initIdentityScope(type);

        catBeanDaoConfig = daoConfigMap.get(CatBeanDao.class).clone();
        catBeanDaoConfig.initIdentityScope(type);

        catAttrBeanDao = new CatAttrBeanDao(catAttrBeanDaoConfig, this);
        catBeanDao = new CatBeanDao(catBeanDaoConfig, this);

        registerDao(CatAttrBean.class, catAttrBeanDao);
        registerDao(CatBean.class, catBeanDao);
    }
    
    public void clear() {
        catAttrBeanDaoConfig.clearIdentityScope();
        catBeanDaoConfig.clearIdentityScope();
    }

    public CatAttrBeanDao getCatAttrBeanDao() {
        return catAttrBeanDao;
    }

    public CatBeanDao getCatBeanDao() {
        return catBeanDao;
    }

}
