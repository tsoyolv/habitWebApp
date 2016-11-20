package com.habit.custom.server.i18n;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Oleg on 20.11.2016.
 */
// Singleton
public class Internationalization {

    private ConcurrentMap<String, String> cache = new ConcurrentHashMap<>();
    private static final int CACHE_SIZE = 100;

    public void refreshResources() {
        cache.clear();
    }

    public synchronized String getResource(String key) {
        if (cache.get(key) != null) {return cache.get(key);}
        if (cache.size() > CACHE_SIZE) {
            cache.clear();
        }
        return ";";
    }

    private static Internationalization instance;
    private Internationalization () {}

    public static synchronized Internationalization getInstance() {
        if (instance == null) {
            instance = new Internationalization();
        }
        return instance;
    }
}
