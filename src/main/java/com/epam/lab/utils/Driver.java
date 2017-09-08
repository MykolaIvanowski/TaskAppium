package com.epam.lab.utils;

import com.epam.lab.info.Info;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    public static AndroidDriver driver;
    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    static {
        File directory = new File(Info.TEST_APP_LOCATION);
        File app = new File(directory, Info.APP_NAME);

        capabilities.setCapability(CapabilityType.BROWSER_NAME, "chome");
        capabilities.setCapability("device","Android");

        capabilities.setCapability("appPackage", "io.selendroid.testapp");
        capabilities.setCapability("appActivity", ".HomeScreenActivity");

        capabilities.setCapability("deviceName", Info.DEVICE_NAME);
        capabilities.setCapability("platformName", Info.PLATFORM_NAME);
        capabilities.setCapability("platformVersion", Info.PLATFORM_VERSION);

        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("noReset",true);

    }
    private Driver(){}

    public static AndroidDriver getDriver() {
        if(driver == null){
            try {
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                        capabilities);
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

            }catch (MalformedURLException ex){
                ex.printStackTrace();
            }
        }
        return driver;
    }
}
