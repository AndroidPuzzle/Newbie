package net.mingfei.android.puzzle.newbie.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import net.mingfei.android.puzzle.newbie.service.service.*;

/**
 * Created by mingfei.net@Gmail.com
 * 2016/1/19.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private Button startFirstService, stopFirstService, startSecondService, stopSecondService, bindSecondService, unbindSecondService, startForegroundService, stopForegroundService, startRemoteService, stopRemoteService, startRestartService, stopRestartService;

    private SecondService.MyBinder myBinder;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("demo", "on service connected...");
            myBinder = (SecondService.MyBinder) service;
            myBinder.doSomething();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("demo", "on service disconnected...");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        Log.e("demo", getClass().getSimpleName() + "in process: " + Process.myPid() + ", in thread: " + Thread.currentThread().getId());
    }

    private void initView() {
        startFirstService = (Button) findViewById(R.id.start_first_service);
        stopFirstService = (Button) findViewById(R.id.stop_first_service);
        startSecondService = (Button) findViewById(R.id.start_second_service);
        stopSecondService = (Button) findViewById(R.id.stop_second_service);
        bindSecondService = (Button) findViewById(R.id.bind_second_service);
        unbindSecondService = (Button) findViewById(R.id.unbind_second_service);
        startForegroundService = (Button) findViewById(R.id.start_foreground_service);
        stopForegroundService = (Button) findViewById(R.id.stop_foreground_service);
        startRemoteService = (Button) findViewById(R.id.start_remote_service);
        stopRemoteService = (Button) findViewById(R.id.stop_remote_service);
        startRestartService = (Button) findViewById(R.id.start_restart_service);
        stopRestartService = (Button) findViewById(R.id.stop_restart_service);

        startFirstService.setOnClickListener(this);
        stopFirstService.setOnClickListener(this);
        startSecondService.setOnClickListener(this);
        stopSecondService.setOnClickListener(this);
        bindSecondService.setOnClickListener(this);
        unbindSecondService.setOnClickListener(this);
        startForegroundService.setOnClickListener(this);
        stopForegroundService.setOnClickListener(this);
        startRemoteService.setOnClickListener(this);
        stopRemoteService.setOnClickListener(this);
        startRestartService.setOnClickListener(this);
        stopRestartService.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.start_first_service:
                intent = new Intent(this, FirstService.class);
                startService(intent);
                break;
            case R.id.stop_first_service:
                intent = new Intent(this, FirstService.class);
                stopService(intent);
                break;
            case R.id.start_second_service:
                intent = new Intent(this, SecondService.class);
                startService(intent);
                break;
            case R.id.stop_second_service:
                Log.e("demo", "stop second service");
                intent = new Intent(this, SecondService.class);
                stopService(intent);
                break;
            case R.id.bind_second_service:
                intent = new Intent(this, SecondService.class);
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.unbind_second_service:
                Log.e("demo", "unbind second service");
                unbindService(serviceConnection);
                break;
            case R.id.start_foreground_service:
                intent = new Intent(this, ForegroundService.class);
                startService(intent);
                break;
            case R.id.stop_foreground_service:
                intent = new Intent(this, ForegroundService.class);
                stopService(intent);
                break;
            case R.id.start_remote_service:
                intent = new Intent(this, RemoteService.class);
                startService(intent);
                break;
            case R.id.stop_remote_service:
                intent = new Intent(this, RemoteService.class);
                stopService(intent);
                break;
            case R.id.start_restart_service:
                intent = new Intent(this, RestartService.class);
                startService(intent);
                break;
            case R.id.stop_restart_service:
                intent = new Intent(this, RestartService.class);
                stopService(intent);
                break;
            default:
                break;
        }
    }
}
