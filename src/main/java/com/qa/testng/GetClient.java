package com.qa.testng;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.utils.TestUtil;

public class GetClient extends TestBase {
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
	@Test
	
	public void getAPITest() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		closeableHttpresponse=restclient.get(url);
		//To get the status code
		
		int statuscode=closeableHttpresponse.getStatusLine().getStatusCode();
		System.out.println("Status code is :" +statuscode);
		Assert.assertEquals(statuscode, 200);
		
		//To get convert the response in String
		String response= EntityUtils.toString(closeableHttpresponse.getEntity(),"UTF-8");
		//To convert the string into a JSON
		
		JSONObject jsonobject =new JSONObject(response);
		System.out.println("JSON code is : " +jsonobject);
		String s= TestUtil.getValueByJPath(jsonobject, "/per_page");
		System.out.println(s);
		Assert.assertEquals(Integer.parseInt(s), 3);
		
		String s1= TestUtil.getValueByJPath(jsonobject, "/data[0]/first_name");
		System.out.println(s1);
		//Assert.assertEquals(Integer.parseInt(s), 3);
		
		//get the Header 
		Header[] headerarray = closeableHttpresponse.getAllHeaders();
		HashMap<String, String> hashmap =new HashMap<String, String>();
		for (Header header: headerarray) {
			hashmap.put(header.getName(), header.getValue());
			System.out.println("header array :" +hashmap);
		}
		
		
		

		
		
		
		}
	

	}
	

		
	

