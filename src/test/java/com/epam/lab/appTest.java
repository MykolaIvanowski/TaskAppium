package com.epam.lab;

import com.epam.lab.bo.CreationUserApp;
import com.epam.lab.info.UserInfo;
import com.epam.lab.model.User;
import com.epam.lab.utils.Driver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class appTest {
    private CreationUserApp app;
    private AndroidDriver driver;

    @BeforeClass
    public void start(){
            app = new CreationUserApp();
            driver = Driver.getDriver();
    }

    @AfterClass
    public void finish(){
        driver.quit();
    }

    @Test
    public void applicationTest(){
        User user = new User();
        user.setEmail(UserInfo.MAIL);
        user.setName(UserInfo.NAME);
        user.setPassword(UserInfo.PASSWORD);

        app.pressButtonCreate();
        app.setUserTextAria(user);

        Assert.assertTrue(app.checkUserCreate());
    }
}
