package com.joker.fake.config;

import android.content.Context;
import android.os.Handler;

import java.util.WeakHashMap;

/**
 * @author Joker
 * @since 2021/03/02
 */
public class Joker {

    public static Configurator init(Context context){
        Configurator.getInstance()
                .getJokerConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static WeakHashMap<ConfigKeys, Object> getConfigurations(){
        return Configurator.getInstance().getJokerConfigs();
    }

    public static <T> T getConfiguration(ConfigKeys key) {
        return getConfigurator().getConfiguration(key);
    }

    //全局可以找到的上下文
    public static Context getApplicationContext() {
        return (Context) getConfigurations().get(ConfigKeys.APPLICATION_CONTEXT);
    }

    //全局可以使用的handler
    public static Handler getHandler() {
        return getConfiguration(ConfigKeys.HANDLER);
    }

}
