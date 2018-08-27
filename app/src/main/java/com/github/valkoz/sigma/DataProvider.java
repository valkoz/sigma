package com.github.valkoz.sigma;

import android.util.Log;

import com.github.valkoz.sigma.model.TransformedItem;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class DataProvider {

    private static final String PATH = "https://habr.com/rss/hubs/all/";

    public List<TransformedItem> getData() {
        try {
            URL url = new URL(PATH);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (conn.getResponseCode() == HttpsURLConnection.HTTP_OK) {
                RequestReader reader = new RequestReader();
                String responseBody = reader.read(conn.getInputStream());
                RssParser parser = new RssParser();
                return parser.parse(responseBody);
            } else {
                //Status != OK
                Log.e(getClass().getCanonicalName(), conn.getResponseMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
