package Package1;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.*;

import NewFeaturesInSelenium.CommonDriver;


public class GreenKartAutomation extends CommonDriver {

	public static void main(String[] args) throws IOException, InterruptedException {
		GreenKartAutomation k = new GreenKartAutomation();
		test(k.launchChrome());
		
	}
	public static void test(WebDriver driver) throws InterruptedException {
		//implicite wait.....
				//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);   Declare Globaly once and use for all actins its olde
		        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  // In latest java selenium
				// WebDriverWait w = new WebDriverWait(driver,5)  in new version not working deprecated
				WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));  // in new version

				String[] productsName = { "Brocolli", "Cucumber", "Beetroot" };
				driver.get("https://rahulshettyacademy.com/seleniumPractise/");
				driver.manage().window().maximize();
				addProductsInCart(driver, productsName);
				driver.findElement(By.cssSelector("img[alt='Cart']")).click();
				driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
				w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input.promoCode")));
				driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
				driver.findElement(By.cssSelector("button.promoBtn")).click();
				//explici wait
				w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
				System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
				driver.findElement(By.xpath("//*[text()='Place Order']")).click();
				WebElement count = driver.findElement(By.xpath("//div[@class='wrapperTwo']/div/select"));
				count.click();
				Select selectCountry = new Select(count);
				selectCountry.selectByVisibleText("India");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='chkAgree']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[text()='Proceed']")).click();
				
				
				
				
	}

	public static void addProductsInCart(WebDriver driver, String[] productsName) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		// Converting Array in Arraylist...
		List itemsName = Arrays.asList(productsName);
		// Check whether the name you extracted is present in array list or not

		for (int i = 0; i < products.size(); i++) {
			// Formating the product Name
			String[] name = products.get(i).getText().split("-");
			// Cucumber -1 kg = Cucumber => name[0]=Cucumber & name[1] = 1 kg
			// Beans -1 kg = Beans
			// Mushroom -1 kg = Mushroom
			String formatedName = name[0].trim();
			if (itemsName.contains(formatedName)) {
				// click on add to cart button
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// break; cannot use break here because it will execute for only one vegetables
				// and come out of loop
				j++;
				if (j == productsName.length) {
					break;
				}
			}
		}

	}

}
