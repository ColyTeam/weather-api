package dev.coly.weather;

import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * Created by Gregyyy on 02.12.2017.
 */
public class HttpHandler {

    public static String getContentFromWebsite(String url) throws IOException {
        return Jsoup.connect(url).ignoreContentType(true).execute().body();
    }

}
