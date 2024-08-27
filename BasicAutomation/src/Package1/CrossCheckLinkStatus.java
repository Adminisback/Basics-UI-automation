package Package1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

import NewFeaturesInSelenium.CommonDriver;

public class CrossCheckLinkStatus extends CommonDriver {

	public static void main(String[] args) throws MalformedURLException, IOException {
		CrossCheckLinkStatus v = new CrossCheckLinkStatus();
		  test(v.launchChrome());
	}
	public static void test(WebDriver driver) throws IOException {
		// a[href*='soapui']
				// How to find links with broken URLs at a one time
				// Step1 - Is to get all URLs tied up to the links
				// Java method will call the URL and gets u the STATUS FR THE LINK
				// iF STATUS CODE IS >400 THEN THE LINK WILL BE BROKERN TIED U WITH THAT URL;

				
				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				SoftAssert a = new SoftAssert();
				// String get
				// =driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
				// for one link only
				List<WebElement> numberOfLinks = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
				for (WebElement links : numberOfLinks) {
					String getLinks = links.getAttribute("href");
					HttpURLConnection connectURL = (HttpURLConnection) new URL(getLinks).openConnection();
					connectURL.setRequestMethod("HEAD");
					connectURL.connect();
					int responseCode = connectURL.getResponseCode();
					System.out.println(responseCode);

					// To continue execution of scripts use below code;
					a.assertTrue(responseCode < 400,
							"The link with Name- " + links.getText() + " is broken with status code :" + responseCode);

					// It is stoping at broken link.
//					if(responseCode>400) {
//						System.out.println("The link with Name- "+links.getText()+" is broken with status code :"+responseCode);
//						Assert.assertTrue(false);
//					}
				}
				a.assertAll();
	}

}
