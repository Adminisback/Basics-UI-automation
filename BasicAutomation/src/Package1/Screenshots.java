package Package1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
 // import org.apache.commons.io.FileUtils;
public class Screenshots {

	public static void main(String[] args) throws IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver-win32\\Chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File("F:\\destop\\screenshot.png"));
	}

}
