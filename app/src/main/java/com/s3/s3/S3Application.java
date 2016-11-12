package com.s3.s3;

import android.app.Application;
import android.content.Context;

import org.greenrobot.eventbus.EventBus;

public class S3Application extends Application {

    private static S3Application context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        EventBus.builder().throwSubscriberException(BuildConfig.DEBUG).installDefaultEventBus();
    }

    public static Context getContext() {
        return context;
    }
}
