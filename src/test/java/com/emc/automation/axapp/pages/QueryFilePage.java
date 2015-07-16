package com.emc.automation.axapp.pages;

import static com.emc.automation.web.by.ProtractorBy.model;
import static com.emc.automation.web.by.ProtractorBy.repeater;
import static com.emc.automation.web.pages.Operations.waitForAngular;
import static org.openqa.selenium.By.cssSelector;

import com.emc.automation.web.components.Button;
import com.emc.automation.web.components.RepeaterTable;
import com.emc.automation.web.components.TextField;
import com.emc.automation.web.pages.AbstractPage;

public class QueryFilePage extends AbstractPage {

    // query table
    private RepeaterTable queryTable = new RepeaterTable(cssSelector("#queryView"), repeater("queryIndex in query.indexes"));
    private Button runButton = new Button(cssSelector("[ng-click='executeQuery();']"));

    // result table
    private RepeaterTable resultTable = new RepeaterTable(cssSelector("#queryResultGrid"), repeater("item in entries"));

    @Override
    public void waitForReady() {
        waitForAngular();
    }

    public void query(String number, String description) {
        new TextField(queryTable.getBy(0, model("queryIndex.value"))).setValue(number);
        new TextField(queryTable.getBy(1, model("queryIndex.value"))).setValue(description);
        runButton.click();
    }

    public void view(int index) {
        new Button(resultTable.getBy(index, cssSelector("[ng-click='openDocument(item)']"))).click();
    }

}
