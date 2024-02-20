package com.internet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[onclick='jsAlert()']")
    WebElement jsAlert;

    public void clickForJsAlert() {
        click(jsAlert);
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent())
                .accept();
    }

    @FindBy(css = "[onclick='jsConfirm()']")
    WebElement jsConfirm;

    public AlertsPage clickForJsConfirm(String key) {
        click(jsConfirm);
        if (key != null && key.equals("OK")) {
            driver.switchTo().alert().accept();
        } else if (key != null && key.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(id = "result")
    WebElement resultID;

    public AlertsPage verifyResult(String result) {
        Assert.assertTrue(resultID.getText().contains(result));
        return this;
    }

    @FindBy(css = "[onclick='jsPrompt()']")
    WebElement jsPrompt;

    public AlertsPage sendMessageToAlert(String message) {
        click(jsPrompt);
        if (message != null) {
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(id = "result")
    WebElement promptResult;

    public AlertsPage verifyMessage(String text) {
        Assert.assertTrue(promptResult.getText().contains(text));
        return this;
    }
}