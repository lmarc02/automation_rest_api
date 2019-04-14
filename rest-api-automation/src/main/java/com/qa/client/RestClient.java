package com.qa.client;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.HashMap;

public class RestClient {
    // get method
    public CloseableHttpResponse get(String url) throws  IOException, JSONException {
        CloseableHttpClient httpClient = HttpClients.createDefault();   //create a client
        HttpGet httpGet = new HttpGet(url);   //get request object
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);   //send url request is stored into a variable(like clicking on send button on postman)
        return closeableHttpResponse;
//
    }
}
