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
            "When enter metadata <number>,<description>", 
            "Then force taking screenshot" })
    public void compositeUploadFile(
            @Named("appName") String appName, 
            @Named("path") String path, 
            @Named("number") String number, 
            @Named("description") String description) {
    }

    @When("user query file by index $index in $appName with metadata $number and $description")
    @Composite(steps = { 
            "Given default login to ax-app", 
            "When navigate to <appName>", 
            "When query with metadata <number>,<description>",
            "When view by index <index>", 
            "Then force taking screenshot" })
    public void compositeUploadFile(
            @Named("appName") String appName, 
            @Named("index") int index, 
            @Named("number") String number, 
            @Named("description") String description) {
    }

}
