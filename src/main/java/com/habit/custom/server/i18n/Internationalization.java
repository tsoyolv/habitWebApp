package com.habit.custom.server.i18n;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * OLTS on 20.11.2016.
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
        String resourceFromFile = getResourceFromFile(key);
        cache.put(key, resourceFromFile);
        return resourceFromFile;
    }

    private static String getResourceFromFile(String key) {
        final String PATH = "custom/l10n/english.txt";
        final String SPLITTER = ":";
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(PATH);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(SPLITTER);
                if (split[0].equals(key)) {
                    return split[1];
                }
            }

        } catch (IOException x) {
            return "FAKE";
        }
        return "";
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
