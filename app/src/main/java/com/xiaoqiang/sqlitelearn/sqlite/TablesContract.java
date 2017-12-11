package com.xiaoqiang.sqlitelearn.sqlite;

import android.provider.BaseColumns;

/**
 * Description: 在这里定义数据表（表名、表的字段名、及建表语句）
 * Created by crx on 2017/12/7.
 */

public final class TablesContract {

    private TablesContract(){
        //防止被初始化
    }

    public static class UserTable implements BaseColumns{
        //user表名 字段名 及 建表语句
        public static final String TABLE_NAME = "table_user";

        public static final String COLUMN_ID = "user_id";
        public static final String COLUMN_NAME = "user_name";
        public static final String COLUMN_GENDER = "user_gender";
        public static final String COLUMN_AGE = "user_age";
        public static final String COLUMN_AVATAR = "user_avatar"; //新加字段

        public static final String SQL_CREATE_USER_TABLE = "create table if not exists " + TABLE_NAME + " ( "
                + COLUMN_ID + " text not null,"
                + COLUMN_NAME + " text not null,"
                + COLUMN_GENDER + " integer,"
                + COLUMN_AVATAR + " text,"
                + COLUMN_AGE + " integer)";
    }

    public static class TrainTable implements BaseColumns{
        //表名
        public static final String TABLE_NAME = "table_train";
        //字段名
        public static final String COLUMN_ID = "user_id";
        public static final String COLUMN_TIME = "train_time";
        public static final String COLUMN_DURATION = "train_duration";
        public static final String COLUMN_JUMPS = "train_jumps";
        //建表语句
        public static final String SQL_CREATE_TRAIN_TABLE = "create table if not exists " + TABLE_NAME + " ( "
                + COLUMN_ID + " text not null,"
                + COLUMN_TIME + " long not null,"
                + COLUMN_DURATION + " integer,"
                + COLUMN_JUMPS + " integer)";
    }
}
