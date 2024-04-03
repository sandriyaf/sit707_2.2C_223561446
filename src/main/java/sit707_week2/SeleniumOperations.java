package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;


public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:/Users/sandr/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		
		// Find first input field which is firstname
		WebElement firstnameLocator = driver.findElement(RelativeLocator.with(By.tagName("input")).above(driver.findElement(By.id("lastname"))));
		// Send first name
		firstnameLocator.sendKeys("Sandriya");
		
		WebElement lastnameLocator = driver.findElement(RelativeLocator.with(By.tagName("input")).below(driver.findElement(By.id("firstname"))));
		// Send last name
		lastnameLocator.sendKeys("Fernandes");
		
		WebElement phonenoLocator = driver.findElement(RelativeLocator.with(By.tagName("input")).above(driver.findElement(By.id("email"))));
		// Send phone no
		phonenoLocator.sendKeys("043703452");
		
		WebElement emailLocator = driver.findElement(RelativeLocator.with(By.tagName("input")).below(driver.findElement(By.id("phoneNumber"))));
		// Send email
		emailLocator.sendKeys("sandriyafernandes35@gmail.com");
		
		WebElement passwordLocator = driver.findElement(RelativeLocator.with(By.tagName("input")).above(driver.findElement(By.id("confirmPassword"))));
		// Send password
		passwordLocator.sendKeys("San@1234");
		
		WebElement confpasswordLocator = driver.findElement(RelativeLocator.with(By.tagName("input")).near(driver.findElement(By.id("confirmPassword-label"))));
		// Send password
		confpasswordLocator.sendKeys("San@123");
		
		
		WebElement submitLocator = driver.findElement(RelativeLocator.with(By.tagName("button")).below(driver.findElement(By.className("MuiToggleButton-label"))));
		submitLocator.click();
		
		//Take screenshot using selenium API.
		
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
	        // Save the screenshot to a file
	        FileUtils.copyFile(screenshotFile, new File("C:/Users/sandr/Downloads/screenshotsan.png"));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	
		// Sleep a while
		sleep(30);
		
		// close chrome driver
		driver.close();	
	}		
}
