package Browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//creating a class for doing browser actions
public class LaunchApplication {
	//method for launching browser of choice: Google Chrome/Internet Explorer/Mozilla Firefox
	public WebDriver launchBrowser(WebDriver driver, String browser) 
	{	
		if(browser.equals("IE") )
		{
			System.setProperty("webdriver.ie.driver", "../.././Wipro/com.TekSys/src/main/resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if (browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "../.././Wipro/com.TekSys/src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else// (browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "../.././Wipro/com.TekSys/src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}
	//method for entering the URL under test and synchronizing
	public WebDriver enterUrl(WebDriver driver, String uRL)
	{
		driver.get(uRL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
}
