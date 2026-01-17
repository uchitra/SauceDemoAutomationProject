package com.basic;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAndCart {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	
WebDriver driver = new ChromeDriver();

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.manage().window().maximize();

driver.get("https://www.saucedemo.com");
driver.findElement(By.id("user-name")).sendKeys("standard_user");
driver.findElement(By.id("password")).sendKeys("secret_sauce");
driver.findElement(By.id("login-button")).click();
WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));

wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack"))).click();

wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-bike-light"))).click();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")));

String cartcount=driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
if (cartcount.equals("2")) {
	System.out.println("successfully 2 products added");
	
}else {
	System.out.println("unsuccefully run");
}
wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link"))).click();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
List<WebElement> products= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("inventory_item_name")));
for(WebElement p: products) {
	System.out.println("products in cart" +p.getText());
	  }
wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout"))).click();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
driver.findElement(By.id("first-name")).sendKeys("Test");
driver.findElement(By.id("last-name")).sendKeys("User");
driver.findElement(By.id("postal-code")).sendKeys("411001");
wait.until(ExpectedConditions.elementToBeClickable(By.id("continue"))).click();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

wait.until(ExpectedConditions.elementToBeClickable(By.id("finish"))).click();

String successmsg= wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header"))).getText();
System.out.println("order status  "+ successmsg);
 

driver.quit();



	}

}
