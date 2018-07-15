package com.news.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class News implements Serializable {

	String contentType;
     String priority;
   String datetime;
    String newsHeading;
     String newsContent;
	public String getContentType() {
		return contentType;
	}
	@XmlElement
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getPriority() {
		return priority;
	}
	@XmlElement
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getDatetime() {
		return datetime;
	}
	@XmlElement
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getNewsHeading() {
		return newsHeading;
	}
	@XmlElement
	public void setNewsHeading(String newsHeading) {
		this.newsHeading = newsHeading;
	}
	public String getNewsContent() {
		return newsContent;
	}
	@XmlElement
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
     
     
	
	
}
