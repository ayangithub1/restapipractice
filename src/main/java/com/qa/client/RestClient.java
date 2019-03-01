package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	//To Get URL

	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
	CloseableHttpClient closeableHttpClient= HttpClients.createDefault();//created the connection
	HttpGet httpget = new HttpGet(url);//get the URL
	CloseableHttpResponse closeableHttpresponse =closeableHttpClient.execute(httpget);
	
	return closeableHttpresponse;
	
	}
}
	