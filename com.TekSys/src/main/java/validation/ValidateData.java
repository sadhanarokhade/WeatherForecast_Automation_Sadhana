package validation;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

//Validation class for verifying the actual result vs expected result
public class ValidateData {
	
	//this method compares the current day with that displayed in the application
	public void thatIsDisplayedWithExpected(WebDriver driver)
	{ 
		LocalDate currentDate = LocalDate.now();
		String expectedDay = currentDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
		
		System.out.println("Today is: "+expectedDay);
		
		String actualDay = driver.findElement(By.xpath("//span[@data-test=\"day-1\"]")).getText().trim();
		System.out.println("First day on application is :"+ actualDay);
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualDay, expectedDay, "Displayed day and current day are not same");
		/*if(actualDay.equalsIgnoreCase(expectedDay))
		{
			System.out.println("Assertion Passed");
		}
		else {
			System.out.println("Assertion Failed");
				
		}*/
	}
	
	//this method counts the number of rows of days displayed in the forecast and validates for expected
	public void numberOfRowsDisplayed(WebDriver driver)
	{
		List<WebElement> rowsOfDays = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div"));
		System.out.println("Number of Rows displayed is: "+rowsOfDays.size());
		Assert.assertEquals(rowsOfDays.size(), 5);
	}
	
	//a generic method vod validating expected vs actual
	public void expectedVsActual(String expected, String actual) {
		Assert.assertTrue(actual.equalsIgnoreCase(expected), "Expectations not met");
	}

}
