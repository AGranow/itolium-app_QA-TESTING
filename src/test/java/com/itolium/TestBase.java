package com.itolium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {


    static WebDriver wd;
    static WebDriverWait webDriverWait;

    @BeforeMethod(enabled = true)
    public void setUp() throws InterruptedException {
        wd = new ChromeDriver();
        webDriverWait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wd.manage().window().maximize();
        wd.navigate().to("https://itolium-app-1337.web.app/");
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        wd.quit();
    }
}
