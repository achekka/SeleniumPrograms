package com.selenium.scripts;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertions {
	
	WebDriver driver;
	SoftAssert sa=new SoftAssert();
	
	@BeforeMethod
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	@Test
	public void openURL() {
	
		driver.get("https://www.selenium.dev/");
		driver.findElement(By.xpath("//a[@class=\"nav-link\"]")).click();
		String ActualTitle=driver.getCurrentUrl();
		String ExpectedTitle="https://selenium/downloads";
		sa.assertEquals(ActualTitle, ExpectedTitle);
		driver.findElement(By.xpath("//*[@id=\"main_navbar\"]/ul/li[6]/a/span")).click();
		String latestActualURL=driver.getCurrentUrl();
		String latestExpectedURL="https://www.selenium.dev/support/";
		sa.assertEquals(latestActualURL, latestExpectedURL);
		System.out.println("Soft Assertion is implemented successfully");
		sa.assertAll();
	}

	@Test
	public void percentageCalc() {
		
		driver=new ChromeDriver();
		driver.get("https://percentagecalculator.net/");
		driver.findElement(By.xpath("//*[@id=\"f1\"]/fieldset[1]/input")).sendKeys("50");
		driver.findElement(By.xpath("//*[@id=\"f1\"]/fieldset[1]/nobr/input")).sendKeys("40");
		driver.findElement(By.xpath("//*[@id=\"f1\"]/fieldset[2]/input[1]")).click();
		
		int result=Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"f1\"]/fieldset[2]/input[2]")).getAttribute("value"));
		
		assertEquals(20, result);
	}

	@AfterMethod
	public void closeBrowser() {
		// TODO Auto-generated method stub
		
		driver.quit();
		
	}
}
