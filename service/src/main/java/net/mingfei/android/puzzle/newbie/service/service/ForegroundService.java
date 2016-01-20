package net.mingfei.android.puzzle.newbie.service.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import net.mingfei.android.puzzle.newbie.service.MainActivity;
import net.mingfei.android.puzzle.newbie.service.R;

/**
 * @author mingfei.net@Gmail.com
 *         14:56, 1/20/16.
 */
public class ForegroundService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("demo", "foreground service on create...");
    }

    private void startForegroundService() {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        Notification notification = new NotificationCompat.Builder(this)
                .setTicker("ticker...")
                .setContentTitle("content title...")
                .setContentText("content text...")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1, notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("demo", "foreground service on start command...");
        startForegroundService();
        return START_STICKY;
//        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("demo", "froeground service on destroy...");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
