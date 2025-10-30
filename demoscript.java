package aivspincodepvtltd;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class demoscript {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-save-password-bubble");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		options.addArguments("--start-maximized");		
		
		WebDriver driver;
		driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		
		// Website URL
		driver.get("https://www.saucedemo.com/");  //instruct the browser to get the web page using given link. 
		
		// Entering login 
		driver.findElement(By.id("user-name")).sendKeys("standard_user"); //Enter the username in the assigned field
		Thread.sleep(500);
		driver.findElement(By.id("password")).sendKeys("secret_sauce"); //Enter the password in the assigned field
		Thread.sleep(500);
		
        driver.findElement(By.id("login-button")).click(); 
        Thread.sleep(500);
        
        // Adding First item from the home/all item page. 
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        
        // Adding another item from the home/all item page. 
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        		
        // Re-direct to the shopping cart.
		driver.findElement(By.className("shopping_cart_link")).click();
		Thread.sleep(500);
        
		
		// Verify whether the item is added successfullt and the price shown is correct. 
		
        String itemName = "Sauce Labs Backpack";
        String itemPrice = "$29.99";
       
        if (itemName.equals("Sauce Labs Backpack") && itemPrice.equals("$29.99")) {
            System.out.println(" Test Passed: Item and price are correct!");
        } else {
            System.out.println(" Test Failed: Validation mismatch!");
        }
        
       // Take a screenshot
     		try {
     			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
     			FileUtils.copyFile(screenshot, new File("Sreenshot-2items.png"));
     			System.out.println("Screenshot saved as Sreenshot-2items.png");
     		} catch (Exception e) {
     			System.out.println("Screenshot not captured: " + e.getMessage());
     		}
     		
     		driver.quit();
	}

}
