package com.Hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Hotels.base.BasePage;
import com.Hotels.pages.HomePage;
import com.Hotels.pages.SearchPage;
import com.Hotels.util.Constants;

public class SearchPageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	SearchPage searchPage;
	

@BeforeMethod
public void setUp()  {
	basePage = new BasePage();
	prop = basePage.initialize_properties();
	driver = basePage.initialize_driver(prop);
	homePage = new HomePage(driver);
	searchPage = homePage.Selections();
	

}	
	@Test(priority=1, description="Search Page Title")
	public void verifySearchPageTitle(){
	String title=searchPage.getSearchPageTitle();
	System.out.println(title);
	Assert.assertEquals(title, Constants.SEARCH_PAGE_TITLE);
	}
	@Test (priority = 2, description="5 Stars Hotels")
	public void fiveStarCloserThanTenMiles() throws InterruptedException{
	searchPage.selectFiveStar();
	searchPage.distanceCloserTenMiles();
	}
	
//	@Test (priority=3, description="4 Stars Hotels")
//	public void fourStarCloserThanTenMiles() throws InterruptedException{
//		searchPage.selectFourStar();
//		searchPage.distanceCloserTenMiles();
//	}

	
	@Test(priority=4, description="3 Stars Hotels")
	public void threeStarCloserThanTenMile() throws InterruptedException{
		searchPage.selectThreeStar();
		searchPage.distanceCloserTenMiles();
	}
	@Test
	public void selectHotelCloserThanTenMile() throws InterruptedException{
		searchPage.selectOtelName();
		searchPage.distanceCloserTenMiles();
	}
	@AfterMethod
	public void tearDown(){
		basePage.quit();
	}

}
