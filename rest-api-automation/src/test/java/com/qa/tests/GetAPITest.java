package com.qa.tests;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class GetAPITest extends TestBase {
    TestBase testBase;
    String serviceUrl;
    private String apiUrl;
    private String url;
    private RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;
@BeforeMethod
public void setUp() throws IOException, JSONException {
    testBase = new TestBase();
    serviceUrl = prop.getProperty("URL");
    apiUrl = prop.getProperty("serviceURL");
    url = serviceUrl + apiUrl;
    restClient = new RestClient();

}
@Test
public void getAPITest() throws IOException, JSONException {
    restClient = new RestClient();
    closeableHttpResponse = restClient.get(url);

    int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();   //geting status code from status line and storing it into a variable
    System.out.println("Status code is ---> " + statusCode );
    Assert.assertEquals();

    String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");   //geting response and store it into a string variable
    JSONObject responseJson = new JSONObject(responseString);   //create Json object and transform the string response into a Json response
    System.out.println("Response JSON from API ---> " + responseJson);
    Header[] headerArray = closeableHttpResponse.getAllHeaders();  //adding all headers into allHeader HashMap<>:
    HashMap<String,String> allHeader = new HashMap<String, String>();
    for(Header header:headerArray){
        allHeader.put(header.getName(), header.getValue());
    }
    System.out.println("Headers array ---> " + allHeader);
}
}
//C:\Users\Acer\IdeaProjects\rest-api-automation
