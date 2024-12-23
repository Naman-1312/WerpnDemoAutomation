package StepDefination;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//@CucumberOptions(features="src/test/resources/Feature/PhysicianRegistration.feature",glue= {"StepDefination"},
@CucumberOptions(features="src/test/resources/Feature/Login.feature",glue= {"StepDefination"},
monochrome = true,
/*plugin = { "pretty", "junit:target/JUnitReports/report.xml",
		"json:target/JSONReports/report.json",
		"html:target/HtmlReports.html"} */
	plugin = {"html:target/TestResult/ProfileUpdateTestCases.html"}	
//	tags = "@SanityTest10"
		)
public class TestRunner {

}