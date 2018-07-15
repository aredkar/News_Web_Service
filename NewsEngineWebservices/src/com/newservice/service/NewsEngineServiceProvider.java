package com.newservice.service;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.news.pojo.News;  

@Path("/newsengine")  
public class NewsEngineServiceProvider {
	private static final String OPERATION_SUCCESS_STATUS = "<result>success</result>";
	
	private static void writeToXML(News news,String output_file) {

      try{
    	 
    	  String xmlString = "<news><contentType>"+news.getContentType()+"</contentType>"+
    			  "<priority>"+news.getPriority()+"</priority>"+
    			  "<datetime>"+news.getDatetime()+"</datetime>"+
    			  "<newsHeading>"+news.getNewsHeading()+"</newsHeading>"+
    			  "<newsContent>"+news.getNewsContent()+"</newsContent></news>";
    	  
    	  BufferedWriter writer = new BufferedWriter(new FileWriter(output_file));
    	    writer.write(xmlString);
    	     
    	    writer.close();
    	  
    	  
      }catch (Exception e) {
		// TODO: handle exception
    	  e.printStackTrace();
	}
            
        	
       
    }

	  
	   @POST
	   @Path("/postNews")
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	   public String createNews(@FormParam("contentType") String contentType,
	      @FormParam("priority") String priority,
	      @FormParam("datetime") String datetime,
	      @FormParam("newsHeading") String newsHeading,
	      @FormParam("newsContent") String newsContent,
	      @Context HttpServletResponse servletResponse) throws IOException {
		   
		   String fileName = "D:/news/" + datetime + "_" + priority + "_" + contentType +"_"+ "news.xml";
		   
		   News news = new News();
		   news.setContentType(contentType);
		   news.setPriority(priority);
		   news.setDatetime(datetime);
		   news.setNewsContent(newsContent);
		   news.setNewsHeading(newsHeading);
		   
		   writeToXML(news,fileName);
		   
		   return OPERATION_SUCCESS_STATUS;
	     
	   }
	
	
}
