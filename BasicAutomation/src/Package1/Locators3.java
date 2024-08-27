package Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Locators3 {

	public static void main(String[] args) {
		//Siblings xpath -relative from top to bottom
		//       xpath-absolute from middle from dom;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver-win32\\Chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement dropdown = driver.findElement(By.name("ctl00$mainContent$ddl_originStation1"));
		Select obj = new Select(dropdown);
//		obj.selectByIndex(3);
//		System.out.println(obj.getFirstSelectedOption().getText());
//		obj.selectByVisibleText("Ahmedabad (AMD)");
//		System.out.println(obj.getFirstSelectedOption().getText());
		obj.selectByValue("INR");
		System.out.println(obj.getFirstSelectedOption().getText());
//		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
//		driver.navigate().back();
//		driver.navigate().forward();

		//relative xpath=//header/div/button[1]/following-sibling::button[1]
//		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
//		System.out.println(driver.findElement(By.xpath("//header/div/button[2]/parent::div/a/button/parent::a/parent::div/button[2]")).getText());
		// driver.close();
	}

}
