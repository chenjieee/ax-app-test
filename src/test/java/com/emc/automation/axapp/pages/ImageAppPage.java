package com.emc.automation.axapp.pages;

import static com.emc.automation.web.pages.Operations.waitForAngular;
import static org.openqa.selenium.By.cssSelector;

import com.emc.automation.web.components.Button;
import com.emc.automation.web.pages.AbstractPage;

public class ImageAppPage extends AbstractPage {

    // drop down list: batch upload
    private Button batchDropDownButton = new Button(cssSelector(".wx-icon-C1_BatchDropdownMain"));
    private Button uploadDocumentButton = new Button(cssSelector(".wx-icon-C2_UploadNewDoc"));

    // drop down list: query search
    private Button queryDropDownButton = new Button(cssSelector(".wx-icon-C5_CreateDropdownMain"));
    private Button newQueryButton = new Button(cssSelector(".wx-icon-B2_NewQuery"));

    @Override
    public void waitForReady() {
        waitForAngular();
    }

    public void openUploadDocumentDialog() {
        batchDropDownButton.click();
        uploadDocumentButton.click();
    }

    public void openNewQueryDialog() {
        queryDropDownButton.click();
        newQueryButton.click();
    }

}
