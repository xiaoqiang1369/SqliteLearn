package com.xiaoqiang.sqlitelearn.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.xiaoqiang.sqlitelearn.sqlite.TablesContract.UserTable;
import com.xiaoqiang.sqlitelearn.sqlite.TablesContract.TrainTable;

/**
 * Description: 自定义SQLiteOpenHelper
 * Created by crx on 2017/12/7.
 */

public class MyDataBaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "MyDataBaseHelper";
    private static final int DB_VERSION = 1;
    private static final int DB_VERSION_2 = 2;

    private static final String DB_NAME = "mydb.db";


    public MyDataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION_2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.e(TAG, "onCreate SQLite");
        sqLiteDatabase.execSQL(UserTable.SQL_CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(TrainTable.SQL_CREATE_TRAIN_TABLE); //新增训练表
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.e(TAG, "onUpgrade SQLite -->> oldVersion = " + oldVersion + " ; newVersion = " + newVersion);
        //如果是从版本1升级到版本2，先向用户表添加avatar字段，然后新建训练表
        if(oldVersion == DB_VERSION && newVersion == DB_VERSION_2){
            //向用户表插入avatar字段的SQL语句
            String upgradeUserSQL = "alter table " + UserTable.TABLE_NAME + " add " + UserTable.COLUMN_AVATAR + " text";
            sqLiteDatabase.execSQL(upgradeUserSQL);
            sqLiteDatabase.execSQL(TrainTable.SQL_CREATE_TRAIN_TABLE);
        }

    }

}
