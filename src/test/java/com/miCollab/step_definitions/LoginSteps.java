package com.miCollab.step_definitions;

import com.miCollab.utilities.CommonSteps;
import com.miCollab.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonSteps {

    @Given("the user accepts the license agreement")
    public void the_user_accepts_the_license_agreement() throws InterruptedException {

        licensePage.acceptButton.click();

    }

    @When("the user logs in with {string} credentials")
    public void the_user_logs_in_with_credentials(String username) {
        loginPage.usernameTextbox.sendKeys(username);
        loginPage.passwordTextbox.sendKeys(ConfigurationReader.get("password"));
        loginPage.loginButton.click();
        waitFor(1);
        dashboardPage.skipButton.click();
        dashboardPage.clickOnButton("OK");
        waitFor(2);
    }

}
