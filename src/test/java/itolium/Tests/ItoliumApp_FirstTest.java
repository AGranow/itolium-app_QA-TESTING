package itolium.Tests;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class ItoliumApp_FirstTest {

    EventFiringWebDriver chromeDriver;
    EdgeDriver edgeDriver;
    FirefoxDriver firefoxDriver;

    String basicUrl = "https://itolium-app-1337.web.app/";

    Logger logger = LoggerFactory.getLogger(ItoliumApp_FirstTest.class);

    @BeforeMethod
    public void startTest() {
        logger.info("Start test");
    }

    @BeforeTest
    public void SetUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        //  System.setProperty("webdriver.chrome.driver", ".idea/chromedriver.exe");

        chromeDriver = new EventFiringWebDriver(new ChromeDriver(chromeOptions));
        chromeDriver.navigate().to(basicUrl);
        chromeDriver.register(new MyListener());
        chromeDriver.manage().window().maximize();


        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--headless");
        edgeDriver = new EdgeDriver(edgeOptions);
        edgeDriver.navigate().to(basicUrl);
        edgeDriver.manage().window().maximize();


        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless");
        firefoxDriver = new FirefoxDriver(firefoxOptions);
        firefoxDriver.navigate().to(basicUrl);
        firefoxDriver.manage().window().maximize();
    }


    @Test
    public void firsTestChromeDriver() {
        String text = chromeDriver.findElement(By.className("App-header")).getText();
        Assert.assertEquals(text, "Hello from Maks");
        Assert.assertTrue(chromeDriver.findElement(By.className("App-header")).isDisplayed());
    }

    @Test
    public void firsTestEdge()  {
        String text = edgeDriver.findElement(By.className("App-header")).getText();
        Assert.assertEquals(text, "Hello from Maks");
        Assert.assertTrue(edgeDriver.findElement(By.className("App-header")).isDisplayed());
    }

    @Test
    public void firsTestFirefoxDriver() {
        String text = firefoxDriver.findElement(By.className("App-header")).getText();
        Assert.assertEquals(text, "Hello from Maks");
        Assert.assertTrue(firefoxDriver.findElement(By.className("App-header")).isDisplayed());
    }


    public String takeScreenshot() {
        File tmp = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshot" + System.currentTimeMillis() + ".png");

        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot.getAbsolutePath();
    }

    @AfterTest(enabled = true)
    public void tearDown() {
        edgeDriver.quit();
        chromeDriver.quit();
        firefoxDriver.quit();
    }

    @AfterMethod(alwaysRun = true)
    public void stopMetod(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("Test Passt!!!");
        } else {
            logger.info("Test FAILED!!!" + "\n"
                    + "Screenshot" + takeScreenshot());
            logger.info("Stop Test");
        }
    }
}

