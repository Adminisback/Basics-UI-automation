package Package1;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import NewFeaturesInSelenium.CommonDriver;
import dev.failsafe.internal.util.Durations;

public class Actions1 extends CommonDriver {
// Path for ChromeDriver.....F:\\Drivers\\chromedriver-win32\\Chromedriver.exe
	public static void main(String[] args) throws IOException {
	    Actions1 launchD = new Actions1();
		Actions1 obj = new Actions1();

		 obj.Actionsss(launchD.launchChrome());
		 switchToChildWindowsss(launchD.launchChrome());
	}
	public void Actionsss(WebDriver driver) {
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		/*
		 * driver.findElement(By.xpath("//button[@class='a-button-text']")).click(); try
		 * { Thread.sleep(1000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		//Adding wait to verify capcha manually..
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[id='nav-link-accountList']")));
		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("samsung galaxy 2 shirish").doubleClick().perform();
		// Right click on element
		act.moveToElement(move).contextClick().build().perform();
		//Drag and drop;

	}
	public static void switchToChildWindowsss(WebDriver driver) {
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		Set<String> windows = driver.getWindowHandles();   // [ParentWindowsID[0] , ChildWindowsID[1], SubChildWindowsID[2]];
		Iterator<String> iterateTheWindows = windows.iterator();
		String ParentWindowsID = iterateTheWindows.next();   //[ParentWindowsID]
		String ChildWindowsID =  iterateTheWindows.next();   //[ChildWindowsID]
		driver.switchTo().window(ChildWindowsID);
		System.out.println(driver.findElement(By.xpath("//div[@class='col-md-8']/p[2]")).getText());
		driver.findElement(By.xpath("//div[@class='col-md-8']/p[2]"));
		String SplitedTextFromChildWindows = driver.findElement(By.xpath("//div[@class='col-md-8']/p[2]")).getText().split("at")[1].trim().split(" ")[0];
		//Control is in Child Window have to switch from child to parent ;
		driver.switchTo().window(ParentWindowsID);
		driver.findElement(By.id("username")).sendKeys(SplitedTextFromChildWindows);

	}

}
