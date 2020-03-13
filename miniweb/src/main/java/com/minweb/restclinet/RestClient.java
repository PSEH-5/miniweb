package com.minweb.restclinet;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;

public class RestClient {

	public static String executeAPI() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		System.out.println(getBaseURI());
		WebTarget target = client.target(getBaseURI());
		String response=target.request().accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(response);
		return response;
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("https://apiv2.apifootball.com").queryParam("action", "get_standings").queryParam("league_id", "148").queryParam("APIkey", "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978").build();
	}


}
