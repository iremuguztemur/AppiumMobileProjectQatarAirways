package org.example.base;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class BaseMethods extends BaseTest {

    @Step("<xpath> xpath'li elemente tıkla")
    public void clickElementByXpath(String xpath) {
        MobileElement element = appiumDriver.findElement(By.xpath(xpath));
        element.click();
        //todo log4j ile logla
        System.out.println(element + "elemente tıklandı");
    }

    @Step("<id> id'li elemente tıkla")
    public void clickElementById(String id) {
        MobileElement element = appiumDriver.findElement(By.id(id));
        element.click();
        //todo log4j
        System.out.println(element + "elemente tıklandı");
    }

    @Step("<id> li elementi bul ve <key> değerini yaz")
    public void sendKeyElementById(String id, String key) throws InterruptedException {
        MobileElement element = appiumDriver.findElement(By.id(id));
        waitBySecond(3);
        element.sendKeys(key);

        //todo log4j
        System.out.println(element + "elemente tıklandı");
    }

    @Step("<xpath> li elementi bul ve <key> değerini yaz")
    public void sendKeyElementByXpath(String xpath, String key) throws InterruptedException {
        MobileElement element = appiumDriver.findElement(By.xpath(xpath));
        waitBySecond(3);
        element.sendKeys(key);

        //todo log4j
        System.out.println(element + "elemente tıklandı");
    }

    @Step("<second> saniye kadar bekle")
    public void waitBySecond(int i) throws InterruptedException {
        Thread.sleep(1000 * i);
    }

    public boolean isElementDisplayed(String id){
        return appiumDriver.findElement(By.id(id)).isDisplayed();
    }
}
