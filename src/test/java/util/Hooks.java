package util;


import static com.codeborne.selenide.Selenide.*;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.chrome.ChromeOptions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.epam.reportportal.service.ReportPortal;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        Configuration.browserSize = "1920x1080";
        Configuration.browserCapabilities = options;
    }

    // @AfterStep
    // public void afterEachStep(Scenario scenario) {
    //     if (scenario.isFailed()) {
    //         File screenshot = Screenshots.getLastScreenshot();
    //         if (screenshot != null && screenshot.exists()) {
    //             ReportPortal.emitLog(
    //                 "",
    //                 "ERROR",
    //                 new Date(),
    //                screenshot)
    //             ;
    //         }
    //     }
    // }

    @After(order = 1)
    public void afterScenario() {
        clearBrowserData();    
    }

    private void clearBrowserData() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        executeJavaScript("sessionStorage.clear();");
    }
  
}
