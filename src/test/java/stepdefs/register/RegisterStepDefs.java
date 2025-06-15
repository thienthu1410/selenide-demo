package stepdefs.register;

import static com.codeborne.selenide.Condition.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.*;


import static com.codeborne.selenide.Configuration.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;

@Test
public class RegisterStepDefs {
    
    @Given("I am on the register page")
    public void iAmOnTheRegisterPage() {
        System.out.println("WebDriverRunner.hasWebDriverStarted(): " + WebDriverRunner.hasWebDriverStarted());
        open("/customer/account/create/");
    }   
    
    @And("I enter first name {string}")
    public void iEnterFirstName(String firstName) {
        $("input#firstname").setValue(firstName);
    }
    
    @And("I enter last name {string}")
    public void iEnterLastName(String lastName) {
        $("input#lastname").setValue(lastName);
    }
    
    @And("I enter email {string}")
    public void iEnterEmail(String email) {
        $("input#email_address").setValue(email);
    }

    @And("I enter non-existing email")
    public void iEnterExistingEmail() {
        String email = "user_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSSS")) + "@example.com";
        iEnterEmail(email);
    }

    
    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        $("input#password").setValue(password);
    }
    
    @And("I confirm password {string}")
    public void iConfirmPassword(String password) {
        $("input#password-confirmation").setValue(password);
    }
    
    @And("I click on Create an Account button")
    public void iClickOnCreateAnAccountButton() {
        $("button.submit").shouldHave(exactTextCaseSensitive("Create an Account")).click();
    }
    
    @Then("I should see a success message 'Thank you for registering with Main Website Store.'")
    public void iShouldSeeASuccessMessage() {
        $("div.message-success").$x(".//div[normalize-space()='Thank you for registering with Main Website Store.']").shouldBe(visible);
    }
    
    @Then("I should be redirected to the login page")
    public void iShouldBeRedirectedToTheLoginPage() {
        $("h1.page-title").$x(".//span[normalize-space()='My Account']").shouldBe(visible);
    }
        
    
    @And("I should see an error message 'There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.'")
    public void iShouldSeeAnErrorMessage() {
        $(".message-error").$x(".//div[normalize-space()='There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.']").shouldBe(visible);
    }

    @Given("I am on the another page")
    public void I_am_on_the_another_page() {
        open("https://selenide.org/documentation.html");
    }

}
