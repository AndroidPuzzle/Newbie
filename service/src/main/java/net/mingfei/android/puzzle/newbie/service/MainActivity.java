package net.mingfei.android.puzzle.newbie.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import net.mingfei.android.puzzle.newbie.service.service.FirstService;
import net.mingfei.android.puzzle.newbie.service.service.SecondService;

/**
 * Created by mingfei.net@Gmail.com
 * 2016/1/19.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private Button startFirstService, stopFirstService, bindSecondService, unbindSecondService;

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
    }

    private void initView() {
        startFirstService = (Button) findViewById(R.id.start_first_service);
        stopFirstService = (Button) findViewById(R.id.stop_first_service);
        bindSecondService = (Button) findViewById(R.id.bind_second_service);
        unbindSecondService = (Button) findViewById(R.id.unbind_second_service);

        startFirstService.setOnClickListener(this);
        stopFirstService.setOnClickListener(this);
        bindSecondService.setOnClickListener(this);
        unbindSecondService.setOnClickListener(this);
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
            case R.id.bind_second_service:
                intent = new Intent(this, SecondService.class);
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.unbind_second_service:
                unbindService(serviceConnection);
                break;
            default:
                break;
        }
    }
}
