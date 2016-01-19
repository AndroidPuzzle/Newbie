package net.mingfei.android.puzzle.newbie.activity_task;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StandardActivity extends Activity implements View.OnClickListener {

    private TextView instance;
    private Button standard, singleTop, singleTask, singleInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);

        initView();
        refreshView();
    }

    private void refreshView() {
        instance.setText(getClass().getSimpleName() + " hash code: " + hashCode());
    }

    private void initView() {
        instance = (TextView) findViewById(R.id.instance);
        standard = (Button) findViewById(R.id.standard);
        singleTop = (Button) findViewById(R.id.single_top);
        singleTask = (Button) findViewById(R.id.single_task);
        singleInstance = (Button) findViewById(R.id.single_instance);
        standard.setOnClickListener(this);
        singleTop.setOnClickListener(this);
        singleTask.setOnClickListener(this);
        singleInstance.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.standard:
                intent = new Intent(this, getClass());
                startActivity(intent);
                break;
            case R.id.single_top:
                intent = new Intent(this, SingleTopActivity.class);
                startActivity(intent);
                break;
            case R.id.single_task:
                intent = new Intent(this, SingleTaskActivity.class);
                startActivity(intent);
                break;
            case R.id.single_instance:
                intent = new Intent(this, SingleInstanceActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("demo", "hash code: " + hashCode() + " destroyed...");
    }
}
