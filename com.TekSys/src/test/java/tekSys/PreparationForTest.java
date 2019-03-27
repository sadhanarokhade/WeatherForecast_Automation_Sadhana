package tekSys;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import Browser.LaunchApplication;
import util.Excel;

public class PreparationForTest {
	WebDriver driver;
	//prepares the application browser before starting test execution
	@BeforeMethod
	public void preConfig() throws Exception {
		// Getting the Browser name from excel sheet for launching browser
		Excel e = new Excel();
		e.openWorkbook();
		String browser = e.getBrowserName();

		// Launching the browser and opening application
		LaunchApplication launchApp = new LaunchApplication();
		driver = launchApp.launchBrowser(driver, browser);

		// getting and launching the URL of hosted application
		String url = e.getUrl();
		driver = launchApp.enterUrl(driver, url);
	}

	// method for closing all the windows opened through launch
	@AfterMethod
	public void closeAllBrowsers(ITestResult result) {
		System.out.println("Test name:" + result.getMethod().getMethodName());
		driver.quit();
	}
	
	/*@AfterTest
	public void afterTest(ITestResult result) {
		  System.out.println("Test name:" + result.getMethod().getMethodName());
		}*/

}
