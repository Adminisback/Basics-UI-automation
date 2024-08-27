package Package1;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import NewFeaturesInSelenium.CommonDriver;

public class Assignment1 extends CommonDriver {

	public static  void main(String[] args) throws IOException {
		Assignment1 launchC = new Assignment1();
		launchC.test(launchC.launchChrome());
	}
	public void test(WebDriver driver) {
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("okayBtn")));
	    driver.findElement(By.id("okayBtn")).click();

		WebElement dropdown = driver.findElement(By.cssSelector("select[data-style='btn-info']"));
		Select SelectOptions = new Select(dropdown);
		SelectOptions.selectByValue("consult");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText("Checkout")));
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='card-footer']/button"));
		for (WebElement product : products) {
		product.click();
		}
		driver.findElement(By.partialLinkText("Checkout")).click();

	}

}
