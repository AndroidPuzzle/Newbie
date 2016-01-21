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
import net.mingfei.android.puzzle.newbie.service.annotation.ContentView;
import net.mingfei.android.puzzle.newbie.service.annotation.ViewInject;
import net.mingfei.android.puzzle.newbie.service.service.*;
import net.mingfei.android.puzzle.newbie.service.util.ViewInjectUtil;

/**
 * Created by mingfei.net@Gmail.com
 * 2016/1/19.
 */
@ContentView(value = R.layout.activity_main)
public class MainActivity extends Activity implements View.OnClickListener {

    @ViewInject(value = R.id.start_first_service)
    private Button startFirstService;
    @ViewInject(value = R.id.stop_first_service)
    private Button stopFirstService;
    @ViewInject(value = R.id.start_second_service)
    private Button startSecondService;
    @ViewInject(value = R.id.stop_second_service)
    private Button stopSecondService;
    @ViewInject(value = R.id.bind_second_service)
    private Button bindSecondService;
    @ViewInject(value = R.id.unbind_second_service)
    private Button unbindSecondService;
    @ViewInject(value = R.id.start_foreground_service)
    private Button startForegroundService;
    @ViewInject(value = R.id.stop_foreground_service)
    private Button stopForegroundService;
    @ViewInject(value = R.id.start_remote_service)
    private Button startRemoteService;
    @ViewInject(value = R.id.stop_remote_service)
    private Button stopRemoteService;
    @ViewInject(value = R.id.start_restart_service)
    private Button startRestartService;
    @ViewInject(value = R.id.stop_restart_service)
    private Button stopRestartService;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("demo", "on service connected...");
            SecondService.MyBinder myBinder = (SecondService.MyBinder) service;
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

        initView();
        setListener();
        Log.e("demo", getClass().getSimpleName() + "in process: " + Process.myPid() + ", in thread: " + Thread.currentThread().getId());
    }

    private void initView() {
        ViewInjectUtil.inject(this);
    }

    private void setListener() {

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
