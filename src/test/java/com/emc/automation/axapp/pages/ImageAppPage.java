package com.emc.automation.axapp.pages;

import static com.emc.automation.web.pages.Operations.waitForAngular;
import static org.openqa.selenium.By.cssSelector;

import com.emc.automation.web.components.Button;
import com.emc.automation.web.pages.AbstractPage;

public class ImageAppPage extends AbstractPage {

    private Button batchButton = new Button(cssSelector(".wx-icon-C1_BatchDropdownMain"));
    private Button uploadDocumentButton = new Button(cssSelector(".wx-icon-C2_UploadNewDoc"));

    @Override
    public void waitForReady() {
        waitForAngular();
    }

    public void openUploadDocumentDialog() {
        batchButton.click();
        uploadDocumentButton.click();
    }

}
