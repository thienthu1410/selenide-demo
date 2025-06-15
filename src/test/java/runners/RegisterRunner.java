package runners;

import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features/register.feature",
        glue = {
            "util",
            "stepdefs.register"
        },
        tags = "@register and not @excluded"       
)
public class RegisterRunner extends BaseRunner {

}
