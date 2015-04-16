import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GenTest {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new SafariDriver();
		WebDriverWait pause = new WebDriverWait(driver, 2);
		
		// Open live4
		driver.get("http://live4.io/");
		
		// Find and click Explore link
		WebElement exploreButton = driver.findElement(By.linkText("Explore"));
		exploreButton.click();
		
		//Wait until the page is loaded
		Thread.sleep(1000);
		
		System.out.println(driver.getTitle());
		
		Thread.sleep(1000);
		
		List<WebElement> video = driver.findElements(By.className("poster"));
		video.get(0).click();
				
		WebElement mapFirst = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("is-withlocation")));
				
		if (mapFirst.isDisplayed()){
			System.out.println("map is shown");
		}else{System.out.println("map is not shown");}
		
		Thread.sleep(5000);
		
		video.get(1).click();
		WebElement mapSecond = pause.until(ExpectedConditions.visibilityOfElementLocated(By.className("is-withlocation")));
		
		if (mapSecond.isDisplayed()){
			System.out.println("map is shown");
		}else{System.out.println("map is not shown");}

		Thread.sleep(3000);
			
		driver.quit();
	}

}
