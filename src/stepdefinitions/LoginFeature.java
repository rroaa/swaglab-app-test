package stepdefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;


public class LoginFeature {

	WebDriver driver= stepdefinitions.ConnectionSetup.driver;
	
	// web elements used for testing
	WebElement usernameField; 
	WebElement passwordField; 
	WebElement loginButton;
	WebElement productsPageTitle;
	WebElement errorMsg;
	
	// Cucumber(BBD) test for login feature using Gherkin keywords 
	@Given("^User has been registered in the website and user on the login page$")
	public void loginPage() throws Throwable{
		driver.get("https://www.saucedemo.com/");
	}
	
	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void loginCredentials(String username, String password) throws Throwable{
		usernameField= driver.findElement(By.xpath("//input[@id='user-name']"));
		passwordField=driver.findElement(By.xpath("//input[@id='password']"));
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
	}
	
	@And("^User clicks on login button$")
	public void login() throws Throwable{
		loginButton= driver.findElement(By.xpath("//input[@id='login-button']"));
		loginButton.click();
	}
	 
	@Then("^User is navigated to products page$")
	public void verifyProductsPage() throws Throwable{
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		productsPageTitle=driver.findElement(By.xpath("//span[@class='title']"));
		String actualTitle= productsPageTitle.getText();
		String expectedTitle="PRODUCTS";
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@Then("^Error message appears to the user$")
	public void verifyFailedLogin() throws Throwable{
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		errorMsg=driver.findElement(By.xpath("//div[@class='error-message-container error']"));
		Assert.assertEquals(errorMsg.getText(), "Epic sadface: Username and password do not match any user in this service");
	}
}
