package net.mingfei.android.puzzle.easy.broadcast_receiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * @author mingfei.net@Gmail.com
 *         13:44, 1/19/16.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private Button sendBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        sendBroadcast = (Button) findViewById(R.id.send_broadcast);

        sendBroadcast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.send_broadcast:
                // TODO: 1/19/16
                Log.e("demo", "send broadcast...");
                break;
            default:
                break;
        }
    }
}
