package stepdefs.google;

import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class GoogleStepDefs {

    @Given("I navigate to the Google homepage")
    public void iNavigateToTheGoogleHomepage() {
        open("https://www.google.com");
    }
}