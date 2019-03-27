package util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel 
{
	//declaring global workbook and sheet variables to be able to access the test data saved within
	Workbook wb;
	Sheet s1;
	String browserName, url, city;
	
	//Method for linking with the Workbook/sheet
	public void openWorkbook() throws Exception
	{
		String projectPath = System.getProperty("user.dir")+"/src/test/resources/MiscellaneousDataHouse.xlsx";
		FileInputStream fis = new FileInputStream(projectPath);
		wb = WorkbookFactory.create(fis);
		s1 = wb.getSheet("TestData4WeatherForecase");	
	}
	//method for fetching browser data from the workbook
	public String getBrowserName()
	{
		return browserName = s1.getRow(1).getCell(1).getStringCellValue();
	}
	//method for fetching url to hosted application 
	public String getUrl()
	{
		return url = s1.getRow(2).getCell(1).getStringCellValue();
	}
	
	//method for fetching city for forecast
	public String getCity()
	{
		return city = s1.getRow(3).getCell(1).getStringCellValue();
	}
}
