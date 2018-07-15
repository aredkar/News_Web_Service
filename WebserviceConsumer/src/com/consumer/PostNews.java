package com.consumer;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class PostNews {
	public static final String REST_SERVICE_URL = "http://localhost:8080/NewsEngineWebservices-1.0.0/rest/newsengine/postNews";
	public static final String REST_SERVICE_GET_URL ="http://localhost:8080/NewsEngineWebservices-1.0.0/rest/getNews/getNewsfromdatetime/";
	private Client client;
	private void init(){
	      this.client = ClientBuilder.newClient();
	   }
	
	public static void main(String[] args){
		PostNews newspost=new PostNews();

		newspost.postTheNews("Sports", "1", "12345", "New Victory for India", "India won in England");
		newspost.postTheNews("Finance", "1", "12346", "India GDP growth", "India to over take France in GDP");
		newspost.postTheNews("Sports", "1", "12347", "Urgentina out of worls cup", "France defeated Urgentina ");
		newspost.postTheNews("Finance", "1", "12348", "Demonetization!!", "1000 and 500 notes banned!");
		newspost.postTheNews("Sports", "1", "12349", "Hockey cup", "India wins hockey cup");
		
		newspost.postTheNews("General", "2", "12341", "Central election in 2019", "Elections date yet to announce");
		newspost.postTheNews("General", "2", "12342", "Road widening continues in Pune", "PCMC taking up road widening activity");
		newspost.postTheNews("General", "2", "12343", "Mumbai water clauging", "Mumbai may face flood again");
		newspost.postTheNews("General", "2", "12344", "Train delay", "Trains to run late due to rain");
		newspost.postTheNews("General", "2", "12311", "New Airports", "India to develop new airports");
		
		newspost.getNews("12345");
	}
	

	  private void getNews(String timestamp){
		  init();
	      String file_content = client
	         .target(REST_SERVICE_GET_URL)
	         .path("/{datetime}")
	         .resolveTemplate("datetime", timestamp)
	         .request(MediaType.APPLICATION_XML)
	         .get(String.class);
	    
	      System.out.println("The XML String :" + file_content );
	   }


private void postTheNews(String contentType,String priority,
		String datetime,
		String newsHeading,
		String newsContent){
    Form form = new Form();
    form.param("contentType", contentType);
    form.param("priority", priority);
    form.param("datetime", datetime);
    form.param("newsHeading", newsHeading);
    form.param("newsContent", newsContent);

    init();
    String callResult = client
       .target(REST_SERVICE_URL)
       .request(MediaType.APPLICATION_XML)
       .post(Entity.entity(form,
          MediaType.APPLICATION_FORM_URLENCODED_TYPE),
          String.class);
 
 

    System.out.println("Post News Result: " + callResult );
 }

}