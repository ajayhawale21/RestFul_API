package client;

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
//

import io.netty.handler.codec.Headers;

public class RestClient {

	public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);// HTTP GET REQUEST IT WILL CREATE
		CloseableHttpResponse allResponse = httpClient.execute(httpGet); // it will hit send button in postman, same thing
		
		int StatusCode = allResponse.getStatusLine().getStatusCode();
		System.out.println("The Status code is .." + StatusCode);

		//json format into string
		
		String responseString = EntityUtils.toString(allResponse.getEntity(), "UTF-8");

		JSONObject responseJson = new JSONObject(responseString);// complete json format response it will store

		System.out.println("The response Json from API .." + responseJson);
		
		// getting all headers

		Header[] headersArray = allResponse.getAllHeaders();

		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headersArray) {
			allHeaders.put(header.getName(), header.getValue());
		}

		System.out.println("All headers are.." + allHeaders);

		
		
		
		
	}

}
