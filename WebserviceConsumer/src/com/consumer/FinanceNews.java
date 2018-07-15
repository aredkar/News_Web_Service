package com.consumer;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class FinanceNews {

	public static final String REST_SERVICE_GET_URL ="http://localhost:8080/NewsEngineWebservices-1.0.0/rest/getNews";
	private Client client;
	private void init(){
	      this.client = ClientBuilder.newClient();
	   }
	
	public static void main(String[] args){
		FinanceNews newspost=new FinanceNews();
		newspost.getFinanceNews();
	}
	
	 private void getFinanceNews(){
		 
		 init();
		 String response = client
	             .target(REST_SERVICE_GET_URL)
	             .path("getFinanceNews")
	             .request(MediaType.APPLICATION_XML)
	             .get(String.class);
		 
	      System.out.println("Advanced For Loop :"+ response); 		
          
	 }
	
}
