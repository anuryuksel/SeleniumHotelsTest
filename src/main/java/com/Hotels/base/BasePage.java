package com.Hotels.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;
	
	public WebDriver initialize_driver(Properties prop){
		
		String browser = prop.getProperty("browser");
		String headless = prop.getProperty("headless");
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/anur/Documents/drivers/chromedriver");
			if (headless.equalsIgnoreCase("yes")) {
				ChromeOptions cOptions = new ChromeOptions();
				cOptions.addArguments("--headless");
				driver = new ChromeDriver(cOptions);
			}else{
			 driver = new ChromeDriver();
			}
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (headless.equalsIgnoreCase("yes")) {
				FirefoxOptions fOptions = new FirefoxOptions();
				fOptions.addArguments("--headless");
				driver = new FirefoxDriver(fOptions);
			}else {
				driver = new FirefoxDriver();
				
			}
		}
		
		
		
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	
		driver.get("https://www.hotels.com");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return driver;
	}
		
		public Properties initialize_properties(){
			
			prop = new Properties();
			try {
				FileInputStream ip= new FileInputStream("/Users/anur/Documents/workspace/IlhanHocaTestNG/"
						+ "src/main/java/config/hubspot/config/config.properties");
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return prop;
		}
	
	
	public void quit(){
		try {
			driver.quit();
		
		} catch (Exception e) {
			System.out.println("Some exception occuren while browser closing");
	}
	
	
	
	
	
	
	}
}
