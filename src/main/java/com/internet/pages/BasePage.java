package com.internet.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import javax.swing.*;

public abstract class BasePage {

    WebDriver driver;
    JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    public void click(WebElement element) {
        element.click();
    }
    public void AlertMessage(String text) {
        JOptionPane.showMessageDialog(null,
                text, "Message", JOptionPane.CLOSED_OPTION);
    }
}