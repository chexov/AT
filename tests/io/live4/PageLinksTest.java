package io.live4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLinksTest {

    private SafariDriver driver;
    private WebDriverWait pause;

    @Before
    public void setUp() throws Exception {
        driver = new SafariDriver();
        pause = new WebDriverWait(driver, 2000);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }

    @Test
    //test "Explore" menu button
    public void testExploreMenu() throws Exception {
        driver.get("http://live4.io/");
        WebElement exploreLink = driver.findElement(By.linkText("Explore"));
        exploreLink.click();
        WebElement player = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("poster")));

        Assert.assertTrue("FAILED: 'Explore' link is ok", player.isDisplayed());
    }
}