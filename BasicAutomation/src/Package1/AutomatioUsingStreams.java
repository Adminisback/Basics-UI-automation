package Package1;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import NewFeaturesInSelenium.CommonDriver;

public class AutomatioUsingStreams extends CommonDriver {

	public static void main(String[] args) throws IOException {
		AutomatioUsingStreams chrome = new AutomatioUsingStreams();
		
		getTheListOfElementsByStreams(chrome.launchChrome());
	}

	public static void getTheListOfElementsByStreams(WebDriver driver) {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		// Click on Veg/Fruets Name column header;
		driver.findElement(By.xpath("//tr/th[1]")).click();

		// Captur all the webElements available in veg/Fruets coloumn;
		List<WebElement> availableListOfFruets = driver.findElements(By.xpath("//tr/td[1]"));

		// Get Text of all the captured Elements into original List;
		List<String> GetTextOfFruets = availableListOfFruets.stream().map(s -> s.getText())
				.collect(Collectors.toList());

		// Convert The captured List of Fruets into original one by sorting;
		List<String> getOriginalListOfFruetsSorted = GetTextOfFruets.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(getOriginalListOfFruetsSorted.equals(GetTextOfFruets));

		String vegName = "Tomato";
		// Get The name column with getText -Beans->Get The price of Beans from sorted
		// list;
//		List<String> getPrice = availableListOfFruets.stream().filter(s->s.getText().contains(vegName))
//			.map(s->getThePriceOfBeans(s)).collect(Collectors.toList());
//		getPrice.forEach(s->System.out.println("The Price of the "+vegName+" is :"+s));

		// What if the product is not present on current page?
		List<String> getPrice;
		do {
			List<WebElement> ListOfProducts = driver.findElements(By.xpath("//tr/td[1]"));
			getPrice = ListOfProducts.stream().filter(s -> s.getText().contains(vegName))
					.map(s -> getThePriceOfBeans(s)).collect(Collectors.toList());
			getPrice.forEach(s -> System.out.println("The Price of the " + vegName + " is :" + s));
			if (getPrice.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (getPrice.size() < 1);
	}

	private static String getThePriceOfBeans(WebElement s) {
		String getElementPrice = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return getElementPrice;
	}

}
