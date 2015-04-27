import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TitlePageTest {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new SafariDriver();
		WebDriverWait pause = new WebDriverWait(driver, 2000);
		
		//test "Explore" menu button
		driver.get("http://live4.io/");
		WebElement exploreLink = driver.findElement(By.linkText("Explore"));
		exploreLink.click();
		WebElement player = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("poster")));
		if(player.isDisplayed()){
			System.out.println("'Explore' link is ok");
		}
		
		//test "Map" menu button
		driver.get("http://live4.io/");
		WebElement mapLink = driver.findElement(By.linkText("Map"));
		mapLink.click();
		WebElement map = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("gm-style")));
		if(map.isDisplayed()){
			System.out.println("'Map' link is ok");
		}
		
		//test "Quick Start" link
		driver.get("http://live4.io/");
		WebElement quickStartLink = driver.findElement(By.linkText("Quick Start"));
		quickStartLink.click();
		WebElement fiveSteps = pause.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
		fiveSteps.getText();
		if(fiveSteps.getText().equals("5 steps to start streaming LIVE")){
			System.out.println("'Quick Start' menu link is ok");
		}
				
		//test "Explore LIVE4" button
		driver.get("http://live4.io/");		
		WebElement bigRedButton = driver.findElement(By.className("lives__more"));
		bigRedButton.click();
		WebElement player_ = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("poster")));
		if(player_.isDisplayed()){
			System.out.println("Explore LIVE4 button is ok");
		}
		Thread.sleep(2000);
		
		//test link to GooglePlay
		driver.get("http://live4.io/");
		WebElement googlePlayButton = driver.findElement(By.className("app__googleplay"));
		googlePlayButton.click();
		Thread.sleep(3000);
		String titleGP = driver.getTitle();
		if (titleGP.contentEquals("LIVE4 GoPro - Android Apps on Google Play")){
			System.out.println("Google Play button is ok");
		};
		
		//test link to AppStore
		driver.get("http://live4.io/");
		WebElement appStoreButton = driver.findElement(By.className("app__appstore"));
		appStoreButton.click();
		Thread.sleep(3000);
		String titleAS = driver.getTitle();
		if (titleAS.contentEquals("LIVE4 GoPro Ñ Live LIVE on the App Store on iTunes")){
			System.out.println("App Store button is ok");
		};

			driver.close();
			driver.quit();
		}

}
