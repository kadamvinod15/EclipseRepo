package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases {
	
	public static WebDriver driver;

	public static WebDriver browserSetup(String brName) {

		if("chrome".equals(brName)) {
			System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		return driver;
	}

	public void login() {
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.cssSelector("#form > div.row > div > button")).click();
	}

	@BeforeMethod 
	public void openBrowser() {
		driver=browserSetup("chrome");
		driver.get("file:///D:/Vinod/JavaByKiran/Selenium%20Softwares/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void loginFunctionality() {
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		String title = driver.getTitle();
		
		Assert.assertEquals("JavaByKiran | Dashboard", title);
	}
	
	@Test
	public void userFunctionality() {
		driver.findElement(By.xpath("//span[contains(text(),'Users')]")).click();
		String title2 = driver.getTitle();
		Assert.assertEquals(title2, "JavaByKiran | User");
	}
}
