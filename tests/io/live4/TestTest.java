package io.live4;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class TestTest {
	
	private ChromeDriver driver;
	private WebDriverWait pause;
	private String url = "http://live4.io/";
	
	@Before
	public void SetUp(){
		driver = new ChromeDriver();
		pause = new WebDriverWait(driver, 2000);
		
	}
	
//	@After
//	public void tearDown(){
//		driver.close();
//		driver.quit();
//	}
	
	@Test
	public void testGooglePlayButton() throws InterruptedException{
		driver.get(url);
		WebElement googlePlayButton = pause.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bottompart .app__googleplay")));
		
		googlePlayButton.click();

		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		
		Thread.sleep(2000);
		
		String titleGP = driver.getTitle();
		System.out.println(titleGP);
		
		Assert.assertTrue("Failure: link is ok", titleGP.contentEquals("LIVE4 GoPro - Android Apps on Google Play"));
	}

	}

