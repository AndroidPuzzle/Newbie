package net.mingfei.android.puzzle.easy.activity_task;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SingleInstanceActivity extends Activity implements View.OnClickListener {

    private TextView instance;
    private Button singleInstance, standard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_instance);

        initView();
        refreshView();
    }

    private void refreshView() {
        instance.setText(getClass().getSimpleName() + " hash code: " + hashCode());
    }

    private void initView() {
        instance = (TextView) findViewById(R.id.instance);
        singleInstance = (Button) findViewById(R.id.single_instance);
        standard = (Button) findViewById(R.id.standard);

        singleInstance.setOnClickListener(this);
        standard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.single_instance:
                intent = new Intent(this, getClass());
                startActivity(intent);
                break;
            case R.id.standard:
                intent = new Intent(this, StandardActivity.class);
                startActivity(intent);
            default:
                break;
        }
    }
}
