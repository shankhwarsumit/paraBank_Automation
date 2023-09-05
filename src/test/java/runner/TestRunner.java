package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions (
		features={"src/test/resource/features/Register.feature",
				"src/test/resource/features/Login.feature"},
		glue={"stepDefinitions","Hooks"},
		plugin= {"pretty",
				"html:target/CucumberReports/cumberReportCucumberReport.html"}
		)

public class TestRunner extends AbstractTestNGCucumberTests {

	
}
