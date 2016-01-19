package net.mingfei.android.puzzle.newbie.activity_lifecycle;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author mingfei.net@Gmail.com
 *         18:45, 1/18/16.
 */
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
