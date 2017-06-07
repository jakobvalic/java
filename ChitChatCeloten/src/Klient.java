import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Klient {

	public static void prijavi(String uporabnik) throws IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://chitchat.andrej.com");
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		try {
		    System.out.println(response1.getStatusLine());
		    HttpEntity entity1 = response1.getEntity();
		    EntityUtils.consume(entity1);
		} finally {
		    response1.close();
		}

		HttpPost httpPost = new HttpPost("http://chitchat.andrej.com/users");
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("username", uporabnik));
		nvps.add(new BasicNameValuePair("password", "secret"));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);

		try {
		    System.out.println(response2.getStatusLine());
		    HttpEntity entity2 = response2.getEntity();
		    EntityUtils.consume(entity2);
		} finally {
		    response2.close();
		}
	}
	public static void seznam() throws IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://chitchat.andrej.com/users");
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		try {
		    System.out.println(response1.getStatusLine());
		    HttpEntity entity1 = response1.getEntity();
		    String response2String = EntityUtils.toString(entity1, "UTF-8");
			System.out.println(response2String);
		    EntityUtils.consume(entity1);
		} finally {
		    response1.close();
		}


	
	}
	
	public static void odjavi(String uporabnik) throws IOException, URISyntaxException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://chitchat.andrej.com");
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		
		URIBuilder builder = new URIBuilder("http://chitchat.andrej.com/users");
		builder.addParameter("username", uporabnik);
		URI url = new URI(builder.toString());
		Request.Delete(url);
		System.out.println(response1.getEntity().getContent());

	
	}


	}
	

