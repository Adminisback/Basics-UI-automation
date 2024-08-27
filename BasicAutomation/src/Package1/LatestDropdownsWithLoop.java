package Package1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import NewFeaturesInSelenium.CommonDriver;

public class LatestDropdownsWithLoop extends CommonDriver{
	static WebDriver driver;
	public static CommonDriver obj;
 static String URL = "https://rahulshettyacademy.com/angularpractice/";
	public static void main(String[] args) throws InterruptedException, IOException {
		LatestDropdownsWithLoop  o = new LatestDropdownsWithLoop();
		  // test(o.launchChrome(),o);
		  //   test2(o.launchChrome(),o);
		   test3(o.launchChrome(),o);
	}

	public static void test(WebDriver driver, LatestDropdownsWithLoop  o) throws InterruptedException {
		driver.get(URL);
		o.maximizeWindows(driver);
		//Selecting the checkbox and counting of checkbox
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='mainContent_chk_IndArm']")).isSelected());
		// System.out.println(driver.findElement(By.cssSelector("input[id*='mainContent_chk_IndArm']")).isSelected());
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_IndArm']")).click();
		// System.out.println(driver.findElement(By.cssSelector("input[id*='mainContent_chk_IndArm']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='mainContent_chk_IndArm']")).isSelected());
		//Finding the size of the checkboxes..
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		System.out.println("Before Selection :" + (driver.findElement(By.id("divpaxinfo")).getText()));
		int i=1;
		while(i<6) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println("After Selection :" + (driver.findElement(By.id("divpaxinfo")).getText()));
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"6 Adult", null);
		// driver.close();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("The Return Date is enabled");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("The Date is not enabled");
			Assert.assertFalse(true);
		}

	}
	public static void test2(WebDriver driver,LatestDropdownsWithLoop  o) throws InterruptedException {
		
		driver.get(URL);
		o.maximizeWindows(driver);
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='IXL']")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click();  By parent child relationship
		// driver.findElement(By.xpath("//TD[@CLASS='mapbg']  //a[@value='GAU']")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GAU']")).click();
		// driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='HYD']")).click();
	    driver.findElement(By.xpath("(//a[text()='16'])[1]")).click();
		System.out.println("The Selected Date is :"+driver.findElement(By.xpath("(//a[text()='16'])[1]")).getText());
	}
	public static void test3(WebDriver driver,LatestDropdownsWithLoop  o) {
	
		driver.get(URL);
		o.maximizeWindows(driver);
		driver.findElement(By.name("name")).sendKeys("Shirish Mistari");
		driver.findElement(By.name("email")).sendKeys("S@12233");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("12233");
		driver.findElement(By.cssSelector("#exampleCheck1")).click();
		WebElement GenderDropdown = driver.findElement(By.cssSelector("#exampleFormControlSelect1"));
		Select options11 = new Select(GenderDropdown);
		options11.selectByVisibleText("Male");
		driver.findElement(By.cssSelector("input[value='option1']")).click();
		driver.findElement(By.name("bday")).sendKeys("23/97/1990");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());

	}

}
