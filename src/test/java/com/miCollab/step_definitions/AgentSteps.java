package com.miCollab.step_definitions;

import com.miCollab.utilities.CommonSteps;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.time.Duration;
import java.time.LocalTime;

public class AgentSteps extends CommonSteps {

    @Then("the user should wait {int} minutes and accept all incoming calls")
    public void the_user_should_wait_minutes_and_accept_all_incoming_calls(Integer testDuration) {
        LocalTime startTime = LocalTime.now();
        LocalTime finalTime = startTime.plus(Duration.ofMinutes(testDuration));
        int numberOfCalls = 0;
//        dashboardPage.clickOnLeftMenuOption("Settings");
//        dashboardPage.changeSettingsOf("Manage Hotkeys");
//                    Actions actions = new Actions(driver);
//            actions.click(dashboardPage.getHotkey("Accept Call")).perform();
//        clickWithJS(dashboardPage.getHotkey("Accept Call"));
//        waitFor(2);


        while (Duration.between(finalTime, LocalTime.now()).getSeconds() < 0) {
//            WebDriverWait wait = new WebDriverWait(driver, testDuration * 60);
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@data-vn='inboundCall']//div[starts-with(@class,'cust-button-content')])[2]")));
            if (dashboardPage.isIncomingCallAvailable()) {
                waitFor(2);
                dashboardPage.acceptCallButton.click();
                waitFor(5);
                if (dashboardPage.isEndCallButtonAvailable()) {
                    waitFor(2);
                    try {
                        driver.findElements(By.xpath("//div[@class='flex-btn incall-end-btn tappable']")).get(0).click();
                    } catch (org.openqa.selenium.StaleElementReferenceException ex) {
                        driver.findElements(By.xpath("//div[@class='flex-btn incall-end-btn tappable']")).get(0).click();
                    }

                }
            }


        }


    }
}
