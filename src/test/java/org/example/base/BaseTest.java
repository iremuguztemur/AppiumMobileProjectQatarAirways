package org.example.base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected static AppiumDriver<MobileElement> appiumDriver;

    @BeforeScenario
    public void setUp() throws MalformedURLException {

        if (Constants.IS_LOCAL_ANDROID) {

            System.out.println("Android testi basladi..");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Constants.DEVICE_NAME);
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, Constants.START_APP_ACTIVITY);
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Constants.APP_PACKAGE);
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, Constants.NEW_COMMAND_TIMEOUT);

            URL url = new URL(Constants.URL);
            appiumDriver = new AndroidDriver<>(url, desiredCapabilities);

        } else {
            System.out.println("IOS testi basladi");
        }
    }

    @AfterScenario
    public void tearDown() {
        if (appiumDriver != null) {
            appiumDriver.quit();
            System.out.println("Test bitti..");
        }
    }

}
