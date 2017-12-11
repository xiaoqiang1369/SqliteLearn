package com.xiaoqiang.sqlitelearn;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.xiaoqiang.sqlitelearn.sqlite.DatabaseManager;
import com.xiaoqiang.sqlitelearn.sqlite.MyDataBaseHelper;

/**
 * Description:
 * Created by crx on 2017/12/7.
 */

public class TheApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initStetho(this);
        initDatabase();
    }

    private void initStetho(Application a) {
        Stetho.initialize(
                Stetho.newInitializerBuilder(a)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(a))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(a))
                        .build());
    }

    private void initDatabase(){
        DatabaseManager.initializeInstance(new MyDataBaseHelper(this));
    }
}
