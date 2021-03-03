package com.joker.fake.utils;

import android.os.Looper;

/**
 * @author Joker
 * @since 2021/03/02
 */
public class LooperUtil {

    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
