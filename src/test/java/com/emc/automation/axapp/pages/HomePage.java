package com.emc.automation.axapp.pages;

import static com.emc.automation.web.by.ProtractorBy.repeater;
import static com.emc.automation.web.pages.Operations.waitForAngular;
import static org.openqa.selenium.By.cssSelector;

import com.emc.automation.web.components.Link;
import com.emc.automation.web.components.RepeaterTable;
import com.emc.automation.web.pages.AbstractPage;

public class HomePage extends AbstractPage {

    private RepeaterTable navTable = new RepeaterTable(cssSelector("#leftPanel"), repeater("app in applications"));

    @Override
    public void waitForReady() {
        waitForAngular();
    }

    public void navigateTo(String appName) {
        new Link(navTable.getBy("app.name", appName)).click();
    }

}
