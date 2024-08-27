package Package1;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import NewFeaturesInSelenium.CommonDriver;


public class FluentWait1 extends CommonDriver {

	public static void main(String[] args) throws IOException {
		FluentWait1 m = new FluentWait1();
		m.test(m.launchChrome());
		
	}
	public void test(WebDriver driver) {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("div[id='start'] button")).click();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		 WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		     @Override
			public WebElement apply(WebDriver driver) {
		    	 if(driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed()) {
		    		 return driver.findElement(By.cssSelector("div[id='finish'] h4"));
		    	 }else {
		    		 return null;
		    	 }
		     //  return driver.findElement(By.cssSelector("div[id='finish'] h4"));
		     }
		   });
		 System.out.println(driver.findElement(By.cssSelector("div[id='finish'] h4")).getText());
	}

}
