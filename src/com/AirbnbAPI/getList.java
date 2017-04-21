package com.AirbnbAPI;

import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class getList {
	private static final String apikey = "3092nxybyb0otqw18e8nh5nty";
	
	public static String getList() throws IOException{
		//IN String lat; String lon
		//OUT String locationKey
		String locationKey = null;
		//SEND REQUEST TO API AND GET RESPONSE
		String result = null;
		HttpClient httpclient = HttpClients.createDefault();
        try
        {
            URIBuilder builder = new URIBuilder("https://api.airbnb.com/v2/search_results");
            
            builder.setParameter("client_id", apikey);
            builder.setParameter("currency", "USD");
            builder.setParameter("guests", "1");
            builder.setParameter("location", "Hong Kong");
            builder.setParameter("ib", "false");
            
            URI uri= builder.build();
            HttpGet request = new HttpGet(uri);
            HttpResponse response = httpclient.execute(request);
            System.out.println("response"+response);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
            	result = EntityUtils.toString(entity);
            	System.out.println(result);
            }
        }
        catch (Exception e)
        {
        	System.out.println("exception"+ e.getMessage());
        }
    
        //PARSE THE RESPONSE JSON TO GET LOCATION KEY
        try {
			JSONObject jsonBuff1 = new JSONObject(result);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
		return result;
	}
}
