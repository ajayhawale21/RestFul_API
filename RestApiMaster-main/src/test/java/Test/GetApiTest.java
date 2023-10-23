package Test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import client.RestClient;

public class GetApiTest extends TestBase {
	TestBase tb;
	String serviceUrl;
	String apiUrl;
	String url;
	RestClient restClient;

	public GetApiTest() throws IOException {
		super();

	}

	@BeforeMethod

	public void setup() throws IOException {
		tb = new TestBase();
		serviceUrl = prop.getProperty("URL");
		apiUrl = prop.getProperty("serviceURL");
		url = serviceUrl + apiUrl;

		

	}
	
	
	
	
	
	
	
	
	@Test
	public void getApiTest() throws ClientProtocolException, IOException {
	 restClient = new RestClient();
		restClient.get(url);	
	}

}
