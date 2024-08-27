package Package1;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import NewFeaturesInSelenium.CommonDriver;

public class E2EAutomation extends CommonDriver {

	public static void main(String[] args) throws InterruptedException, IOException {
		E2EAutomation j = new E2EAutomation();
		GetAutomationOfSpiceJect(j.launchChrome());
	}

	public static void GetAutomationOfSpiceJect(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[id='autosuggest']")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> optionss = driver.findElements(By.cssSelector("ul[id='ui-id-1'] a"));
		for (WebElement optionsss : optionss) {
			if (optionsss.getText().equalsIgnoreCase("India")) {
				optionsss.click();
				break;
			}
//			else {
//				optionsss.getText();
//			}
		}

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BOM']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GAU']"))
				.click();
		driver.findElement(By.xpath("(//a[text()='16'])[1]")).click();

		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='mainContent_chk_IndArm']")).isSelected());
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_IndArm']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='mainContent_chk_IndArm']")).isSelected());

		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		System.out.println("Before Selection :" + (driver.findElement(By.id("divpaxinfo")).getText()));
		int i = 1;
		while (i < 6) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println("After Selection :" + (driver.findElement(By.id("divpaxinfo")).getText()));
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "6 Adult", null);

		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		// driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
		// System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("The Return Date is enabled");
			Assert.assertTrue(true);
		} else {
			System.out.println("The Date is not enabled");
			Assert.assertFalse(false);
		}

		WebElement dropdowns = driver
				.findElement(By.xpath("//select[@name='ctl00$mainContent$DropDownListCurrency'][1]"));
		Select obj = new Select(dropdowns);
		obj.selectByValue("USD");
		System.out.println(obj.getFirstSelectedOption().getText());

		// Clicking on search button
		driver.findElement(By.xpath("//input[@name='ctl00$mainContent$btn_FindFlights'][1]")).click();

	}

}
