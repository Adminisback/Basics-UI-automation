package Package1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import NewFeaturesInSelenium.CommonDriver;

public class Assignment3 extends CommonDriver {

	public static void main(String[] args) throws IOException {
		Assignment3 launchC = new Assignment3();
		
		dynamicSelection(launchC.launchChrome());
	}

	public static void dynamicSelection(WebDriver driver) {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// 1] Select the checkbox option2
		driver.findElement(By.xpath("//div[@class='block large-row-spacer']/div[4]/fieldset/label[2]/input")).click();

		System.out.println(driver
				.findElement(By.xpath("//div[@class='block large-row-spacer']/div[4]/fieldset/label[2]")).getText());
		// 2] Put in variable label of selected checkbox;
		String selectedOptionsLabel = driver
				.findElement(By.xpath("//div[@class='block large-row-spacer']/div[4]/fieldset/label[2]")).getText();
		// 3] Select Option2 from step2 no hardcoding;
		WebElement selectOptions11 = driver.findElement(By.cssSelector("select[id='dropdown-class-example']"));
		Select selectOptions = new Select(selectOptions11);
		selectOptions.selectByVisibleText(selectedOptionsLabel);
		driver.findElement(By.id("name")).sendKeys(selectedOptionsLabel);
		driver.findElement(By.id("alertbtn")).click();
		driver.switchTo().alert().getText();
		String verifyEnteredTextMessage = driver.switchTo().alert().getText();
		// 4] Verify the Entered text is grabbed in popup or not;
		if (verifyEnteredTextMessage.contains(selectedOptionsLabel)) {
			System.out.println("Alert is successfull");
		} else {
			System.out.println("Alert is not successfull");
		}
		// driver.switchTo().alert().accept();
	}

}
