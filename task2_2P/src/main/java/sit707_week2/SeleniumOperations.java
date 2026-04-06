package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
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
		 System.setProperty("webdriver.chrome.driver",
		    		"C:/Deakin/Y2/T2/software quality/dddd/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
		   
		    ChromeOptions options = new ChromeOptions();
	        options.setBinary("C:/Deakin/Y2/T2/software quality/chrome-win64/chrome.exe");


	        WebDriver driver = new ChromeDriver(options);
	        System.out.println(driver);

	        driver.get("https://www.google.com");
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Ahsan");
		
		/*
		 * Find following input fields and populate with values
		 */
		driver.findElement(By.id("lastname")).sendKeys("Weerakoon");
		driver.findElement(By.id("email")).sendKeys("test123@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123");
		driver.findElement(By.id("confirmPassword")).sendKeys("123");
		
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		driver.findElement(By.xpath("//button[contains(text(),'Create account')]")).click();
		sleep(5);
		
		/*
		 * Take screenshot using selenium API.
		 */
		try {
		    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(src, new File("officeworks_registration.png"));
		    System.out.println("Screenshot saved.");
		} catch (IOException e) {
		    e.printStackTrace();
		}		
		
		// Sleep a while
		sleep(30);
		
		// close chrome driver
		driver.close();	
	}
	
	public static void second_registration_page(String url) {

	    System.out.println("Testing second registration page.");

	    System.setProperty("webdriver.chrome.driver",
	    		"C:/Deakin/Y2/T2/software quality/dddd/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
	   
	    ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Deakin/Y2/T2/software quality/chrome-win64/chrome.exe");


        WebDriver driver = new ChromeDriver(options);
        System.out.println(driver);

        driver.get("https://www.google.com");

	    driver.get(url);
	    sleep(3);

	    driver.findElement(By.id("username")).sendKeys("shaluka123");
	    sleep(2);

	    driver.findElement(By.id("password")).sendKeys("123");
	    sleep(2);

	    driver.findElement(By.id("confirmPassword")).sendKeys("123");
	    sleep(2);

	    driver.findElement(By.xpath("//button[contains(text(),'Register')]")).click();
	    sleep(5);

	    try {
	    	File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	    	java.nio.file.Files.copy(
	    	    src.toPath(),
	    	    new File("second_registration.png").toPath(),
	    	    java.nio.file.StandardCopyOption.REPLACE_EXISTING
	    	);

	    	System.out.println("Second screenshot saved.");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    sleep(10);
	    driver.close();
	}
	
	
}
