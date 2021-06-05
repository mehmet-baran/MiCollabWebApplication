package com.miCollab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage extends CommonPageElements {
    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[.='Skip'])[2]")
    public WebElement skipButton;

    @FindBy(xpath = "(//div[@data-vn='inboundCall']//div[starts-with(@class,'cust-button-content')])[2]")
    public WebElement acceptCallButton;

    @FindBy(xpath = "//div[@class='flex-btn incall-end-btn tappable']")
    public WebElement endCallButton;

    public boolean isIncomingCallAvailable() {
        List<WebElement> incomingCallList = driver.findElements(By.xpath("(//div[@data-vn='inboundCall']//div[starts-with(@class,'cust-button-content')])[2]"));
        if (incomingCallList.size() == 0) {
            System.out.println("No incoming calls");
            return false;
        } else {
            System.out.println("There is an incoming call");
            return true;
        }
    }

    public boolean isEndCallButtonAvailable() {
        List<WebElement> endCallList = driver.findElements(By.xpath("//div[@class='flex-btn incall-end-btn tappable']"));
        if (endCallList.size() == 0) {
            return false;
        } else return true;
    }

}
