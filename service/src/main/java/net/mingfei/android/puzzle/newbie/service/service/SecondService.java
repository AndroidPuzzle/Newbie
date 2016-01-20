package net.mingfei.android.puzzle.newbie.service.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author mingfei.net@Gmail.com
 *         11:56, 1/20/16.
 */
public class SecondService extends Service {

    private MyBinder myBinder = new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("demo", "second service on create...");
        Log.e("demo", getClass().getSimpleName() + " in thread: " + Thread.currentThread().getId());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("demo", "second service on start command...");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("demo", "second service on destroy...");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("demo", "second service on bind...");
        return myBinder;
    }

    public class MyBinder extends Binder {

        public void doSomething() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Log.e("demo", "do something... in thread: " + Thread.currentThread().getId());
                }
            }).start();
        }
    }
}
