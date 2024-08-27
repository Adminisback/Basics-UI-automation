package Package1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import NewFeaturesInSelenium.CommonDriver;

public class FrameTest extends CommonDriver {

	public static void main(String[] args) throws IOException {
		FrameTest t = new FrameTest();
		test(t.launchChrome());
		

	}

	public static void test(WebDriver driver) {
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		//NumberofFrames available on page;
		int numberOfFramesAvailabe = driver.findElements(By.tagName("iframe")).size();
		System.out.println(numberOfFramesAvailabe);
		// By frame index;
		driver.switchTo().frame(0);
		// driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));  // By String

		// driver.findElement(By.id("draggable")).click();
		Actions a = new Actions(driver);
		WebElement sourceDrag = driver.findElement(By.id("draggable"));
		WebElement targetDrop = driver.findElement(By.id("droppable"));
		a.dragAndDrop(sourceDrag, targetDrop).build().perform();
		driver.switchTo().defaultContent();   // out of frame tag;
	}
}
