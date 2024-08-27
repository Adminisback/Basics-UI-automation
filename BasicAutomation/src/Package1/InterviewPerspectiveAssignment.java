package Package1;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import NewFeaturesInSelenium.CommonDriver;

public class InterviewPerspectiveAssignment extends CommonDriver {

	public static void main(String[] args) throws IOException {
		InterviewPerspectiveAssignment k = new InterviewPerspectiveAssignment();
		handlingLinksInWindows(k.launchChrome());
	}
	public static void handlingLinksInWindows(WebDriver driver) {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		//Requirements in interview logic questions;
		// 1] Get the number of available links on the current page;
		System.out.println("Get the number of links :"+driver.findElements(By.tagName("a")).size());
		// 2] from footer sections - By Limiting WebDriverScope;
		WebElement getTheNumberOfLinksFromFooterSection = driver.findElement(By.id("gf-BIG"));  //>>>//Limiting WebDriverScope;
		System.out.println("Get The Number Of Links From Footer Section :"+getTheNumberOfLinksFromFooterSection.findElements(By.tagName("a")).size());
		// 3] Get The Number of Links from footer coloumn only ;                              //>>>//Limiting WebDriverScope;
		WebElement getTheNumberOfLinksFromSingleFooterColoumn = getTheNumberOfLinksFromFooterSection.findElement(By.xpath("//div/table/tbody/tr/td/ul"));  ////>>>//Limiting WebDriverScope;
		System.out.println("Get The Number Of Links From Footer Coloumn Only :"+getTheNumberOfLinksFromSingleFooterColoumn.findElements(By.tagName("a")).size());
		// 4] Click On Each Links From Footer Coloumn and Check Whether the links are opening in separate windows or not;
		for(int i = 1; i<getTheNumberOfLinksFromSingleFooterColoumn.findElements(By.tagName("a")).size(); i++) {
			String clickOnLinksByPressingControleKeyAndEnterKey = Keys.chord(Keys.CONTROL, Keys.ENTER); //clicking on link by pressing control
			getTheNumberOfLinksFromSingleFooterColoumn.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinksByPressingControleKeyAndEnterKey);
		}
		// 4] Get The Title Of Each Windows Opened;
		Set<String> numberOfWindowsOpenedCurrently = driver.getWindowHandles();
		Iterator<String> iterateTheNumberOfWindowsOpenedTitle = numberOfWindowsOpenedCurrently.iterator();
		System.out.println("Get Text Of Each Windows Opened Title :");
		while(iterateTheNumberOfWindowsOpenedTitle.hasNext()) {
			 driver.switchTo().window(iterateTheNumberOfWindowsOpenedTitle.next());
			 System.out.println(driver.getTitle());

		}
	}

}
