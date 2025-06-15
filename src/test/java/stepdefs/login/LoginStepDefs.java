package stepdefs.login;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class LoginStepDefs {
    
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        open("/customer/account/login");
    }
    
    @When("I enter username {string} and password {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
        $("#user-name").setValue(username);
        $("#password").setValue(password);
    }
    
    @And("I click on login button")
    public void iClickOnLoginButton() {
        $("#login-button").click();
    }
    
    @Then("I should be redirected to the dashboard")
    public void iShouldBeRedirectedToTheDashboard() {
        $(".title").shouldHave(Condition.text("Products"));
    }
    
    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String expectedMessage) {
        String actualMessage = $("[data-test='error']").getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage), 
                "Expected error message: " + expectedMessage + " but was: " + actualMessage);
    }
}
