package com.emc.automation.axapp.pages;

import static com.emc.automation.web.pages.Operations.waitForAngular;
import static org.openqa.selenium.By.cssSelector;

import com.emc.automation.web.components.Link;
import com.emc.automation.web.pages.AbstractPage;

public class CommonPage extends AbstractPage {

    private Link logoutLink = new Link(cssSelector("[ng-click='logout()']"));

    @Override
    public void waitForReady() {
        waitForAngular();
    }

    public void logout() {
        logoutLink.click();
    }

}
