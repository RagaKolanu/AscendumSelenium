package com.qa.ascendum.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

public class BaseActions extends TestBase
{
	
	 String url = "";
	 String homePage = "https://ascendum.com";
       
	// gets the text for the related webElement
		public String retrieveText(WebElement retrieveText) {
			final String text = retrieveText.getText();
			System.out.println("The text for the webelement is : " + text);
			return text;
		}
	
	
	
		//checks if the element is present or not on the page
	public void checkIfWebElementIsPresent(WebElement element) {
		final Boolean checkElementPresent = element.isDisplayed();
		if (checkElementPresent.equals(true)) {
			System.out.println("The webelement : " + retrieveText(element) + " is present on the web page.");
		} else {
			System.out.println("The welelment : " + retrieveText(element)
					+ " is miising - There might be some error in loading of the page. Please refresh and try again.");
		}
	}
		
	
	//gets all the anchor tags in the page
	public void checkAllAnchorTags()
	{	
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));	
			Iterator<WebElement> it = allLinks.iterator();
	        while(it.hasNext())
	        {
	            
	            url = it.next().getAttribute("href");
	            if(url == null || url.isEmpty())
	            {
	            	System.out.println("The Url you are trying to access is either broken or is not configured");
	            	continue;
	            }
	            
	            if(!url.startsWith(homePage))
	            {
	            	System.out.println("*************************************************************");
	                System.out.println( url + " - URL belongs to another domain. Hence, skipping it.");
	                System.out.println("*************************************************************");
	                continue;
	            }
			 
			 validateUrl(url);
	        }
	}
	
	public static void validateUrl(String link)
	{
	            try 
	            {
	            	URL url = new URL(link);
	            	
	            	HttpURLConnection httpConn =(HttpURLConnection)url.openConnection();
	            	httpConn.setConnectTimeout(2000);
	            	httpConn.connect();
	            
	            	 if(httpConn.getResponseCode()== 200)
	            	 { 
	            	 System.out.println(link + " - " + httpConn.getResponseMessage() + ". The url is valid");
	            	 System.out.println();
	            	 }
	            	 if(httpConn.getResponseCode()>= 400) 
	            	 {
	            	 System.out.println(link + " - "+httpConn.getResponseMessage());
	            	 }        	 
	 }	  
	            catch (Exception e) 
	            {
	            	e.printStackTrace();
	            }
	}

}
