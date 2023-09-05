package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Login {
	WebDriver driver;

	@Before
	public void setUp() {
		driver = DriverFactory.getDriver();
	}

	@Given("User navigates to Login page")
	public void user_navigates_to_login_page() {
		System.out.println(">>user is on the Login page");
		driver = DriverFactory.getDriver();
	}

	@When("User enters valid username {string}")
	public void user_enters_valid_username(String username) {

		driver.findElement(By.name("username")).sendKeys(username);
	}

	@And("Enter Valid password {string}")
	public void enter_valid_password(String psw) {
		driver.findElement(By.name("password")).sendKeys(psw);

	}

	@And("clicks on Login button")
	public void clicks_on_login_button() {
		driver.findElement(By.className("button")).click();

	}

	@Then("User should get navigated to overview page")
	public void user_should_get_navigated_to_overview_page() {
		Assert.assertTrue(driver.findElement(By.xpath("//h1[@class=\"title\"]")).isDisplayed());
	}

	@When("User enters invalid username {string}")
	public void user_enters_invalid_username(String invalidusr) {
		driver.findElement(By.name("username")).sendKeys(invalidusr);
	}

	@And("Enter invalid password {string}")
	public void enter_invalid_password(String invpsw) {
		driver.findElement(By.name("password")).sendKeys(invpsw);
	}

	
	@Then("User should get a proper warning message")
	public void User_should_get_a_proper_warning_message() {
	    Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/h1"))
	            .getText().contains("An internal error has occurred and has been logged."));
	}

	
	@Then("User should get a proper warning message about noncredentials")
	public void user_should_get_a_proper_warning_message_about_noncredentials() {
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p")).getText()
				.contains("Please enter a username and password.."));

	}

	@When("User dont enter username into username field")
	public void User_dont_enter_username_into_username_field() {
		driver.findElement(By.name("username")).sendKeys("");
	}

	@And("User dont enter password into password field")
	public void User_dont_enter_password_into_password_field() {
		driver.findElement(By.name("password")).sendKeys("");

	}

}
