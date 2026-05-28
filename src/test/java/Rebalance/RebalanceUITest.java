package Rebalance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

import org.testng.annotations.Test;
/*
 * Selenium UI automation test
 * using TestNG
 */

public class RebalanceUITest {

    WebDriver driver;

    /*
     * Launch browser before test
     */
    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://localhost:8080");  /// Application URL
    }

    /*
     * Verify rebalance calculation
     */
    @Test
    public void testRebalanceCalculation() {

        /*
         * Enter target percentage
         */
        driver.findElement(By.id("target"))
                .sendKeys("20");

        /*
         * Enter current percentage
         */
        driver.findElement(By.id("current"))
                .sendKeys("10");

        /*
         * Enter stock price
         */
        driver.findElement(By.id("price"))
                .sendKeys("150");

        /*
         * Click calculate button
         */
        driver.findElement(By.id("calculate"))
                .click();

        /*
         * Capture result text
         */
        String result =
                driver.findElement(By.id("result"))
                        .getText();

        /*
         * Validate expected output
         */
        Assert.assertEquals(
                result,
                "BUY 67 shares");
    }

    /*
     * Close browser after test
     */
    @AfterMethod
    public void tearDown() {

        if (driver != null) {

            driver.quit();
        }
    }
}