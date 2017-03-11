package com.folio.android.folio;

/**
 * Created by copperstick6 on 3/11/17.
 */

import java.net.*;
import java.io.*;

/**
 * Sample code to make an HTTP Request, still need to add in the GSON object, in addition, we can't just check
 * the raw main address, as there can be multiple matches, so we also need to add in the state, etc
 */
public class URLConnectionReader {


    /**
     * Method to make a default GET request to the given website
     * @param urlToRead     This is the website to send the GET request to
     * @return              Return a string of output in unformatted JSON object type
     * @throws Exception
     */
    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }
}