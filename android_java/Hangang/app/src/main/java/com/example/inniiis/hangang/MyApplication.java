package com.example.inniiis.hangang;

import android.app.Application;

public class MyApplication extends Application {
    private String mGlobalString;

    public String getmGlobalString() {
        return mGlobalString;
    }

    public void setmGlobalString(String globalString) {
        this.mGlobalString = globalString;
    }
}