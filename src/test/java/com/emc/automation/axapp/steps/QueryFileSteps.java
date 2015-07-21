package com.emc.automation.axapp.steps;

import static com.emc.automation.web.pages.PageFactory.getPage;

import org.jbehave.core.annotations.When;

import com.emc.automation.axapp.pages.ImageAppPage;
import com.emc.automation.axapp.pages.QueryFilePage;

public class QueryFileSteps {

    @When("query with metadata $number,$description")
    public void query(String number, String description) {
        getPage(ImageAppPage.class).openNewQueryDialog();
        getPage(QueryFilePage.class).query(number, description);
    }

    @When("view by index $index")
    public void view(int index) {
        getPage(QueryFilePage.class).view(index);
    }

}
