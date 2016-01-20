package net.mingfei.android.puzzle.newbie.service.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author mingfei.net@Gmail.com
 *         16:58, 1/20/16.
 */
public class RemoteService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();

        Log.e("demo", "remote service on create... in process: " + Process.myPid());

//        try {
//            Thread.sleep(1000*10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("demo", "remote service on start command...");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("demo", "remote service on destroy...");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
