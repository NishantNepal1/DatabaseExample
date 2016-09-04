package com.hfad.databaseexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by user on 9/4/2016.
 */
public class BaseActivity extends AppCompatActivity {
    MyApplication myApplication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myApplication= (MyApplication) getApplication();
    }
}
