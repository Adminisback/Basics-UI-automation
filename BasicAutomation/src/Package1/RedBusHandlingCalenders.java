package Package1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import NewFeaturesInSelenium.CommonDriver;
import NewFeaturesInSelenium.RedBusInterface;

public class RedBusHandlingCalenders extends CommonDriver implements RedBusInterface {

	public static void main(String[] args) throws IOException, InterruptedException {
		RedBusHandlingCalenders l = new RedBusHandlingCalenders();
		handleCalenders(l.launchChrome(), l);
	}

	public static void handleCalenders(WebDriver driver, RedBusHandlingCalenders l) throws InterruptedException {
		driver.get("https://www.redbus.in/");
		l.maximizeWindows(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			WebElement Fromelement = driver.findElement(By.xpath(clickOnFromCity));
			Fromelement.click();
			WebElement input = driver.findElement(By.xpath(fromInputXpath));
			input.sendKeys(fromCityInput);

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(fromListOfCities)));
			List<WebElement> cities = driver.findElements(By.xpath(fromListOfCities));
			getList(driver, cities, expectedNameToShow);
			try {
				WebElement toDestination = driver.findElement(By.xpath(toInputXpath));
				toDestination.sendKeys(toCityInput);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(toListOfCities)));
				List<WebElement> cities2 = driver.findElements(By.xpath(toListOfCities));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(toListOfCities)));

				getList(driver, cities2, expectedNameToShowForSelect);
			}catch (Exception e) {
				List<WebElement> cities2 = driver.findElements(By.xpath(toListOfCities));
				getList(driver, cities2, expectedNameToShowForSelect);
			}
		} catch (ElementNotInteractableException e) {
			System.out.println("Element is not interactable: " + e.getMessage());
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dateBlock)));
		WebElement month = driver.findElement(By.xpath(months));
		while (!month.getText().contains(monthName)) {
			driver.findElement(By.xpath(clickOnNextDateMonth)).click();
		}
//		List<WebElement> listDates = driver
//				.findElements(By.xpath(listOfDates));
		int numberOfDatesInList = driver.findElements(By.xpath(listOfDates)).size();
		for (int i = 0; i < numberOfDatesInList; i++) {
			String getDateText = driver.findElements(By.xpath(listOfDates)).get(i).getText();
			if (getDateText.equalsIgnoreCase("25")) {
				driver.findElements(By.xpath(listOfDates)).get(i).click();
				break;
			}
		}
		WebElement searchBuses = driver.findElement(By.xpath(searchBus));
		searchBuses.click();

	}

	public static void getList(WebDriver driver, List<WebElement> list, String name) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {

			for (WebElement ll : list) {
				if (ll.getText().equalsIgnoreCase(name)) {
					wait.until(ExpectedConditions.visibilityOfAllElements(list));
					ll.click();
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
