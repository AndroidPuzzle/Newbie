package net.mingfei.android.puzzle.easy.activity_lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        Log.e("demo", "on create...");
    }

    private void initView() {
        second = (Button) findViewById(R.id.second_activity);

        second.setOnClickListener(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("demo", "on restart...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("demo", "on start...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("demo", "on resume...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("demo", "on pause...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("demo", "on stop...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("demo", "on destroy...");
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.second_activity:
                intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
