package com.qa.ascendum.pages.actions;

import org.openqa.selenium.By;
import com.qa.ascendum.base.BaseActions;
import com.qa.ascendum.base.TestBase;
import com.qa.ascendum.pages.locators.HomePageLocators;

public class HomePageActions extends TestBase {
	
	BaseActions baseActions = new BaseActions();
	
	
	//Locators of Home Page
	public static final String img_logo = "//a[@class='navbar-brand']/img/@src";
	public static final String link_services = "//li[@class='dropdown']/a[@class='dropdown-toggle']";
	//public static final String link_products = "//ul[@class='nav navbar-nav']/li[2]/a";
	//public static final String link_company  = "//ul[@class='nav navbar-nav']/li[3]/a";
	//public static final String link_blog = "//ul[@class='nav navbar-nav']/li[4]/a";
	public static final String link_resources = "//ul[@class='nav navbar-nav']/li[5]/a";
	public static final String link_careers = "//ul[@class='nav navbar-nav']/li[6]/a";
	public static final String link_contact = "//ul[@class='nav navbar-nav']/li[7]/a";
	
	
	public void verifyHomePageElements()
	{
		baseActions.checkIfWebElementIsPresent(driver.findElement(By.xpath(link_services)));
//		baseActions.checkIfWebElementIsPresent(driver.findElement(By.xpath(link_products)));
//		baseActions.checkIfWebElementIsPresent(driver.findElement(By.xpath(link_company)));
//		baseActions.checkIfWebElementIsPresent(driver.findElement(By.xpath(link_blog)));
		baseActions.checkIfWebElementIsPresent(driver.findElement(By.xpath(link_resources)));
		baseActions.checkIfWebElementIsPresent(driver.findElement(By.xpath(link_careers)));
		baseActions.checkIfWebElementIsPresent(driver.findElement(By.xpath(link_contact)));	
		
	}
	
	public void checkLinks()
	{
		baseActions.checkAllAnchorTags();
	}

}
