package com.itolium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @Test
    public void openPageTest() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("home-title")));
    }

    @Test
    public void buttonKarriereTest() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/karriere']"))).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Karriere Page')]")));
        wd.navigate().back();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("home-title")));
    }

    @Test
    public void buttonKontaktTest() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/kontakt']"))).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Kontakt')]")));
    }

    @Test
    public void buttonDatenschutzTest() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/datenschutz']"))).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("datenschutz-headline")));
    }

    @Test
    public void buttonImpressumTest() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/impressum']"))).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("impressum-headline")));
    }
}
