package Package1;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import NewFeaturesInSelenium.CommonDriver;

public class AutosuggesiveDrop extends CommonDriver {

	public static void main(String[] args) throws InterruptedException, IOException {
		AutosuggesiveDrop c = new AutosuggesiveDrop();
		Common(c.launchChrome());
	}
	public static void Common(WebDriver driver) throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.cssSelector("input[id='autosuggest']")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> optionss = driver.findElements(By.cssSelector("ul[id='ui-id-1'] a"));
		for(WebElement optionsss:optionss) {
			if(optionsss.getText().equalsIgnoreCase("India")) {
				optionsss.click();
				break;
			}
//			else {
//				optionsss.getText();
//			}
		}
	}
}
