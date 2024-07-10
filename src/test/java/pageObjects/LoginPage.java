package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	public WebElement loginLink;

	@FindBy(xpath = "//a[normalize-space()='Customer Login']")
	public WebElement selectConsumerLink;

	@FindBy(xpath = "//*[@name='userId']")
	public WebElement uid;

	@FindBy(xpath = "//*[@name='password']")
	public WebElement pws;

	@FindBy(xpath = "//*[@name='btnSubmit']")
	public WebElement signIn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void setUserIDAndPassword(String userid, String password) {

		uid.sendKeys(userid);
		pws.sendKeys(password);
	}

	public void clickSignIn() {
		signIn.click();
	}

}
