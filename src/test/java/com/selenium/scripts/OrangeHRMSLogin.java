package com.selenium.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMSLogin {
	
	public WebDriver driver;
	
	@BeforeMethod
	
	public void browserLaunch()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	
	public void Enterlogindetails()
	{
		driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys("admin123");		
		driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).clear();
	}
	
	@Test
	
	public void loginButton()
	{
		driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
	}
	
	@Test
	
	public void ForgetPasswordLink()
	{
		driver.findElement(By.xpath("//*[@id=\"forgotPasswordLink\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"securityAuthentication_userName\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@id=\"btnSearchValues\"]")).click();	
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}

}
