package com.example.cat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.cat.bean.CatAttrBean;
import com.example.cat.bean.CatBean;
import com.nianlun.greendao.gen.CatAttrBeanDao;
import com.nianlun.greendao.gen.CatBeanDao;
import com.nianlun.greendao.gen.DaoMaster;
import com.nianlun.greendao.gen.DaoSession;

import org.greenrobot.greendao.database.Database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends BaseActivity {

    private static final String DB_NAME = "cat.db";
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            copyDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void copyDataBase() throws IOException {
        InputStream myInput = this.getAssets().open(DB_NAME);
        File outFileName = this.getDatabasePath(DB_NAME);
        if (outFileName.exists() && outFileName.isFile()) {
            Log.e(TAG, "copyDataBase: " + "数据库已存在");
            return;
        }
        outFileName.getParentFile().mkdirs();
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }


}