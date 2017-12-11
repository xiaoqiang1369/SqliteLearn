package com.xiaoqiang.sqlitelearn;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xiaoqiang.sqlitelearn.sqlite.MyDatabaseOperator;
import com.xiaoqiang.sqlitelearn.sqlite.bean.TrainBean;
import com.xiaoqiang.sqlitelearn.sqlite.bean.UserBean;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView tvDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDatabase = findViewById(R.id.tv_database);
        Button btnScan = findViewById(R.id.btn_scan_database);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanDatabase();
            }
        });

        Button btnSave = findViewById(R.id.btn_save_database);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData(2);
                saveData(10);
            }
        });
    }

    private void saveData(final int count){
        new Thread(new Runnable() {
            @Override
            public void run() {
                MyDatabaseOperator operator = new MyDatabaseOperator();
                boolean result = operator.saveTrainData(new TrainBean("123", 123454, 60, 144), count);
//                boolean result = operator.saveUser(new UserBean("123", "chenrenxiang", 1, 26));
                if(result){
                    Log.e(TAG, "save " + count + " data successful");
                }
            }
        }).start();

    }

    private void scanDatabase(){
        new ScanDataTask().execute();
    }





    private class ScanDataTask extends AsyncTask<Void, Void, List<UserBean>>{
        @Override
        protected List<UserBean> doInBackground(Void... voids) {
            MyDatabaseOperator operator = new MyDatabaseOperator();
            return operator.getUserList();
        }

        @Override
        protected void onPostExecute(List<UserBean> userBeans) {
            String result = "";
            for(UserBean userBean : userBeans){
                result += userBean.toString() + "\n";
            }
            tvDatabase.setText(result);
        }
    }

}

