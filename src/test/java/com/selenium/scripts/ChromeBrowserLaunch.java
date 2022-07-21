package com.selenium.scripts;

import static org.testng.Assert.*;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeBrowserLaunch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	WebDriverManager.chromedriver().setup();
		
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://percentagecalculator.net/");
	
	driver.findElement(By.xpath("//*[@id=\"f1\"]/fieldset[1]/input")).sendKeys("50");
	
	driver.findElement(By.xpath("//*[@id=\"f1\"]/fieldset[1]/nobr/input")).sendKeys("40");
	
	driver.findElement(By.xpath("//*[@id=\"f1\"]/fieldset[2]/input[1]")).click();
	
	int result=Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"f1\"]/fieldset[2]/input[2]")).getAttribute("value"));
	
	assertEquals(20, result);
	
	/*Scanner scan=new Scanner(System.in);
	
	System.out.println("Enter the expected percentage number");
	
	int ExpectedPercentage=scan.nextInt();
	
	
	if(result==ExpectedPercentage)
	{
		System.out.println("Test Case is Passed, percentage calculation is correct");
	}
	else
	{
		System.out.printf("Test Case Failed, percentage calculation should be:",result);
	} */
	
	} 

}
