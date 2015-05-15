package io.live4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.After;
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

public class TestStreaming {
	private ChromeDriver driver;
	private WebDriverWait pause;
	private String url = "https://live4.io/stream/SharukhanClan/193457451289508288_GOPR9211.LRV";

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
	public void testStreamingStartMoment() throws InterruptedException, IOException{

		System.out.println(name.getMethodName());

		driver.get(url);
		WebElement play = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("poster")));
		play.click();

		Thread.sleep(300);

		WebElement pause = driver.findElement(By.cssSelector("#live_SharukhanClan_193457451289508288_GOPR9211LRV > div.medium-8.columns > div.live__media > div > div.playerHolder > div"));
		pause.click();

		WebElement startTime = driver.findElementByClassName("live4player-navigation-time-current");
		String startedAt = startTime.getText();

		File streamingStartMoment = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(streamingStartMoment, new File("/tmp/streamingStartMoment.png"));

		Assert.assertTrue("FAILURE: video streams from the beginning", startedAt.equals("00:00"));
	}


	@Test
	public void testStreaming() throws InterruptedException, IOException{

		System.out.println(name.getMethodName());

		driver.get(url);
		WebElement play = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("poster")));
		play.click();

		Thread.sleep(5000);

		WebElement pause = driver.findElement(By.cssSelector("#live_SharukhanClan_193457451289508288_GOPR9211LRV > div.medium-8.columns > div.live__media > div > div.playerHolder > div"));
		pause.click();

		WebElement stopTime = driver.findElementByClassName("live4player-navigation-time-current");
		String pausedAt = stopTime.getText();

		File streamingPauseMoment = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(streamingPauseMoment, new File("/tmp/streamingPauseMoment.png"));

		Assert.assertTrue("FAILURE: video played back", pausedAt.equals("00:04"));

	}
}

