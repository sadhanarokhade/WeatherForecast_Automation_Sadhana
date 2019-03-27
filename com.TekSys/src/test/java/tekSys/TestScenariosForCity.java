package tekSys;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Pages.ForecastPage;
import util.Excel;
import validation.ValidateData;

public class TestScenariosForCity extends PreparationForTest {

	/*
	 * Scenario: Valid city1 search must display 5 days relevant weather forecast
	 * Given user has launched the browser And on WeatherForecast index page When
	 * searched for a valid city1 "Dundee" (or as provided in the excel sheet) Then
	 * weather forecast should be displayed for current day along with 4 consecutive
	 * future dates with respect to City1
	 */
	@Test(priority = 1)
	void TS001() {
		// logging on to application to land on weather forecast page
		ForecastPage fp = new ForecastPage(driver);
		fp.readCity();

		// getting the current day info for cross validating the application displayed
		// day
		ValidateData validate = new ValidateData();
		validate.thatIsDisplayedWithExpected(driver);

		// validating if the forecast displays 5 rows of data
		validate.numberOfRowsDisplayed(driver);

	}

	/*
	 * Scenario 2: Valid city2 search must display 5 days relevant weather forecast
	 * Given user has launched the browser And on WeatherForecast index page When
	 * searched for a valid city2 "Edinburgh" Then weather forecast should be
	 * displayed for current day along with 4 consecutive future dates with respect
	 * to City2
	 */
	@Test(priority = 3)
	void TS002() throws Exception {
		Excel e = new Excel();
		e.openWorkbook();

		// logging on to application to land on weather forecast page
		ForecastPage fp = new ForecastPage(driver);

		// getting the city value from excel sheet
		String city = e.getCity();

		// changing the default city displayed to choice of city
		fp.changeCity(city);

		// getting the current day info for cross validating the application displayed
		// day
		ValidateData validate = new ValidateData();
		validate.thatIsDisplayedWithExpected(driver);

		// validating if the forecast displays 5 rows of data
		validate.numberOfRowsDisplayed(driver);
	}

	/*
	 * Scenario 3: Invalid city search must display message Given user has launched
	 * the browser And on WeatherForecast index page When searched for a invalid
	 * city "xyz" Then weather forecast must display the message
	 * "Error retrieving the forecast"
	 */

	@Test(priority = 5)
	void TS003() {
		// logging on to application to land on weather forecast page
		ForecastPage fp = new ForecastPage(driver);
		fp.changeCity("xyz");

		String actualMessage = driver.findElement(By.xpath("//div[@data-test='error']")).getText();
		String expectedMessage = "Error retrieving the forecast"; //

		ValidateData validate = new ValidateData();
		validate.expectedVsActual(expectedMessage, actualMessage);

	}

	/*
	 * Scenario 4: Blank city search must display message Given user has launched
	 * the browser And on WeatherForecast index page When searched for a blank city
	 * \"" Then weather forecast must display the message
	 * \"Error retrieving the forecast"
	 */
	@Test(priority = 7)
	void TS004() {
		// logging on to application to land on weather forecast page
		ForecastPage fp = new ForecastPage(driver);
		fp.changeCity(" ");

		String actualMessage = driver.findElement(By.xpath("//div[@data-test='error']")).getText();
		String expectedMessage = "Error retrieving the forecast"; //

		ValidateData validate = new ValidateData();
		validate.expectedVsActual(expectedMessage, actualMessage);
	}

	/*
	 * Scenario 5: Multiple city search must display message Given user has launched
	 * the browser And on WeatherForecast index page When searched for a multiple
	 * cities separated by comma \"Glasgow,Edinburgh" Then weather forecast must
	 * display the message \"Error retrieving the forecast"
	 */
	@Test(priority = 9)
	void TS005() {
		ForecastPage fp = new ForecastPage(driver);
		fp.changeCity("Edinburgh,Dundee");

		String actualMessage = driver.findElement(By.xpath("//div[@data-test='error']")).getText();
		String expectedMessage = "Error retrieving the forecast"; //

		ValidateData validate = new ValidateData();
		validate.expectedVsActual(expectedMessage, actualMessage);
	}

}
