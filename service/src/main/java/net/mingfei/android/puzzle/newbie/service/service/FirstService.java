package net.mingfei.android.puzzle.newbie.service.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by mingfei.net@Gmail.com
 * 2016/1/19.
 */
public class FirstService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("demo", "first service on create...");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("demo", "first service on start command...");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("demo", "first service on destroy...");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
