package Package1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		Locators2 obj = new Locators2();
		obj.locators2();
	}
	public void locators2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		String name="Shirish Mistari";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String pass1 = test(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(pass1);
		driver.findElement(By.className("signInBtn")).click();
		try {
			Thread.sleep(1000);
			System.out.println(driver.findElement(By.tagName("p")).getText());
			Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
			Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello"+" "+ name +",");
			driver.findElement(By.xpath("//button[text()='Log Out']")).click();
			driver.close();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	public static String test(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div/button[2]")).click();
		String pass= driver.findElement(By.xpath("//p[@class=\"infoMsg\"]")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
		String[] passArray = pass.split("'");
//		String[] passArray1 = passArray[1].split("'");
		// passArray1[0];
 		String pass1 = passArray[1].split("'")[0];
 		return pass1;
		//0th index -Please use temporary password   first array
		//1th index -rahulshettyacademy' to Login.

		//0th index -rahulshettyacademy              Second array
		//1st index - to Login.

	}

}
