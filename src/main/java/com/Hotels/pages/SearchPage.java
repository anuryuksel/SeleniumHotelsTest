package com.Hotels.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Hotels.base.BasePage;
import com.Hotels.util.Constants;
import com.Hotels.util.ElementUtil;

public class SearchPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	HomePage homePage;
	
	By deal = By.id("hdr-deals");
	
	By fiveStar= By.id("f-star-rating-5");
	By fourStar=By.id("f-star-rating-4");
	By threeStar=By.id("f-star-rating-3");
	By otelName = By.id("f-name");
	By otelbtn = By.id("f-name-cta");
	
	
	public SearchPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		
	}
//	public void getHomePage() {
//		homePage=new HomePage(driver);
//		homePage.Selections();
//	}
	
	public String getSearchPageTitle(){
		return elementUtil.waitForGetPageTitle(Constants.SEARCH_PAGE_TITLE);
	}
	
	public void selectFiveStar() throws InterruptedException{
		driver.findElement(fiveStar).click();
		Thread.sleep(2000);
	}
	public void selectFourStar() throws InterruptedException{
		driver.findElement(fourStar).click();
		Thread.sleep(2000);
	}
	public void selectThreeStar() throws InterruptedException{
		driver.findElement(threeStar).click();
		Thread.sleep(2000);
	}
	 public void selectOtelName() throws InterruptedException{
		 elementUtil.doSendKeys(otelName, "Hilton");
		 elementUtil.doClick(otelbtn);
		 Thread.sleep(5000);
	 }
	

	 public String distanceCloserTenMiles(){
			List<WebElement> hotels = driver.findElements(By.xpath("//a[@class='property-name-link']"));
			List<WebElement> hotelDistances=driver.findElements(By.xpath("//ul[@class='property-landmarks']/li[1]"));
			List<String> allHotels= new ArrayList<String>();
			List<String> allHotelDistances=new ArrayList<String>();
//			String text;
			for (int i=0; i<hotels.size(); i++){
				String a = (hotels.get(i).getText());
				String b = (hotelDistances.get(i).getText());
				String tenMileIssue=" ".concat(b);
				String [] xyz = tenMileIssue.split(" ");
				double hotelDistance=Double.parseDouble(xyz[1]);
				if(hotelDistance<=10){
				System.out.println(a + " is closer than 10 mile");

				}		
			}return null;
	
	
}
	 }
