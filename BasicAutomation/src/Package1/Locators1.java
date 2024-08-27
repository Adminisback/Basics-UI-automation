package Package1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators1 {

	public static void main(String[] args){
		Locators1 obj = new Locators1();
		obj.locators();

	}
	public void locators() {
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Shirish mistari");
		driver.findElement(By.name("inputPassword")).sendKeys("1212");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Sutar Shirish");
			driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Sutar@123");
			driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
			driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("Mistari@123");
			driver.findElement(By.xpath("//form/input[3]")).sendKeys("9834033511");
			driver.findElement(By.xpath("//div/button[2]")).click();   //By x path
			System.out.println(driver.findElement(By.xpath("//p[@class=\"infoMsg\"]")).getText());
			driver.findElement(By.xpath("//div[@class=\"forgot-pwd-btn-conainer\"]/button[1]")).click();
			driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Shirish Mistari");
			driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
			driver.findElement(By.id("chkboxOne")).click();
			driver.findElement(By.xpath("//div/span/input")).click();
			driver.findElement(By.xpath("//button[contains(@class,'signIn')]")).click();



		} catch (InterruptedException e) {
			e.printStackTrace();
		}



	}

}
