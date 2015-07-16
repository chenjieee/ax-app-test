package com.emc.automation.axapp.steps;

import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;

public class CompositeSteps {

    @When("user upload file $path to $appName with metadata $number and $description")
    @Composite(steps = { 
            "Given default login to ax-app", 
            "When navigate to <appName>", 
            "When upload file <path>",
            "When enter basic metadata <number>,<description>", 
            "Then force taking screenshot" })
    public void compositeUploadFile(
            @Named("appName") String appName, 
            @Named("path") String path, 
            @Named("number") String number, 
            @Named("description") String description) {
    }

}
