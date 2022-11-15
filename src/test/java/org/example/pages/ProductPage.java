package org.example.pages;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.example.base.BaseMethods;
import org.example.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class ProductPage extends BaseTest {
    BaseMethods baseMethods = new BaseMethods();


    public static void isAppOpen(String text){
        String element = appiumDriver.findElement(By.id("com.m.qr:id/rvmp_home_inspiration_title")).getText();
        Assert.assertTrue("travel inspiration yazisi gorundu",element.equals(text));
    }

    public void clickToSkip() throws InterruptedException {
        baseMethods.clickElementById("com.m.qr:id/skip_button");
        baseMethods.waitBySecond(8);
        baseMethods.clickElementById("com.m.qr:id/onboarding_skip_button");
        baseMethods.waitBySecond(8);
        baseMethods.clickElementById("com.m.qr:id/push_consent_decline");
    }

    public void controlElement(By by,String text){
        MobileElement element = appiumDriver.findElement(by);
        System.out.println("Alınan elementın text değeri " + element.getText());
        Assert.assertTrue("Verilen text değeri ile alınan text değeri eşit değil",element.getText().equals(text));
    }

    public void chooseRandomElement(By by){
        List<MobileElement> elements = appiumDriver.findElements(by);
        System.out.println("Total elements : " + elements.size());
        Random rand = new Random();
        int index = rand.nextInt(elements.size()-1);
        System.out.println("index= " + index);
        elements.get(index).click();
    }

    public void selectEconomyClass() throws InterruptedException {
        baseMethods.clickElementById("com.m.qr:id/fragment_rtow_flight_cabin_class_text_view");
        baseMethods.waitBySecond(3);
        baseMethods.clickElementByXpath("(//android.widget.RadioButton[@resource-id='com.m.qr:id/cabin_selection_row_radio_button'])[1]");
    }

    public void controlFlyDetails() {
        controlElement(By.id("com.m.qr:id/to_time"),"15:50");
    }




}
