package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(       
        plugin = {
            "pretty",
            "html:target/cucumber-reports/login.html",
            "json:target/cucumber-reports/login.json",
            "com.epam.reportportal.cucumber.ScenarioReporter",
            "reportportal.CustomizeStepFailedListener"           
        },
        monochrome = true
)
public class BaseRunner extends AbstractTestNGCucumberTests {
   
}
