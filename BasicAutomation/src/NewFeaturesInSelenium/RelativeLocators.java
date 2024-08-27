package NewFeaturesInSelenium;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RelativeLocators extends CommonDriver{

	public static void main(String[] args) throws IOException {
		RelativeLocators  launch = new RelativeLocators();
		getRelativeLabes(launch.launchChrome());
	}
	public static void getRelativeLabes(WebDriver driver) {
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameInputTag = driver.findElement(By.cssSelector("[name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameInputTag)).getText());
		WebElement emailEditBox = driver.findElement(By.cssSelector("[name='email']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(emailEditBox)).getText());
		WebElement dateOfBirthLabel = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateOfBirthLabel)).click();
        WebElement getCheckBoxLabel = driver.findElement(By.xpath("//label[text() = 'Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(getCheckBoxLabel)).click();
        WebElement radioButton = driver.findElement(By.cssSelector("[id='inlineRadio1']"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText());
        driver.findElement(By.cssSelector("[value='Submit']")).click();
        System.out.println(driver.findElement(By.className("alert")).getText());
	}


}
