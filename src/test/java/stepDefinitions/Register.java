package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.*;

public class Register {
    
	WebDriver driver;
	
	@Given("User navigated to Register Account page")
	public void user_navigated_to_register_account_page() {
        driver = DriverFactory.getDriver();
        driver.findElement(By.linkText("Register")).click();
	
	}

	@When("User enters firstname {string} into the First Name field")
	public void user_enters_firstname_into_the_first_name_field(String firstname) {
	 driver.findElement(By.id("customer.firstName")).sendKeys("firstname");
	}

	@And("Enters lastname {string} into the lastname field")
	public void enters_lastname_into_the_lastname_field(String lastname) {
		driver.findElement(By.id("customer.lastName")).sendKeys(lastname);
	}

	@And("Enters Address {string} into Address field")
	public void enters_address_into_address_field(String address) {
		driver.findElement(By.id("customer.address.street")).sendKeys(address);
		
	}
	
	@And("Enters city {string} into city field")
	public void enters_city_into_the_city_field(String city) {
		driver.findElement(By.id("customer.address.city")).sendKeys(city);
		
	}
	

	@And("Enters State {string} into the State field")
	public void enters_state_into_the_state_field(String state) {
		driver.findElement(By.id("customer.address.state")).sendKeys(state);
		
	}

	@And("Enters Zipcode {string} into the Zipcode field")
	public void enters_zipcode_into_the_zipcode_field(String zip) {
		driver.findElement(By.id("customer.address.zipCode")).sendKeys(zip);

	}

	@And("Enters phone number {string} into the Phone field")
	public void enters_phone_number_into_the_phone_field(String phone) {
		driver.findElement(By.id("customer.phoneNumber")).sendKeys(phone);

	}

	@When("Enters SSN {string} into the SSN field")
	public void enters_ssn_into_the_ssn_field(String ssn) {
		driver.findElement(By.id("customer.ssn")).sendKeys(ssn);

	}

	@And("Enters Username {string} into Username field")
	public void enters_username_into_username_field(String usern) {
		driver.findElement(By.id("customer.username")).sendKeys(usern);

	}

	@And("Enters Password {string} into Password field")
	public void enters_password_into_password_field(String pswd) {
		driver.findElement(By.id("customer.password")).sendKeys(pswd);
}

	@And("Enters Confirm {string} into Confirm field")
	public void enters_confirm_into_confirm_field(String conps) {
		driver.findElement(By.id("repeatedPassword")).sendKeys(conps);
 
	}
   
	@And ("Clicks on Register button")
	public void And_Clicks_on_Register_button() {
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		 
	}
	
	@Then("Account should get successfully created")
	public void account_should_get_successfully_created() {
	Assert.assertEquals("Your account was created successfully. You are now logged in.", driver.findElement(By.xpath("//div[@id=\'rightPanel\']/p")).getText());
	}

	@When("User dont enter details into any fields")
	public void user_dont_enter_details_into_any_fields() {
   //	intentionally kept blank
	}


	@Then("Warning messages should be displayed for all the fields")
	public void warning_messages_should_be_displayed_for_all_the_fields() {
	Assert.assertEquals("First name is required.",driver.findElement(By.xpath("//*[@id=\"customer.firstName.errors\"]")).getText());
	Assert.assertEquals("Last name is required.",driver.findElement(By.xpath("//*[@id=\"customer.lastName.errors\"]")).getText());
	Assert.assertEquals("Address is required.",driver.findElement(By.xpath("//*[@id=\"customer.address.street.errors\"]")).getText());
	Assert.assertEquals("City is required.",driver.findElement(By.xpath("//*[@id=\"customer.address.city.errors\"]")).getText());
	Assert.assertEquals("State is required.",driver.findElement(By.xpath("//*[@id=\"customer.address.state.errors\"]")).getText());
	Assert.assertEquals("Zip Code is required.",driver.findElement(By.xpath("//*[@id=\"customer.address.zipCode.errors\"]")).getText());
	Assert.assertEquals("Social Security Number is required.",driver.findElement(By.xpath("//*[@id=\"customer.ssn.errors\"]")).getText());
	Assert.assertEquals("Username is required.",driver.findElement(By.xpath("//*[@id=\"customer.username.errors\"]")).getText());
	Assert.assertEquals("Password is required.",driver.findElement(By.xpath("//*[@id=\"customer.password.errors\"]")).getText());
	Assert.assertEquals("Password confirmation is required.",driver.findElement(By.xpath("//*[@id=\"repeatedPassword.errors\"]")).getText());

	}

	@Then("warning message should be displayed")
	public void warning_message_should_be_displayed() {
	Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"customer.username.errors\"]")).getText().contains("This username already exists."));
		
	}



}
