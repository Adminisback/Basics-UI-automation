package NewFeaturesInSelenium;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.*;

public class MakeMyTripAutomation extends CommonDriver {
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		MakeMyTripAutomation j = new MakeMyTripAutomation();
		closePopup(j.launchChrome());

	}
	public static void closePopup(WebDriver driver) {
		
		
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("webklipper-publisher-widget-container-notification-frame")));
			WebElement switchF = driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));
			driver.switchTo().frame(switchF);
			WebElement closePopup = driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div"));
			closePopup.click();
			driver.switchTo().defaultContent();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='imageSlideContainer']/section/span")));
			WebElement clocspop = driver.findElement(By.xpath("//div[@class='imageSlideContainer']/section/span"));
			clocspop.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='menu_Hotels']")));
			WebElement clickOnHotels = driver.findElement(By.xpath("//li[@class='menu_Hotels']"));
			
			clickOnHotels.click();
			WebElement search = driver.findElement(By.xpath("//div[@class='hsw_inputBox selectHtlCity']"));
			search.click();
			driver.findElement(By.xpath("//div[@class='hw__searchInputWrapper']/input")).sendKeys("Jalgaon");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-autowhatever-1")));
			WebElement listOfCities = driver.findElement(By.xpath("//ul[@class='react-autosuggest__suggestions-list']"));
			
			Select se = new Select(listOfCities);
			se.selectByVisibleText("Jalgaon, City in Maharashtra");
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
