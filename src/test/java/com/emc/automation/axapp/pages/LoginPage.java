package com.emc.automation.axapp.pages;

import static org.openqa.selenium.By.cssSelector;

import com.emc.automation.web.components.Button;
import com.emc.automation.web.components.TextField;
import com.emc.automation.web.pages.AbstractPage;

public class LoginPage extends AbstractPage {

    private TextField usernameText = new TextField(cssSelector("#User"));
    private TextField passwordText = new TextField(cssSelector("#Password"));
    private Button submitButton = new Button(cssSelector("[type='submit']"));

    @Override
    public void waitForReady() {
    }

    public void login(String username, String password) {
        usernameText.setValue(username);
        passwordText.setValue(password);
        submitButton.click();
    }

}
