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


public class StartPageTest {
	private SafariDriver driver;
	private WebDriverWait pause;
	
	@Before
	public void SetUp(){
		driver = new SafariDriver();
		pause = new WebDriverWait(driver, 2000);
	}
	
	@After
	public void tearDown(){
		driver.close();
		driver.quit();
	}
	
	@Test
	//test 'Explore' menu button
	public void testExploreMenuLink() throws InterruptedException{
		driver.get("http://live4.io/");
        WebElement exploreLink = driver.findElement(By.linkText("Explore"));
        Thread.sleep(2000);
        exploreLink.click();
        WebElement player = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("poster")));
      
        Assert.assertTrue("FAILED: 'Explore' link is ok", player.isDisplayed());
	}
	
	@Test
	//test 'Map' menu button
	public void testMapMenuLink(){
		driver.get("http://live4.io/");
		WebElement mapLink = driver.findElement(By.linkText("Map"));
		mapLink.click();
		WebElement map = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("gm-style")));
		
		Assert.assertTrue("FAILED: 'Map' link is ok", map.isDisplayed());
	}
	
	@Test
	//test 'Quick Start' menu button
	public void testSrartMenuLink(){
		driver.get("http://live4.io/");
		WebElement quickStartLink = driver.findElement(By.linkText("Quick Start"));
		quickStartLink.click();
		WebElement fiveSteps = pause.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
		fiveSteps.getText();
		
		Assert.assertTrue("FAILED: 'Quick start' link is ok", fiveSteps.getText().equals("5 steps to start streaming LIVE"));
	}
	
	@Test
	//test "Explore LIVE4" button
	public void testExploreLive4Button(){
		driver.get("http://live4.io/");		
		WebElement bigRedButton = driver.findElement(By.className("lives__more"));
		bigRedButton.click();
		WebElement player = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("poster")));
		
		Assert.assertTrue("FAILED: 'Explore LIVE4' button is ok", player.isDisplayed());
	}
	
	@Test
	//test link to GooglePlay
	public void testLinkToGP(){
		driver.get("http://live4.io/");
		WebElement googlePlayButton = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("app__googleplay")));
		googlePlayButton.click();
		String titleGP = driver.getTitle();
		System.out.println(titleGP);
		
		Assert.assertTrue("FAILED: link to GooglePlay is ok", titleGP.contentEquals("LIVE4 GoPro - Android Apps on Google Play"));
	}
	
	@Test
	//test link to AppStore
	public void testLinkToAS() throws InterruptedException{
		driver.get("http://live4.io/");
		WebElement googlePlayButton = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("app__appstore")));
		googlePlayButton.click();
		String titleAS = driver.getTitle();
		System.out.println(titleAS);
		
		Assert.assertTrue("FAILED: link to AppStore is ok", titleAS.contentEquals("LIVE4 GoPro Ñ Live LIVE on the App Store on iTunes"));
	}
}
