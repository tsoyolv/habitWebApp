package com.habit.custom.server.i18n;

import com.habit.custom.knowledges.AntiPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * OLTS on 20.12.2016.
 */
public class InternationalizationNew {

    private static final int CACHE_SIZE = 1000;
    private static final String CHARSET_NAME = "UTF-8";

    private static final String SPLITTER = ":";
    private static final String LOCALE_ROOT_PATH = "custom/l10n/";
    private static final String LOCALE_PATH_FILES_PATH = LOCALE_ROOT_PATH + "files/";

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

    @AntiPattern("Copy-paste")
    private String getResourceFromFile(String key) {
        final String localePath = LOCALE_PATH_FILES_PATH + this.locale.getFileName() + ".txt";
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(localePath);
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
            final String localPath = LOCALE_PATH_FILES_PATH + this.locale.getFileName() + ".txt";
            InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(localPath);
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

    private static InternationalizationNew instance;
    private InternationalizationNew (Locale locale) {
        this.locale = locale;
        refreshResources();
    }

    public static synchronized InternationalizationNew getInstance() {
        if (instance == null) {
            final String confPath = LOCALE_ROOT_PATH + "configuration.txt";
            InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(confPath);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream, CHARSET_NAME))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] split = line.split(SPLITTER);
                    if (split[0].equals("default")) {
                        for (Locale loc : Locale.values()) {
                            if (loc.getFileName().equals(split[1])) {
                                return instance = new InternationalizationNew(loc);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                return instance = new InternationalizationNew(Locale.RU);
            }
        }
        return instance;
    }

    public void _devRefreshLocale() {
        instance = null;
        getInstance();
    }
}
