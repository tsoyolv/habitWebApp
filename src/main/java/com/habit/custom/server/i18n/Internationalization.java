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

    private static final int CACHE_SIZE = 1000;
    private static final String CHARSET_NAME = "UTF-8";

    private Locale locale;
    private ConcurrentMap<String, String> cache = new ConcurrentHashMap<>();

    public void refreshResources() {
        cache.clear();
        fillCache();
    }

    public synchronized String getResource(String key) {
        if (key == null) { return "";}
        if (cache.get(key) != null) {return cache.get(key);}
        if (cache.size() > CACHE_SIZE) {
            cache.clear();
        }
        String resourceFromFile = getResourceFromFile(key);
        cache.put(key, resourceFromFile);
        return resourceFromFile;
    }

    public synchronized String getResource(String key, Locale locale) {
        if (locale != null) {
            if (!locale.equals(this.locale)) {
                this.locale = locale;
                return getResourceFromFile(key);
            }
        }
        return getResource(key);
    }

    private String getResourceFromFile(String key) {
        final String PATH = "custom/l10n/" + this.locale.getFileName() + ".txt";
        final String SPLITTER = ":";
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(PATH);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream, CHARSET_NAME))) {
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

    private void fillCache() {
        for (int i = 0; i < CACHE_SIZE; i++) {
            final String PATH = "custom/l10n/" + this.locale.getFileName() + ".txt";
            final String SPLITTER = ":";
            InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(PATH);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream, CHARSET_NAME))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] split = line.split(SPLITTER);
                    cache.put(split[0], split[1]);
                }

            } catch (IOException x) {
                return;
            }
        }
    }

    private enum Locale {
        EN("en"), RU("ru");

        Locale(String key) {
            this.fileName = key;
        }

        private String fileName;

        public String getFileName() {
            return fileName;
        }

    }

    public static String getCharsetName() {
        return CHARSET_NAME;
    }

    private static Internationalization instance;
    private Internationalization (Locale locale) {
        this.locale = locale;
        refreshResources();
    }

    public static synchronized Internationalization getInstance() {
        return getInstance(Locale.RU);
    }

    public static synchronized Internationalization getInstance(Locale locale) {
        if (instance == null) {
            instance = new Internationalization(locale);
        }
        return instance;
    }
}
