package com.folio.android.folio;

/**
 * Created by copperstick6 on 3/11/17.
 */

import android.os.StrictMode;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.net.*;
import java.io.*;

/**
 * Sample code to make an HTTP Request, still need to add in the GSON object, in addition, we can't just check
 * the raw main address, as there can be multiple matches, so we also need to add in the state, etc
 */
public class URLConnectionReader {
    public String url;
    public URLConnectionReader(String urltoRead){
        this.url = urltoRead;
    }


    /**
     * Method to make a default GET request to the given website
     * The Gson Package now works.
     * @return              Return a string of output in unformatted JSON object type
     * @throws Exception
     */
    public String getHTML() throws Exception {
        //TODO NEED TO RETHREAD, causing frame losses, so maybe do this on a secondary thread
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        System.out.println(this.url);
        StringBuilder result = new StringBuilder();
        URL url = new URL(this.url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        Gson gson = new Gson();
        JsonElement element = gson.fromJson (result.toString(), JsonElement.class);
        JsonObject jsonObj = element.getAsJsonObject();
        System.out.println(jsonObj.entrySet().size());
        return result.toString();


        //Sample template
        /*
        URLConnectionReader connect = new URLConnectionReader("https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyCDw3K_2g9Iw-kPciTLhs-LLjUc65Lu-mU");
        try{
            System.out.println("entered");
            connect.getHTML();
        }
        catch(Exception a){
            System.out.println("Caught");
            a.printStackTrace();
        }
        */
    }
}