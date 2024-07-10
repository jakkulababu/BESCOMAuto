package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	public WebElement signOut;

	@FindBy(xpath = "//span[@name='websiteName']")
	public	WebElement HomeText;

	@FindBy(xpath = "//button[@class='btn btn-secondary btn-md lgn-btn']")
	public WebElement signOutBack;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public void clickSignOut() {
		signOutBack.click();
		signOut.click();

	}

}
