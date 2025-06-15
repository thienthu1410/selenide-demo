package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/login.feature",
        glue = {
            "util",
            "stepdefs.login"
        },
        tags = "@login and not @excluded"        
)
public class LoginRunner extends BaseRunner {
   
}
