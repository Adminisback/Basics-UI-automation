package NewFeaturesInSelenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class InvokingMultipleWindows extends CommonDriver{
 static WebDriver driver;
	public static void main(String[] args) throws IOException {
		InvokingMultipleWindows launchChro = new InvokingMultipleWindows();
		invokMultipleWindowsAndNavigation(launchChro.launchChrome());
	}
	//The Feature is awailabe from selenium four;
	public static void invokMultipleWindowsAndNavigation(WebDriver driver) throws IOException {
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		// driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);  //Switching to multiple windows at run time..
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String ParentWindowID = it.next();
		String ChildWindowID = it.next();
		driver.switchTo().window(ChildWindowID);
		driver.get("https://courses.rahulshettyacademy.com/courses");
		// -  //div[@class='course-listing-title'])[2]
		String courseName = driver.findElement(By.xpath("(//div[@class='course-listing-title'])[2]")).getText();
		driver.switchTo().window(ParentWindowID);
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		// driver.quit();
		//Taking scrren shot of name edit box ;
		name.sendKeys(courseName);
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		//Get the hight and width of name edit box
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());

	}

}
