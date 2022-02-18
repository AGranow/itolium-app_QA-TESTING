package com.itolium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OpenHomePageTest{

    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wd.manage().window().maximize();
        wd.navigate().to("https://itolium-app-1337.web.app/");
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        wd.quit();
    }

    @Test
    public void HomePageTest() {
        String text = wd.findElement(By.xpath("//h1[contains(text(),'Home')]")).getText();
        Assert.assertEquals(text, "Home");
    }




}
