package com.emc.automation.axapp.pages;

import static com.emc.automation.web.by.ProtractorBy.model;
import static com.emc.automation.web.by.ProtractorBy.repeater;
import static com.emc.automation.web.pages.Operations.waitForAngular;
import static org.junit.Assert.assertNotNull;
import static org.openqa.selenium.By.cssSelector;

import org.openqa.selenium.WebElement;

import com.emc.automation.web.components.Button;
import com.emc.automation.web.components.RepeaterTable;
import com.emc.automation.web.components.Select;
import com.emc.automation.web.components.TextField;
import com.emc.automation.web.components.Value;
import com.emc.automation.web.pages.AbstractPage;

public class FileEditorPage extends AbstractPage {

    private RepeaterTable indexValueTable = new RepeaterTable(cssSelector("#indexView"),
            repeater("axDocIndexValue in indexes.currentIndex.indexValues"));

    private Button saveIndexButton = new Button(cssSelector("[ng-click='saveIndexClicked()']"));

    private Value svgDiv = new Value(cssSelector("#svgdiv"));

    @Override
    public void waitForReady() {
        waitForAngular();
    }

    public void enterMetadata(String number, String description, String date, String type) {
        new TextField(indexValueTable.getBy(0, model("axDocIndexValue.nativeValue"))).setValue(number);
        new TextField(indexValueTable.getBy(1, model("axDocIndexValue.value"))).setValue(description);
        new TextField(indexValueTable.getBy(2, model("axDocIndexValue.value"))).setValue(date);
        new Select(indexValueTable.getBy(3, model("axDocIndexValue.value"))).selectDisplayValue(type);
        saveIndexButton.click();
    }

    public void enterBasicMetadata(String number, String description) {
        new TextField(indexValueTable.getBy(0, model("axDocIndexValue.nativeValue"))).setValue(number);
        new TextField(indexValueTable.getBy(1, model("axDocIndexValue.value"))).setValue(description);
        saveIndexButton.click();
    }

    public void verifyFile(String type) {
        switch (type) {
            case "txt":
                verifySvg("svg g text");
                break;
            case "bmp":
            case "gif":
            case "jpg":
            case "png":
                verifySvg("svg g image");
                break;
            default:
                throw new IllegalArgumentException("type [" + type + "] is not supported");
        }
    }

    private void verifySvg(String svgPath) {
        WebElement svg = svgDiv.findElement(cssSelector(svgPath));
        assertNotNull("no svg elements found for path: " + svgPath, svg);
    }

}
