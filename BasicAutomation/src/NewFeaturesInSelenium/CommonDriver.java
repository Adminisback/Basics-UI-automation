package NewFeaturesInSelenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonDriver {
public WebDriver driver;

//public CommonDriver(WebDriver driver) {
//	this.driver=driver;
//}
       
	public WebDriver launchChrome() throws IOException {
		//Code for closing chrome being automated by automation software...
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");
		
		//Basic code from properties file....
		Properties pro = new Properties();
		 FileInputStream path = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\CommonBrowser.properties");
		pro.load(path);
	    pro.getProperty("browser");
		//WebDriver driver = new ChromeDriver(options);
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver(options);  //Argument of chromeOptions..
	    return driver;
	}
	public void maximizeWindows(WebDriver driver) {
	   driver.manage().window().maximize();
	}

	
	
}
