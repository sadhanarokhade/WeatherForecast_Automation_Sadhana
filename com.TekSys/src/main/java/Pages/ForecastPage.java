package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//index page
public class ForecastPage {
	WebElement city, header;
	WebDriver driver;

	// constructor accepting the driver as parameter
	public ForecastPage(WebDriver driver) {
		this.driver = driver;
	}

	public void readCity() {
		city = driver.findElement(By.id("city"));
		System.out.println("Default city displayed is: "+city.getAttribute("value"));
	}

	// method for selecting a different city
	public void changeCity(String newCityName) {
		city = driver.findElement(By.id("city"));
		System.out.println("Default city displayed is: "+city.getAttribute("value"));
		city.clear();
		city.sendKeys(newCityName);
		city.submit();
		city = driver.findElement(By.id("city"));
		System.out.println("Changed city is: "+city.getAttribute("value"));
	}

}
