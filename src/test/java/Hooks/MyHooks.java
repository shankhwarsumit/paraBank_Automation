package Hooks;
import factory.DriverFactory;
import io.cucumber.java.After;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import io.cucumber.java.Before;
import io.cucumber.java.AfterStep;


public class MyHooks {
	WebDriver driver;
	

	@Before
	public void setup() {
		DriverFactory.initializeBrowser("chrome");
		driver = DriverFactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	    driver.get("https://parabank.parasoft.com/parabank/index.htm");
	}
  
	
	@AfterStep
	public void set() {
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	
	@After
	public void tearDown() {
	driver.quit();
	}
	
	
}
