package aivspincodepvtltd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class demoscript {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.get("https://www.saucedemo.com/");  //instruct the browser to get the web page using given link. 
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user"); //Enter the username in the assigned field
		Thread.sleep(500);
		driver.findElement(By.id("password")).sendKeys("secret_sauce"); //Enter the password in the assigned field
		Thread.sleep(500);
		
        driver.findElement(By.id("login-button")).click(); 
        Thread.sleep(500);
        
        driver.findElement(By.className("inventory_item_img")).click();        
        Thread.sleep(500);
        
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();        
        Thread.sleep(500);
        
        driver.findElement(By.className("shopping_cart_link")).click();
        
        String itemName = "Sauce Labs Backpack";
        String itemPrice = "$29.99";
        
        if (itemName.equals("Sauce Labs Backpack") && itemPrice.equals("$29.99")) {
            System.out.println(" Test Passed: Item and price are correct!");
        } else {
            System.out.println(" Test Failed: Validation mismatch!");
        }
	}

}
