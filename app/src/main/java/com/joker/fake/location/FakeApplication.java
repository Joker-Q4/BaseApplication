package com.joker.fake.location;

import android.app.Application;

import com.joker.fake.config.Joker;

/**
 * @author Joker
 * @since 2021/03/02
 */
public class FakeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Joker.init(this)
                .configure();
    }
}
