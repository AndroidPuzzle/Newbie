package net.mingfei.android.puzzle.newbie.activity_task;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SingleTopActivity extends Activity implements View.OnClickListener {

    private TextView instance;
    private Button singleTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_top);

        initView();
        refreshView();
    }

    private void refreshView() {
        instance.setText(getClass().getSimpleName() + " hash code: " + hashCode());
    }

    private void initView() {
        instance = (TextView) findViewById(R.id.instance);
        singleTop = (Button) findViewById(R.id.single_top);


        singleTop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.single_top:
                intent = new Intent(this, getClass());
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
