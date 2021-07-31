package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class searchPage {
	RemoteWebDriver driver;
     By searchBox = By.id("twotabsearchtextbox");
     By productImage = By.xpath("//img[@class='s-image']");
	

	

	public searchPage(RemoteWebDriver driver2){

        this.driver = driver2;

    }
	
	public void setSearchBox(String word) {
		driver.findElement(searchBox).sendKeys(word, Keys.ENTER);
	}
	
	public WebElement getProductImage() {
		return driver.findElement(productImage);
	}
}
