package com.Hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Hotels.base.BasePage;
import com.Hotels.pages.HomePage;
import com.Hotels.util.Constants;


public class HomePageTest {

	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		homePage = new HomePage(driver);
		
		
	}
	
	@Test (priority = 1, description= "Home Page Title")
	public void getTitle(){
		String title = homePage.getTitleHomePage();
		System.out.println(title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Test (priority = 2, description= "Selections")
	public void Selections() throws InterruptedException{
		homePage.Selections();
		
	}
	
	@AfterMethod
	public void tearDown(){
		basePage.quit();
}
	}
