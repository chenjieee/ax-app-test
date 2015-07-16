package com.emc.automation.axapp.steps;

import static com.emc.automation.web.pages.PageFactory.getPage;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.emc.automation.axapp.pages.FileEditorPage;
import com.emc.automation.axapp.pages.ImageAppPage;
import com.emc.automation.axapp.pages.UploadFileDialog;

public class UploadFileSteps {

    @When("upload file $path")
    public void uploadFile(String path) {
        getPage(ImageAppPage.class).openUploadDocumentDialog();
        getPage(UploadFileDialog.class).uploadFile(path);
    }

    @When("enter metadata $number,$description,$date,$type")
    public void enterMetadata(String number, String description, String date, String type) {
        getPage(FileEditorPage.class).enterMetadata(number, description, date, type);
    }

    @When("enter basic metadata $number,$description")
    public void enterMetadata(String number, String description) {
        getPage(FileEditorPage.class).enterBasicMetadata(number, description);
    }

    @Then("file of type $type is displayed")
    public void fileDisplayed(String type) {
        getPage(FileEditorPage.class).verifyFile(type);
    }

}
