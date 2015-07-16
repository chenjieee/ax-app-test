package com.emc.automation.axapp.pages;

import static com.emc.automation.web.pages.Operations.waitForAngular;
import static org.openqa.selenium.By.cssSelector;

import com.emc.automation.web.components.Button;
import com.emc.automation.web.components.TextField;
import com.emc.automation.web.pages.AbstractPage;

public class UploadFileDialog extends AbstractPage {

    private TextField fileText = new TextField(cssSelector("[file-model='batchCreateRequest.files']"));
    private Button uploadButton = new Button(cssSelector("[ng-click='ok();']"));

    @Override
    public void waitForReady() {
        waitForAngular();
    }

    public void uploadFile(String path) {
        fileText.sendKeys(path);
        uploadButton.click();
    }

}
