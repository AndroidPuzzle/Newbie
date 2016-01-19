package net.mingfei.android.puzzle.easy.activity_start;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.ActivityChooserView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * @author mingfei.net@Gmail.com
 *         11:36, 1/19/16.
 */
public class SecondActivity extends Activity implements View.OnClickListener {

    private static final int RESULT_CODE = 1;
    private Button backToMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();

        Intent intent = new Intent();
        intent.putExtra("key", "value 1");
        setResult(RESULT_CODE, intent);
    }

    private void initView() {
        backToMainActivity = (Button) findViewById(R.id.back_to_main_activity);

        backToMainActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.back_to_main_activity:
                intent = new Intent();
                intent.putExtra("key", "value 2");
                setResult(RESULT_CODE, intent);
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("demo", getClass().getSimpleName() + " on destroy...");
    }
}
