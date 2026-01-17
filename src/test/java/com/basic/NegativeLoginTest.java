package com.basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NegativeLoginTest {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       driver.get("https://www.saucedemo.com");
	       driver.findElement(By.id("user-name")).sendKeys("user");
	       driver.findElement(By.id("password")).sendKeys("pass");
	       driver.findElement(By.id("login-button")).click();
	       String errormsg =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3[data-test='error']"))).getText();
	       if (errormsg.contains("Username and password do not match any user in this service")) {
	    	   System.out.println(" negative login test passed ");
	    	   System.out.println("Error Massage"+ errormsg);
	       }else {
	    		   System.out.println("negative login test failed");
	    		   
				
			}

	}

}
