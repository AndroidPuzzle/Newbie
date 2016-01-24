package net.mingfei.android.puzzle.newbie.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * @author mingfei.net@Gmail.com
 *         12:36, 1/24/16.
 */
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
    }
}
