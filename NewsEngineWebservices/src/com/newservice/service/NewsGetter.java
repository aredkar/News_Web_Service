package com.newservice.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.news.pojo.News;  

@Path("/getNews")
public class NewsGetter {

	   @GET
	   @Path("/getNewsfromdatetime/{datetime}")
	   @Produces(MediaType.APPLICATION_XML)
	   public String  getNews(@PathParam("datetime") String datetime){
		   
		   File folder = new File("D:/news/");
		   File[] listOfFiles = folder.listFiles();
		   String file_path = "";
		   String news_content=null;;
		   
		   for (int i = 0; i < listOfFiles.length; i++) {
			      if (listOfFiles[i].isFile()) {
			        System.out.println("File " + listOfFiles[i].getName());
			        
			        if (listOfFiles[i].getName().startsWith(datetime + "_")){
			        	file_path = listOfFiles[i].getName().trim();
			        }
			        
			      } 
			    }
		   
		  
		   
		   try {
		   
			    news_content = new String(Files.readAllBytes(Paths.get("D:/news/"+file_path)));
		   } catch (Exception e){
			   e.printStackTrace();
		   }
		   
	      return news_content;
	   }
	   
	   @GET
	   @Path("/getBreakingNews")
	   @Produces(MediaType.APPLICATION_XML)
	   public String  getNews() throws Exception{
		   
		   File folder = new File("D:/news/");
		   File[] listOfFiles = folder.listFiles();
		   String news_content=null;
		   String response="";
		   int newsCount=0;
		   
		   
		   for (int i = 0; (i < listOfFiles.length && newsCount<100); i++) {
			      if (listOfFiles[i].isFile()) {
			        System.out.println("File " + listOfFiles[i].getName());
			        
			        if (listOfFiles[i].getName().contains("_1_")){
			        	news_content = new String(Files.readAllBytes(Paths.get("D:/news/"+listOfFiles[i].getName().trim())));
			        	response =  response + news_content ;
			        	newsCount ++;
			        	
			        }
			        
			      } 
			    }
		   
		  
		   
		  System.out.println("The response :");
		  System.out.println(response);
		  return "<response>"+response+"</response>";
	   }
	
	   
	   
	   @GET
	   @Path("/getSportsNews")
	   @Produces(MediaType.APPLICATION_XML)
	   public String  getSportsNews() throws Exception{
		   
		   File folder = new File("D:/news/");
		   File[] listOfFiles = folder.listFiles();
		   String news_content=null;
		   String response="";
		   
		   
		   for (int i = 0; (i < listOfFiles.length); i++) {
			      if (listOfFiles[i].isFile()) {
			        System.out.println("File " + listOfFiles[i].getName());
			        
			        if (listOfFiles[i].getName().contains("_Sports_")){
			        	news_content = new String(Files.readAllBytes(Paths.get("D:/news/"+listOfFiles[i].getName().trim())));
			        	response =  response + news_content ;
			        	
			        }
			        
			      } 
			    }
		   
		  
		   
		  System.out.println("Response fetched :");
		  System.out.println(response);
		  return "<response>"+response+"</response>";
	   }
	   
	   @GET
	   @Path("/getFinanceNews")
	   @Produces(MediaType.APPLICATION_XML)
	   public String  getFinanceNews() throws Exception{
		   
		   File folder = new File("D:/news/");
		   File[] listOfFiles = folder.listFiles();
		   String news_content=null;
		   String response="";
		   
		   
		   for (int i = 0; (i < listOfFiles.length ); i++) {
			      if (listOfFiles[i].isFile()) {
			        System.out.println("File " + listOfFiles[i].getName());
			        
			        if (listOfFiles[i].getName().contains("_Finance_")){
			        	news_content = new String(Files.readAllBytes(Paths.get("D:/news/"+listOfFiles[i].getName().trim())));
			        
			        	response =  response + news_content ;
			        	
			        }
			        
			      } 
			    }
		   
		  
		   
		  System.out.println(response);
		  return "<response>"+response+"</response>";
	     
	   }
	   
	   @GET
	   @Path("/getGeneralNews")
	   @Produces(MediaType.APPLICATION_XML)
	   public String  getGeneralNews() throws Exception{
		   
		   File folder = new File("D:/news/");
		   File[] listOfFiles = folder.listFiles();
		   String news_content=null;
		   String response="";
		   
		   
		   for (int i = 0; (i < listOfFiles.length ); i++) {
			      if (listOfFiles[i].isFile()) {
			        System.out.println("File " + listOfFiles[i].getName());
			        
			        if (listOfFiles[i].getName().contains("_General_")){
			        	news_content = new String(Files.readAllBytes(Paths.get("D:/news/"+listOfFiles[i].getName().trim())));
			       
			        	response =  response + news_content ;
			        	
			        }
			        
			      } 
			    }
		   
		  
		   
		  System.out.println(response);
		  return "<response>"+response+"</response>";
	     
	   }
}
