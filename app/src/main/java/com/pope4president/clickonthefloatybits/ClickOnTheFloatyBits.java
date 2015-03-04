package com.pope4president.clickonthefloatybits;

import android.app.Activity;
import android.app.Application;

public class ClickOnTheFloatyBits extends Application {
    private static Activity mCurrentActivity = null;

    public void onCreate() {
        super.onCreate();
    }

    public static Activity getCurrentActivity(){
        return mCurrentActivity;
    }
    public void setCurrentActivity(Activity mCurrentActivity){
        this.mCurrentActivity = mCurrentActivity;
    }
}