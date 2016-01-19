package net.mingfei.android.puzzle.easy.activity_start;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * @author mingfei.net@Gmail.com
 *         11:00, 1/19/16.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private static final int REQUEST_CODE = 0;
    private Button startActivity, startActivityForResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        startActivity = (Button) findViewById(R.id.start_activity);
        startActivityForResult = (Button) findViewById(R.id.start_activity_for_result);

        startActivity.setOnClickListener(this);
        startActivityForResult.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.start_activity:
                intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.start_activity_for_result:
                intent = new Intent(this, SecondActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("demo", "request code: " + requestCode +
                ", result code: " + requestCode +
                ", value: " + data.getStringExtra("key"));
    }
}
