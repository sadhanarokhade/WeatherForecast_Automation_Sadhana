# WeatherForecast_Automation_Sadhana
 #
## README ##

Project Title:
Automation framework for 'WeatherForecast' Application testing, created for TEKsystems

Technology/Framework Used:
Technology Used : Java, TestNG, Selenium WebDriver, ApachePOI, Maven
Framework Used: Hybrid - Page Object Model + Data Driven
Features:
This project will help WeatherForecast company to test their application for functional/ features using automation to reduce the manual testing time.

Installation/pre-requisites:
Download Java 1.8 and configure the paths in system
Download Eclipse - Oxygen and install in system and create a workspace
Integrate jars/install add ons - Maven, TestNG, ApachePOI
Download/clone the Project folder zip from GIT and extract to the workspace created above
Open the project in Eclipse IDE using File->Open File by navigating to the project folder
Install the application under test in system and the npm must be hosted on localhost port, make note, and running.
copy the localhost URL of application to the excel sheet found in the resources folder in the project.
integrate all the jars referenced in the project.

How to use files in resources:
Locate an Excel workbook with name: 'MiscellaneousDataHouse.xlsx' under the path: "/.../com.TekSys/src/test/resources"
Edit the URL and provide the accurate URL/port of the Weather Forecast application hosted
Provide the choice of browser to be selected for test execution, choosing from the options
Provide the valid City name from the options to be tested with
close the workbook after changes done

Test execution:
Right click on the Project and click on 'Refresh'
Locate the XML file with name: 'testng.xml' at the bottom of the project
Right Click and 'Run As' -> "..TestNG Suite.."

