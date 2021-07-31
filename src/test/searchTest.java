package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import pageObjects.searchPage;
import procedures.searchProcedures;

public class searchTest {
	RemoteWebDriver driver;

  @Test 
  //*Test successful search*
  public void successSearch() {
	  String productName = "iPhone";
	  searchProcedures test = new searchProcedures(); 
	  test.searchWithWord( driver, productName);
	  
	  //*Validate that there are results found*
	  Assert.assertTrue(driver.getPageSource().contains("1-16 of over 1,000 results for"));
	  
	  //*Validate that the search retrieved products related to the searched product name *
	  boolean productDisplayed= driver.findElement(By.xpath("//img[@class='s-image']")).isDisplayed();
	  String retrievedProducts = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).getText();
	  Assert.assertTrue(productDisplayed && retrievedProducts.contains(productName)) ;
		
	  
  }
  
  @Test
 // *Test failure search*
  public void failSearch() {
	  String productName = "!";
	  searchProcedures test = new searchProcedures(); 
	  test.searchWithWord( driver, productName);
	  
	  //*Validate that No results message displayed for invalid searching word*
	  Assert.assertTrue(driver.getPageSource().contains("No results for")); 
  }
  
  
  @BeforeMethod
  //*Open chrome*
  public void beforeMethod() {
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--disable-notifications");
	  System.setProperty("webdriver.chrome.driver", "D:\\Selenium Training\\chromedriver.exe");
	   driver =new ChromeDriver(options);
		 driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		  
		//*open the Amazon website and maximize the screen*
			  
		      driver.get("https://www.amazon.com/");
		      driver.manage().window().maximize();
  }

  @AfterMethod
  //*close the window*
  public void afterMethod() {
	 driver.quit();
  }

}
