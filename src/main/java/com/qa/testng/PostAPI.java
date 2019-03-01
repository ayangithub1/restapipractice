package com.qa.testng;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.BeforeClass;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class PostAPI extends TestBase {
    TestBase testbase;
    String endpoint;
    String serviceurl;
    String url;
    RestClient restclient;
	CloseableHttpResponse closeableHttpresponse;
	
    
	@BeforeClass
	public void getclient() {
		
		testbase =new TestBase();
		endpoint = prop.getProperty("endpoint");
		serviceurl= prop.getProperty("serviceurl");
		url = endpoint + serviceurl;
	
	}
	
	public void PostAPITest () throws ClientProtocolException, IOException {
		
		restclient =new RestClient();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");

		ObjectMapper mapper =new ObjectMapper();
		
	}
	}

