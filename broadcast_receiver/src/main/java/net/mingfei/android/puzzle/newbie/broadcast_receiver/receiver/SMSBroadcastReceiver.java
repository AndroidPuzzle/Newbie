package net.mingfei.android.puzzle.newbie.broadcast_receiver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * @author mingfei.net@Gmail.com
 *         15:00, 1/19/16.
 */
public class SMSBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("demo", "sms broadcast receive...");
//        Bundle bundle = intent.getExtras();
//        if (bundle == null) {
//            return;
//        }
//        Object[] pdus = (Object[]) bundle.get("pdus");
//        StringBuilder messageStringBuilder = new StringBuilder(pdus.length);
//        for (Object pdu : pdus) {
//            messageStringBuilder.append(SmsMessage.createFromPdu((byte[]) pdu));
//        }
//        Toast.makeText(context, messageStringBuilder.toString(), Toast.LENGTH_LONG).show();
    }
}
