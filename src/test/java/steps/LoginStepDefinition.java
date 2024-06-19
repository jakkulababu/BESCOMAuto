package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	public WebElement loginLink;
	
	@FindBy(xpath ="//a[normalize-space()='Customer Login']")
	public WebElement selectConsumerLink;
	
	@FindBy(xpath = "//*[@name='userId']")
	public WebElement uid;

	@FindBy(xpath = "//*[@name='password']")
	public WebElement pws;

	@FindBy(xpath = "//*[@name='btnSubmit']")
	public WebElement signIn;

	@FindBy(xpath = "//button[@class='btn btn-secondary btn-md lgn-btn']")
	public WebElement signOutBack;
	
	@FindBy (xpath = "//a[normalize-space()='Logout']")
	public WebElement signOut;

	public LoginStepDefinition(Common_steps common_steps) {
		this.driver = common_steps.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void setUserIDAndPassword(String userid, String password) {
		
		uid.sendKeys(userid);
		pws.sendKeys(password);
	}

	public void clickSignIn() {
		signIn.click();
	}

	public void clickSignOut() {
		signOutBack.click();
		signOut.click();

	}

	@Given("Login to bescom app")
	public void login_to_bescom_app() {
		driver.get("https://www.bescom.co.in/bescom/login");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='LOGIN']")));
//		loginLink.click();
//		selectConsumerLink.click();
		
	}

	@When("enter {string} and {string} and click on ok button")
	public void enter_and_and_click_on_ok_button(String userid, String password) {
		setUserIDAndPassword(userid, password);
		clickSignIn();
	}

	@When("i enter user id and password and click on login button")
	public void i_enter_user_id_and_password_and_click_on_login_button(DataTable dataTable) {
		uid.sendKeys(dataTable.cell(1, 0));
		pws.sendKeys(dataTable.cell(1, 1));
		clickSignIn();
	}

	@When("i enter {string} and {string} and click on login button")
	public void i_enter_and_and_click_on_login_button(String userid, String password) {
		uid.sendKeys(userid);
		pws.sendKeys(password);
		clickSignIn();
	}

	@Then("I validate home link shoule be {string}")
	public void i_validate_home_link_shoule_be(String expected) {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@name='websiteName']")));
		String actualHeader = driver.findElement(By.xpath("//span[@name='websiteName']")).getText();
		Assert.assertEquals(expected, actualHeader);
		clickSignOut();
	}

	@Then("I validate home link is {string}")
	public void i_validate_home_link(String expectedString) {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@name='websiteName']")));
		String actualHeader = driver.findElement(By.xpath("//span[@name='websiteName']")).getText();
		Assert.assertEquals(expectedString, actualHeader);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ctl00_siteSearch_lnkLogout")));
//		clickSignOut();
	}

	@When("i enter invalid {string} and {string} and click on login button")
	public void i_enter_invalid_and_and_click_on_login_button(String userid, String password) {
		uid.sendKeys(userid);
		pws.sendKeys(password);
		clickSignIn();
	}

	@FindBy(xpath = "//span[@class='ErrorMessage']")
	WebElement commonErrorMessage;

	@Then("I validate error message shoule be {string}")
	public void i_validate_error_message_shoule_be(String error) {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ErrorMessage']")));
		String actualError = commonErrorMessage.getText();
//		String actual = driver.findElement(By.xpath("//span[@class='ErrorMessage']")).getText();
		Assert.assertEquals(error, actualError);
	}
}
