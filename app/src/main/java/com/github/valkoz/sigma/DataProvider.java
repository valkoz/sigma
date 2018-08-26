package com.github.valkoz.sigma;

import android.util.Log;

import com.github.valkoz.sigma.model.TransformedItem;
import com.github.valkoz.sigma.model.rss.RSS;

import org.simpleframework.xml.core.Persister;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
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

                StringBuilder stringBuilder = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                }

                Reader xmlReader = new StringReader(stringBuilder.toString());
                Persister serializer = new Persister();
                try {
                    RSS rss = serializer.read(RSS.class, xmlReader, false);
                    ItemTransformer transformer = new ItemTransformer();
                    return transformer.transform(rss.getChannel().getItems());
                } catch (Exception e) {
                    //RSS parse error
                    Log.e(getClass().getCanonicalName(), e.getLocalizedMessage());
                }
            } else {
                //Status != OK
                Log.e(getClass().getCanonicalName(), conn.getResponseMessage());
            }
        } catch (IOException e) {
            //Connection error
            Log.e(getClass().getCanonicalName(), e.getLocalizedMessage());
        }
        return null;
    }
}
