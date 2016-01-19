package net.mingfei.android.puzzle.newbie.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import net.mingfei.android.puzzle.newbie.service.service.FirstService;

/**
 * Created by mingfei.net@Gmail.com
 * 2016/1/19.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private Button startFirstService, stopFirstService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        startFirstService = (Button) findViewById(R.id.start_first_service);
        stopFirstService = (Button) findViewById(R.id.stop_first_service);

        startFirstService.setOnClickListener(this);
        stopFirstService.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, FirstService.class);
        switch (view.getId()) {
            case R.id.start_first_service:
                Log.e("demo", "start first service");
                startService(intent);
                break;
            case R.id.stop_first_service:
                Log.e("demo", "stop first service");
                stopService(intent);
            default:
                break;
        }
    }
}
