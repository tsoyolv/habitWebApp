package com.habit.custom.client.i18n;

import junit.framework.TestCase;
import junit.framework.TestResult;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class I18nTest extends TestCase {
    @Override
    public TestResult run() {
        return super.run();
    }

    @Test
    public void testSendGet() throws Exception {
        final String USER_AGENT = "Mozilla/5.0";
        final int messageKey = 2;
        String url = "http://localhost:8082/getLocalizedMessage?messagekey=" + messageKey;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        assertTrue(response.length() != 0);
        System.out.println(response.toString());

    }
}