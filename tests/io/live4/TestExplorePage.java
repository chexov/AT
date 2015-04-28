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

public class TestExplorePage {
	
	private SafariDriver driver;
	private WebDriverWait pause;

	
	//test link to AppStore
	//test link to Google Play
	//test Latest
	//test Recommended
	//test 'Link to this video'
	//test playback
	//test Map appearance
	//test Link to youtube event
	//test Play Again
	//test link to AppStore from player
	//test link to Google play from player
	//test Show more Lives button
	
	@Before
	public void SetUp(){
		driver = new SafariDriver();
		pause = new WebDriverWait(driver, 500);
	}

	@After
	public void tearDown(){
		driver.close();
		driver.quit();
	}
	
	@Test
	//test link to the main page
	public void testLinkToMain() throws InterruptedException{
		driver.get("http://live4.io/stream");
		WebElement label = pause.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("svg")));
		label.click();
		WebElement liveLive = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("mainpage")));
		String checkLiveLive = liveLive.getText();

		Assert.assertTrue("FAILED: link to the main page is ok", checkLiveLive.equals("Live LIVE"));
	}
	
	@Test
	//test Map link
	public void testMapMenuLink(){
		driver.get("http://live4.io/stream");
		WebElement mapLink = driver.findElement(By.linkText("Map"));
		mapLink.click();
		WebElement map = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("gm-style")));
		
		Assert.assertTrue("FAILED: 'Map' link is ok", map.isDisplayed());
	}
	
	@Test
	//test Quick Start link
	public void testSrartMenuLink(){
		driver.get("http://live4.io/stream");
		WebElement quickStartLink = driver.findElement(By.linkText("Quick Start"));
		quickStartLink.click();
		WebElement fiveSteps = pause.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
		
		Assert.assertTrue("FAILED: 'Quick start' link is ok", fiveSteps.getText().equals("5 steps to start streaming LIVE"));
	}
	
}
