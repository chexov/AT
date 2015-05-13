package io.live4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.sun.jna.platform.FileUtils;
import org.apache.commons.io.FileUtils;


public class StartPageTest {
	private ChromeDriver driver;
	private WebDriverWait pause;
	private String url = "http://live4.io/";
	
	@Before
	public void SetUp(){
		driver = new ChromeDriver();
		pause = new WebDriverWait(driver, 2000);
	}
	
	@After
	public void tearDown(){
		driver.close();
		driver.quit();
	}
	
	@Rule public TestName name = new TestName();
	
	@Test
	//test 'Explore' menu button
	public void testExploreMenuLink() throws InterruptedException, IOException{
		
		System.out.println(name.getMethodName());
		
		driver.get(url);
        WebElement exploreLink = driver.findElement(By.linkText("Explore"));
        Thread.sleep(2000);
        exploreLink.click();
        WebElement player = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("poster")));
        
        File sShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sShot, new File("/tmp/clickExploreMenuButton.png"));
      
        Assert.assertTrue("FAILED: 'Explore' link is ok", player.isDisplayed());
	}
	
	@Test
	//test 'Map' menu button
	public void testMapMenuLink() throws IOException{
		
		System.out.println(name.getMethodName());
		
		driver.get(url);
		WebElement mapLink = driver.findElement(By.linkText("Map"));
		mapLink.click();
		WebElement map = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("gm-style")));
		
        File sShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sShot, new File("/tmp/clickMapMenuButton.png"));
		
		Assert.assertTrue("FAILED: 'Map' link is ok", map.isDisplayed());
	}
	
	@Test
	//test 'Quick Start' menu button
	public void testSrartMenuLink() throws IOException{
		
		System.out.println(name.getMethodName());
		
		driver.get(url);
		WebElement quickStartLink = driver.findElement(By.linkText("Quick Start"));
		quickStartLink.click();
		WebElement fiveSteps = pause.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
		fiveSteps.getText();
		
        File sShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sShot, new File("/tmp/clickQSMenuButton.png"));
		
		Assert.assertTrue("FAILED: 'Quick start' link is ok", fiveSteps.getText().equals("5 steps to start streaming LIVE"));
	}
	
	@Test
	//test "Explore LIVE4" button
	public void testExploreLive4Button() throws IOException{
		
		System.out.println(name.getMethodName());
		
		driver.get(url);		
		WebElement bigRedButton = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("lives__more")));
		bigRedButton.click();
		WebElement player = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("poster")));
		
        File sShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sShot, new File("/tmp/clickExploreLIVE4Button.png"));
		
		Assert.assertTrue("FAILED: 'Explore LIVE4' button is ok", player.isDisplayed());
	}
	
	@Test
	//test AppStore button
	public void testAppStoreButton() throws InterruptedException, IOException{
		driver.get(url);
		WebElement appStoreButton = pause.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bottompart .app__appstore")));
		
		appStoreButton.click();

		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		
		Thread.sleep(2000);
		
		String titleAS = driver.getTitle();
        
		File sShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sShot, new File("/tmp/testAppStoreButton.png"));
		
		Assert.assertTrue("Failure: link is ok", titleAS.contentEquals("LIVE4 GoPro Ñ Live LIVE on the App Store on iTunes"));
	}
	
	@Test
	//test GooglePlay button
	public void testGooglePlayButton() throws InterruptedException, IOException{
		driver.get(url);
		WebElement googlePlayButton = pause.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bottompart .app__googleplay")));
		
		googlePlayButton.click();

		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		
		Thread.sleep(2000);
		
		String titleGP = driver.getTitle();

        File sShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sShot, new File("/tmp/testGooglePlayButton.png"));
		
		Assert.assertTrue("Failure: link is ok", titleGP.contentEquals("LIVE4 GoPro - Android Apps on Google Play"));
	}
}
