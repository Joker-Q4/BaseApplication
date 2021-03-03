package com.joker.fake.config;

import android.os.Handler;

import java.util.WeakHashMap;

/**
 * @author Joker
 * @since 2021/03/02
 */
public class Configurator {

    private static final WeakHashMap<ConfigKeys, Object> CONFIGS = new WeakHashMap<>();
    private static final Handler HANDLER = new Handler();

    private Configurator(){
        CONFIGS.put(ConfigKeys.CONFIG_READY, false);
        CONFIGS.put(ConfigKeys.HANDLER, HANDLER);
    }

    final WeakHashMap<ConfigKeys, Object> getJokerConfigs(){
        return CONFIGS;
    }

    /**
     * 利用静态内部类，结合get方法（线程安全）
     * @return Configuration
     */
    static Configurator getInstance(){
        return Holder.INSTANCE;
    }
    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure(){
        CONFIGS.put(ConfigKeys.CONFIG_READY, true);
    }

    private void checkConfiguration(){
        final Boolean isReady = (Boolean) CONFIGS.get(ConfigKeys.CONFIG_READY);
        if(isReady == null || !isReady){
            throw new RuntimeException("Configuration is not ready, call configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(ConfigKeys key){
        checkConfiguration();
        final Object value = CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString() + " IS NULL");
        }
        return (T) CONFIGS.get(key);
    }
}
