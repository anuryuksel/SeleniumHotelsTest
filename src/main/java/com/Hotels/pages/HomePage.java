package com.Hotels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Hotels.base.BasePage;
import com.Hotels.util.Constants;
import com.Hotels.util.ElementUtil;

public class HomePage extends BasePage {


	WebDriver driver;
	ElementUtil elementUtil;
	
	By destination = By.id("qf-0q-destination");
	By NewYorkCity = By.id("citysqm-asi0-s1");
	By checkInBox = By.id("qf-0q-localised-check-in");
	By checkInDate = By.xpath("//td[@data-date='2020-2-28']");
	By checkOutBox = By.id("qf-0q-localised-check-out");
	By checkOutDate = By.xpath("//td[@data-date='2020-3-4']");
	By rooms = By.id("qf-0q-rooms");
	By adult = By.id("qf-0q-room-0-adults");
	By children = By.id("qf-0q-room-0-children");
	By children1 = By.id("qf-0q-room-0-child-0-age");
	By children2 = By.id("qf-0q-room-0-child-1-age");
	By searchbttn = By.xpath("//button[@type='submit']");
	
	
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		elementUtil = new ElementUtil(driver);
	}


	public String getTitleHomePage(){
	 return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
	
	}
	
	
	public SearchPage Selections()  {
	
		elementUtil.doSendKeys(destination, "New York, New York, United States of America");

		driver.findElement(checkInBox).clear();
		elementUtil.doSendKeys(checkInBox, "03/28/20");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(checkOutBox).clear();
		elementUtil.doSendKeys(checkOutBox, "04/3/20");
		
	
		elementUtil.SelectDropDownValueByText(driver, rooms, "2");
	
		elementUtil.SelectDropDownValueByText(driver, adult, "2");
		elementUtil.doClick(children);
		elementUtil.SelectDropDownValueByText(driver, children, "2");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		elementUtil.SelectDropDownValueByText(driver, children1, "11");
		elementUtil.doClick(children2);
		elementUtil.SelectDropDownValueByText(driver, children2, "6");
		elementUtil.doClick(searchbttn);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SearchPage(driver);
	}
	
	
	
	
	
}
