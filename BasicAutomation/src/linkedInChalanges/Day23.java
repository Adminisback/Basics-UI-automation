package linkedInChalanges;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import NewFeaturesInSelenium.CommonDriver;

public class Day23 extends CommonDriver{
	static WebDriver driver;
	public static void main(String args[]) throws IOException, InterruptedException {
		Day23 obj = new Day23();
		obj.cha23(obj.launchChrome());
	}
	public void cha23(WebDriver driver) throws InterruptedException {
		driver.get("https://demo.automationtesting.in/");
		driver.manage().window().maximize();
		WebElement link = driver.findElement(By.id("email"));
		link.sendKeys("Shirish123@gmail.com");
		WebElement dr = driver.findElement(By.id("enterimg"));
		dr.click();
		WebElement tt = driver.findElement(By.xpath("//a[text()='Interactions ']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(tt).build().perform();
		WebElement oo = driver.findElement(By.xpath("//a[text()='Drag and Drop ']"));
		ac.moveToElement(oo).build().perform();
		driver.findElement(By.xpath("//a[text()='Static ']")).click();
		Thread.sleep(1000);	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)");
		int yyy = driver.findElements(By.tagName("iframe")).size();
		System.out.println(yyy);
		//driver.switchTo().frame(0);
		WebElement dragFrom = driver.findElement(By.xpath("(//div[@id='dragarea']/div/img)[1]"));
	    WebElement dropTo = driver.findElement(By.xpath("//div[@id='droparea']"));
		ac.dragAndDrop(dragFrom,dropTo).build().perform();
		WebElement drop = driver.findElement(By.xpath("//a[text()='Widgets']"));
		ac.moveToElement(drop).perform();
		WebElement hhhh = driver.findElement(By.xpath("//a[text()=' Datepicker ']"));
		ac.moveToElement(hhhh).click().build().perform();
		driver.findElement(By.xpath("//img[@class='imgdp']")).click();
		String mon = "July 2024";
		WebElement month = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"));
		while(!month.getText().contains(mon)) {
			
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			Thread.sleep(1000);
			
		}
		int sizeofDates = driver.findElements(By.xpath("//a[@class='ui-state-default']")).size();
		for(int i=0; i< sizeofDates; i++) {
			WebElement date = driver.findElement(By.xpath("//a[@class='ui-state-default']"));
			if(date.getText().equalsIgnoreCase("23")) {
				driver.findElements(By.xpath("//a[@class='ui-state-default']")).get(i).click();
				break;
			}
		}
	}
}
