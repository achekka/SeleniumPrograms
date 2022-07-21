package com.selenium.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod; 
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AnnotationTest {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void openURL() {
	
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		
	}
	
	@Test (priority=1)
	public void forgetPassword() {
		
		driver.findElement(By.xpath("//a[@href=\"/login\"]")).click();
		
		driver.findElement(By.xpath("//a[@href=\"/passwordrecovery\"]")).click();
		
		driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("abc123@gmail.com");
		
		driver.findElement(By.xpath("//input[@value=\"Recover\"]")).click();
		
	}
	
	@Test (priority=0)
	public void register() {
		
		driver.findElement(By.xpath("//a[@href=\"/register\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"gender-male\"]")).click();
		
		driver.findElement(By.xpath("//input[@id=\"FirstName\"]")).sendKeys("Human");
		
		driver.findElement(By.xpath("//input[@id=\"LastName\"]")).sendKeys("Being");
		
		driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("retun345@gmail.com");
		
		driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("Test123");
		
		driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]")).sendKeys("Test123");
		
		driver.findElement(By.xpath("//input[@id=\"register-button\"]")).click();
			
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.quit();
		
	}

}
