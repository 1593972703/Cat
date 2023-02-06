package com.example.cat.greendao;

import com.example.cat.bean.CatBean;
import com.nianlun.greendao.gen.CatBeanDao;

/**
 * 初始化、存放及获取DaoUtils
 */
public class DaoUtilsStore {
    private volatile static DaoUtilsStore instance = new DaoUtilsStore();
    private CommonDaoUtils<CatBean> mUserDaoUtils;

    public static DaoUtilsStore getInstance() {
        return instance;
    }

    private DaoUtilsStore() {
        DaoManager mManager = DaoManager.getInstance();
        CatBeanDao _UserDao = mManager.getDaoSession().getCatBeanDao();
        mUserDaoUtils = new CommonDaoUtils(CatBean.class, _UserDao);
    }

    public CommonDaoUtils<CatBean> getUserDaoUtils() {
        return mUserDaoUtils;
    }

}
