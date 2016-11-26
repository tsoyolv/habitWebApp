package com.habit.custom.client.i18n;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * OLTS on 25.11.2016.
 */
public class I18n {

    private static final String SERVER_URL = "http://localhost:8082/";
    private static final String USER_AGENT = "Mozilla/5.0";

    public static String getResource(String key) {
        String url = SERVER_URL + "getLocalizedMessage?messagekey=" + key;
        URL obj = null;
        try {
            obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // optional default is GET
            //con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch (IOException e) {
            return "FAKE_LOCAL_MESSAGE";
        }
    }
}
