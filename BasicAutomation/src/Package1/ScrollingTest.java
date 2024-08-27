package Package1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class ScrollingTest {

	public static void main(String[] args) throws InterruptedException {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		scrolll(driver);
		tablePractice(driver);
	}
	public static void scrolll(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		//Scrolling into the table so focusing in that table by below line, In console document.querySelectore
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		//Counting the sum of values available in table 
		List<WebElement> list = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for (WebElement element : list) {
		     sum = sum + Integer.parseInt(element.getText());  // Converting string into Integer
		}
		System.out.println(sum);
		driver.findElement(By.cssSelector(".totalAmount")).getText();
		int TotalSum = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(TotalSum, sum);

	}
	public static void tablePractice(WebDriver driver) {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement table = driver.findElement(By.id("product"));
		System.out.println(table.findElements(By.tagName("tr")).size());
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		List<WebElement> printSecondRowData = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println(printSecondRowData.get(0).getText());
		System.out.println(printSecondRowData.get(1).getText());
		System.out.println(printSecondRowData.get(2).getText());

	}

}
