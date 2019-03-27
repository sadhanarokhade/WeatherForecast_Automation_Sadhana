/*package trials;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TrialMethods {
	
	static Workbook wb;
	static Sheet s1;
	static String browserName;
	public static void main(String[] args) throws Exception
	{	
		
		
		String Projectpath = System.getProperty("user.dir")+"/src/test/resources/MiscellaneousDataHouse.xlsx";
		
		System.out.println(Projectpath);
	
		
			FileInputStream fis = new FileInputStream(Projectpath);
			wb = WorkbookFactory.create(fis);
			s1 = wb.getSheet("TestData4WeatherForecase");	

			browserName = s1.getRow(2).getCell(1).getStringCellValue();
			
			System.out.println(browserName);
	
	}

	public  void testing() {
		System.out.println("creating Soft Assert class");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("Sadhana", "Deepak","Fail adi enappa");
		Assert.assertEquals("Sadhana", "Deepak","Assertion message");
		
	}
	
	@Test
	public void testingme() {
		testing();
	}


}
*/