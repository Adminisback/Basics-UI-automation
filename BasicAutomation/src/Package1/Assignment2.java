package Package1;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import NewFeaturesInSelenium.CommonDriver;

public class Assignment2 extends CommonDriver{

	public static void main(String[] args) throws IOException {
		Assignment2 launchC = new Assignment2();
		
		getTextFromChildAndParentWindows(launchC.launchChrome());
		handlingNestedFrames(launchC.launchChrome());
	}
	public static void getTextFromChildAndParentWindows(WebDriver driver) {
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Set<String> switchToChildWindows = driver.getWindowHandles();   //[parentWindowsID[0],childWindowsID[1]]
		Iterator<String> iterateTheWindows = switchToChildWindows.iterator();
		String parentWindowsID = iterateTheWindows.next();    //[parentWindowsID[0]]
		String childWindowsID = iterateTheWindows.next();   ////[childWindowsID[1]]
		driver.switchTo().window(childWindowsID);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("New Window")));
		System.out.println(driver.findElement(By.xpath("//h3[text()='New Window']")).getText());
		// System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		driver.switchTo().window(parentWindowsID);
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		}
	public static void handlingNestedFrames(WebDriver driver) {
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		int numberofFramesAvailableOnPage = driver.findElements(By.tagName("frame")).size();
		System.out.println(numberofFramesAvailableOnPage);
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.id("content")).getText());
	}

}
