package edu.xyc.greendao.utils;

import android.database.sqlite.SQLiteDatabase;

import edu.xyc.greendao.base.MyApplication;
import edu.xyc.greendao.database.DaoMaster;
import edu.xyc.greendao.database.DaoSession;

public class GreenDaoManager {

    private static GreenDaoManager mInstance;

    /**
     * 创建数据库的工具
     */
    private SQLiteOpenHelper mSQLiteOpenHelper;

    /**
     * 保存数据库对象
     */
    private DaoMaster mDaoMaster;

    /**
     * 通过DaoSession我们可以操作一个数据库里面的表的增删查改操作
     */
    private DaoSession mDaoSession;

    /**
     * 数据库的名称
     */
    private String mDataBaseName = "xyc.db";

    private GreenDaoManager() {
        if (null == mInstance) {
            init();
        }
    }

    private void init() {
        // 创建数据库
        mSQLiteOpenHelper = new SQLiteOpenHelper(MyApplication.getContext(), mDataBaseName, null);
        // 获取可写数据库
        SQLiteDatabase db = mSQLiteOpenHelper.getWritableDatabase();
        // 获取保存数据库对象
        mDaoMaster = new DaoMaster(db);
        // 获取dao对象管理者
        mDaoSession = mDaoMaster.newSession();
    }

    public static GreenDaoManager getInstance() {
        if (null == mInstance) {
            synchronized (GreenDaoManager.class) {
                if (null == mInstance) {
                    mInstance = new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }

    public DaoMaster getDaoMaster() {
        return mDaoMaster;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    /**
     * 关闭所有的操作,数据库开启后,使用完毕要关闭
     */
    public void closeConnection() {
        closeHelper();
        closeDaoSession();
    }

    private void closeHelper() {
        if (null != mSQLiteOpenHelper) {
            mSQLiteOpenHelper.close();
            mSQLiteOpenHelper = null;
        }
    }

    private void closeDaoSession() {
        if (null != mDaoSession) {
            mDaoSession.clear();
            mDaoSession = null;
        }
    }
}
