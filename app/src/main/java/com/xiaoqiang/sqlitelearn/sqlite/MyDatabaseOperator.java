package com.xiaoqiang.sqlitelearn.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.xiaoqiang.sqlitelearn.sqlite.TablesContract.TrainTable;
import com.xiaoqiang.sqlitelearn.sqlite.TablesContract.UserTable;
import com.xiaoqiang.sqlitelearn.sqlite.bean.TrainBean;
import com.xiaoqiang.sqlitelearn.sqlite.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 应用层使用到的数据库操作类
 * Created by crx on 2017/12/7.
 */

public class MyDatabaseOperator {
    private static DatabaseManager manager;

    public MyDatabaseOperator(){
        manager = DatabaseManager.getInstance();
    }

    //保存用户资料
    public boolean saveUser(UserBean userBean){
        SQLiteDatabase database = manager.openDatabase();
        ContentValues values = new ContentValues();
        values.put(UserTable.COLUMN_ID, userBean.getId());
        values.put(UserTable.COLUMN_NAME, userBean.getName());
        values.put(UserTable.COLUMN_GENDER, userBean.getGender());
        values.put(UserTable.COLUMN_AGE, userBean.getAge());
        long result = database.insert(UserTable.TABLE_NAME, null, values);
        manager.closeDatabase();
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }

    //获取全部用户资料
    public List<UserBean> getUserList(){
        SQLiteDatabase database = manager.openDatabase();
        final String querySQL = "select * from " + UserTable.TABLE_NAME;
        Cursor cursor = database.rawQuery(querySQL, null);
        List<UserBean> userList = new ArrayList<>();
        if(cursor != null && cursor.getCount() > 0){
            while (cursor.moveToNext()){
                UserBean userBean = new UserBean(
                        cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME)),
                        cursor.getInt(cursor.getColumnIndex(UserTable.COLUMN_GENDER)),
                        cursor.getInt(cursor.getColumnIndex(UserTable.COLUMN_AGE)),
                        cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_AVATAR))
                );
                userList.add(userBean);
            }
        }
        cursor.close();
        manager.closeDatabase();
        return userList;
    }

    //插入训练数据
    public boolean saveTrainData(TrainBean trainBean, int count){
        SQLiteDatabase database = manager.openDatabase();
        ContentValues values = new ContentValues();
        long result = 0;
        for(int i=0; i<count; i++){
            values.put(TrainTable.COLUMN_ID, trainBean.getId());
            values.put(TrainTable.COLUMN_TIME, trainBean.getTime());
            values.put(TrainTable.COLUMN_DURATION, trainBean.getDuration());
            values.put(TrainTable.COLUMN_JUMPS, trainBean.getJumps());
            result = database.insert(TrainTable.TABLE_NAME, null, values);
        }
        manager.closeDatabase();
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }


}
