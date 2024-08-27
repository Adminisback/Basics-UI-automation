package Package1;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class SearchVeggiesInFilter {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver-win64\\chromedriver-win64.exe");
		WebDriver driver = new ChromeDriver(options);
		searchVeggiesInSearchBar(driver);
	}
	public static void searchVeggiesInSearchBar(WebDriver driver){
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("input[id='search-field']")).sendKeys("Rice");
		List<WebElement> availableVeggies = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> collectTheFilteredList = availableVeggies.stream().filter(veggie->veggie.getText().contains("Rice"))
				.collect(Collectors.toList());
		Assert.assertEquals(collectTheFilteredList.size(),availableVeggies.size());
	}

}
