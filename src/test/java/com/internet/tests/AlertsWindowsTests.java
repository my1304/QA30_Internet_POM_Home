package com.internet.tests;

import com.internet.pages.AlertsPage;
import com.internet.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsWindowsTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new SidePanel(driver).selectLink();
    }

    @Test
    public void alertjsAlert() {
        new AlertsPage(driver).clickForJsAlert();
    }

    @Test
    public void selectConfirmJsTest() {
        new AlertsPage(driver).clickForJsConfirm("Cancel").verifyResult("Cancel");
    }

    @Test
    public void sendMessageToAlertTest() {
        new AlertsPage(driver).sendMessageToAlert("Hello world!!").verifyMessage("Hello world!!");
    }
}

/*
Homework
Создайте, пожалуйста, тест-проект для сайта (https://the-internet.herokuapp.com/)
при помощи Maven с классами TestBase и BasePage и автоматизируйте тестирование
3 кнопок на странице(https://the-internet.herokuapp.com/javascript_alerts)*/
