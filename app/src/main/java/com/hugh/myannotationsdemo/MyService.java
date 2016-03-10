package com.hugh.myannotationsdemo;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import org.androidannotations.annotations.EService;

/**
 * Created by hugh on 2016/3/10.
 */
@EService
public class MyService extends android.app.Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("hugh","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
