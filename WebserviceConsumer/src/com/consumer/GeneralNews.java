package com.consumer;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class GeneralNews {

	public static final String REST_SERVICE_GET_URL ="http://localhost:8080/NewsEngineWebservices-1.0.0/rest/getNews";
	private Client client;
	private void init(){
	      this.client = ClientBuilder.newClient();
	   }
	
	public static void main(String[] args){
		GeneralNews newspost=new GeneralNews();
		newspost.getGeneralNews();
	}
	
	 private void getGeneralNews(){
		 
		 init();
		 String response = client
	             .target(REST_SERVICE_GET_URL)
	             .path("getGeneralNews")
	             .request(MediaType.APPLICATION_XML)
	             .get(String.class);
		 
	      System.out.println("Advanced For Loop :"+ response); 		
          
	 }
	
}
