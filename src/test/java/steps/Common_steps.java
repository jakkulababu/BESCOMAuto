package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Common_steps {

	private WebDriver driver;

	@Before
	public void launchChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@After
	public void closeBrowser() {
		driver.close();

	}

	public WebDriver getDriver() {
		return driver;
	}

}
