package procedures;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageObjects.searchPage;

public class searchProcedures {

	
	public static void searchWithWord(RemoteWebDriver driver, String word) {
		searchPage search = new searchPage(driver);
		search.setSearchBox(word);

	}
}
