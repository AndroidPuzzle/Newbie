package net.mingfei.android.puzzle.easy.broadcast_receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import net.mingfei.android.puzzle.easy.broadcast_receiver.receiver.SMSBroadcastReceiver;

/**
 * @author mingfei.net@Gmail.com
 *         13:44, 1/19/16.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private static final String INTENT_ACTION = "intent_action_broadcast";
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("demo", "receive...");
            Toast.makeText(MainActivity.this, "reveived", Toast.LENGTH_SHORT).show();
        }
    };
    private Button sendBroadcast, sendSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver, new IntentFilter(INTENT_ACTION));
        Log.e("demo", "on resume...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
        Log.e("demo", "on pause...");
    }

    private void initView() {
        sendBroadcast = (Button) findViewById(R.id.send_broadcast);
        sendSMS = (Button) findViewById(R.id.send_sms);

        sendBroadcast.setOnClickListener(this);
        sendSMS.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.send_broadcast:
                Log.e("demo", "send broadcast...");
                intent = new Intent(INTENT_ACTION);
                sendBroadcast(intent);
                // TODO: 1/19/16  
//                sendOrderedBroadcast();
//                sendStickyBroadcast();
                break;
            case R.id.send_sms:
                sendSMS();
                break;
            default:
                break;
        }
    }

    private void sendSMS() {
        SmsManager smsManager = SmsManager.getDefault();
        String destinationAddress = "18612182079";
        String text = "test text...";
        smsManager.sendTextMessage(destinationAddress, null, text, null, null);
    }
}
