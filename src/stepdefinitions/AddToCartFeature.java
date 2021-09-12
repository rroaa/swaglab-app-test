package stepdefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.cucumber.datatable.DataTable;

public class AddToCartFeature {
	
	WebDriver driver= stepdefinitions.ConnectionSetup.driver;
	
	// to call login test scenario
	LoginFeature loginFeature = new LoginFeature();
	
	// web elements used for testing
	WebElement productName;
	WebElement addToCartButton;
	WebElement cart;
	WebElement cartQuantity;
	
	// Cucumber(BBD) test for add to cart feature using Gherkin keywords 
	@Given("^User in products page$")
	public void productsPage() throws Throwable{
	loginFeature.loginPage();
	loginFeature.loginCredentials("standard_user", "secret_sauce");
	loginFeature.login();
	loginFeature.verifyProductsPage();
	}
	
	@When("^User select a \"([^\"]*)\"$")
	public void selectProduct(String product) throws Throwable{
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		productName = driver.findElement(By.xpath("//div[normalize-space()='"+product+"']"));
		productName.click();
	}
	
	@When("User select multiple products")
	public void selectMultipleProducts(DataTable dt) {
		String product;
		for(int i=1; i<dt.cells().size(); i++) {
			product=dt.cell(i,1);
			addToCartButton= driver.findElement(By.xpath("//*[text()= '" + product+ "']//following::button[1]"));
			addToCartButton.click();		
		}
	
	}
	
	@And("^User clicks on Add To The Cart button$")
	public void addToCart() throws Throwable{
		addToCartButton=driver.findElement(By.xpath("//button[normalize-space()='Add to cart']"));
		addToCartButton.click();
	}
	
	@Then("^Product added successfully in the shopping-cart$")
	public void verifyShoppingCart() throws Throwable{
		cart=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		cart.click();
		
		List<WebElement> CartItems = driver.findElements(By.xpath("//div[@class='cart_item']"));
    	int itemsQuantity = CartItems.size();
    	System.out.println("Items in the carts="+itemsQuantity);
	}
	
}
