package com.joker.fake.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * @author Joker
 * @since 2021/03/02
 */
public class ExitMainActivityReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        ((MainActivity)context).finish();
    }
}