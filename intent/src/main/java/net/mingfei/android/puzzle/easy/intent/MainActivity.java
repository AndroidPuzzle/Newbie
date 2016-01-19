package net.mingfei.android.puzzle.easy.intent;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author mingfei.net@Gmail.com
 *         16:51, 1/19/16.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private static final int REQUEST_CODE = 0;
    private Button explicitIntent, implicitIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        explicitIntent = (Button) findViewById(R.id.explicit_intent);
        implicitIntent = (Button) findViewById(R.id.implicit_intent);

        explicitIntent.setOnClickListener(this);
        implicitIntent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.explicit_intent:
                intent = new Intent(this, SecondActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.implicit_intent:
                intent = new Intent();
//                intent.setComponent();
                intent.setAction(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:18688886666");
                intent.setData(data);
                String type = "text/plain";
                intent.setDataAndType(data, type);
//                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "text...");
                intent.addCategory("category_test");
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP); // vs intent.addFlags();
                startActivityForResult(intent, REQUEST_CODE);
                break;
            default:
                break;
        }
    }
}
