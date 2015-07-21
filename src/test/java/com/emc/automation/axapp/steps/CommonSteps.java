package com.emc.automation.axapp.steps;

import static com.emc.automation.web.drivers.DefaultDriverProvider.getWebDriver;
import static com.emc.automation.web.pages.PageFactory.getPage;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.emc.automation.axapp.pages.CommonPage;
import com.emc.automation.axapp.pages.HomePage;
import com.emc.automation.axapp.pages.LoginPage;
import com.emc.automation.web.config.PropertyConfig;
import com.emc.automation.web.pages.Operations;

public class CommonSteps {

    @Given("default login to ax-app")
    public void defaultLogin() {
        String url = PropertyConfig.get("webapp.url", "http://localhost/");
        String username = PropertyConfig.get("webapp.username", "username");
        String password = PropertyConfig.get("webapp.password", "password");

        getWebDriver().get(url);
        getPage(LoginPage.class).login(username, password);
    }

    @When("logout from ax-app")
    public void logout() {
        getPage(CommonPage.class).logout();
    }

    @When("navigate to $appName")
    public void navigateTo(String appName) {
        getPage(HomePage.class).navigateTo(appName);
    }

    @When("wait for $seconds")
    public void waitFor(int seconds) {
        Operations.waitFor(seconds);
    }

    @Then("force taking screenshot")
    public void takeScreenshot() {
        waitFor(10);
        throw new RuntimeException("force taking screenshot");
    }

}
