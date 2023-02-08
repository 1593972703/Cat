package com.example.cat;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class WelcomeActivity extends BaseActivity {

    private static final String DB_NAME = "cat.db";
    private static final String TAG = WelcomeActivity.class.getSimpleName();

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

    @Override
    public void loadData() {

    }

    @Override
    public void initView() {
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