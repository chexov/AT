	package io.live4;

	import java.util.ArrayList;
import java.util.List;

	import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class ExplorePageTest {

			private ChromeDriver driver;
			private WebDriverWait pause;
			private String url = "http://live4.io/stream";

			//test Latest
			//test Recommended
			//test playback
			//test Link to youtube event
			//test Play Again
			
			@Before
			public void SetUp(){
				driver = new ChromeDriver();
				pause = new WebDriverWait(driver, 500);
			}

			@After
			public void tearDown(){
				driver.close();
				driver.quit();
			}
			
			@Rule public TestName name = new TestName();
			
			@Test
			//test link to the main page
			public void testLinkToMain() throws InterruptedException{
				
				System.out.println(name.getMethodName());
				
				driver.get(url);
				WebElement label = pause.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("svg")));
				label.click();
				WebElement liveLive = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("mainpage")));
				String checkLiveLive = liveLive.getText();

				Assert.assertTrue("FAILED: link to the main page is ok", checkLiveLive.equals("Live LIVE"));
			}
			
			@Test
			//test Map link
			public void testMapMenuLink(){
				
				System.out.println(name.getMethodName());
				
				driver.get(url);
				WebElement mapLink = driver.findElement(By.linkText("Map"));
				mapLink.click();
				WebElement map = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("gm-style")));
				
				Assert.assertTrue("FAILED: 'Map' link is ok", map.isDisplayed());
			}
			
			@Test
			//test Quick Start link
			public void testSrartMenuLink(){
				
				System.out.println(name.getMethodName());
				
				driver.get(url);
				WebElement quickStartLink = driver.findElement(By.linkText("Quick Start"));
				quickStartLink.click();
				WebElement fiveSteps = pause.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
				
				Assert.assertTrue("FAILED: 'Quick start' link is ok", fiveSteps.getText().equals("5 steps to start streaming LIVE"));
			}
			
			@Test
			//test AppStore button
			public void testAppStoreButton() throws InterruptedException{
				
				System.out.println(name.getMethodName());
				
				driver.get(url);
				WebElement appStoreButton = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("app_store_btn")));
				
				appStoreButton.click();

				List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(browserTabs.get(1));
				
				Thread.sleep(2000);
				
				String titleAS = driver.getTitle();
				System.out.println(titleAS);
				
				Assert.assertTrue("Failure: link is ok", titleAS.contentEquals("LIVE4 GoPro � Live LIVE on the App Store on iTunes"));
			}
			
			@Test
			//test GooglePlay button
			public void testGooglePlayButton() throws InterruptedException{
				
				System.out.println(name.getMethodName());
				
				driver.get(url);
				WebElement googlePlayButton = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("google_play_btn")));
				
				googlePlayButton.click();

				List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(browserTabs.get(1));
				
				Thread.sleep(2000);
				
				String titleGP = driver.getTitle();
				System.out.println(titleGP);
				
				Assert.assertTrue("Failure: link is ok", titleGP.contentEquals("LIVE4 GoPro - Android Apps on Google Play"));
			}
			
			@Test
			//test ShowMore button
			public void testShowMore() throws InterruptedException{
				
				System.out.println(name.getMethodName());
				
				driver.get(url);
				int numberVideosBefore = driver.findElementsByClassName("poster").size();
				
				driver.findElementByClassName("btn-more").click();
				Thread.sleep(2000);
				int numberVideosAfter = driver.findElementsByClassName("poster").size();
					
				Assert.assertTrue("FAILURE: Show more lives button works ok", numberVideosAfter - numberVideosBefore == 10);

			}
			
			@Test
			//test "Link to this video" 
			public void testLinkTTV() {
				
				System.out.println(name.getMethodName());
				
				driver.get(url);

				WebElement linkTTV = pause.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Link")));
				String linkA = linkTTV.getAttribute("href");
				linkTTV.click();
				String linkB = driver.getCurrentUrl();
				
				Assert.assertTrue("FAILURE: link to the current video is ok", linkA.equals(linkB));
			}
			
			@Test
			//test GooglePlay button within player body
			public void testGPLink() throws InterruptedException {
				
				System.out.println(name.getMethodName());
				
				driver.get(url+"/1409429809379240/");

				WebElement playButton = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("poster")));
				playButton.click();
				WebElement gpButton = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("app__googleplay")));
				gpButton.click();
				
				List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(browserTabs.get(1));
				
				Thread.sleep(2000);
				
				String titleGP = driver.getTitle();
				System.out.println(titleGP);
				
				Assert.assertTrue("Failure: link is ok", titleGP.contentEquals("LIVE4 GoPro - Android Apps on Google Play"));
			}
			
			@Test
			//test AppStore button within player body
			public void testASLink() throws InterruptedException {
				
				System.out.println(name.getMethodName());
				
				driver.get(url+"/1409429809379240/");

				WebElement playButton = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("poster")));
				playButton.click();
				WebElement gpButton = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("app__appstore")));
				gpButton.click();
				
				List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(browserTabs.get(1));
				
				Thread.sleep(2000);
				
				String titleGP = driver.getTitle();
				System.out.println(titleGP);
				
				Assert.assertTrue("Failure: link is ok", titleGP.contentEquals("LIVE4 GoPro � Live LIVE on the App Store on iTunes"));
			}
			
			@Test
			//testing map appearance for a particular video
			public void testShowMap() throws InterruptedException{
				
				System.out.println(name.getMethodName());
				
				driver.get(url+"/1409429809379240/");
				
				
				WebElement playButton = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("poster")));
				playButton.click();
				WebElement map = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("gm-style")));
				
				Assert.assertTrue("FAILURE: map is ok", map.isDisplayed());
			}
			
		}
