package net.mingfei.android.puzzle.newbie.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author mingfei.net@Gmail.com
 *         17:10, 1/19/16.
 */
public class SecondActivity extends Activity {

    private TextView intentInfo;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
        initData();
        refreshView();
    }

    private void refreshView() {
        intentInfo.setText(
                "calling activity name: " + getCallingActivity().getShortClassName() + "\n"
                        + "intent action: " + intent.getAction() + "\n"
                        + "intent type: " + intent.getType() + "\n"
                        + "intent category: " + intent.getCategories() + "\n"
                        + "intent data: " + intent.getData() + "\n"
                        + "intent flag: " + Integer.toHexString(intent.getFlags()) + "\n"
                        + "intent extra: " + intent.getStringExtra(Intent.EXTRA_TEXT) + "\n"
        );
    }

    private void initData() {
        intent = getIntent();
    }

    private void initView() {
        intentInfo = (TextView) findViewById(R.id.intent_info);
    }
}
