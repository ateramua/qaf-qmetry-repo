package com.qmetry.qaf.delta.steps;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qmetry.qaf.Utility.Utilities;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.AbstractTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import com.qmetry.qaf.delta.page.BookingPage;

import ch.qos.logback.classic.pattern.Util;


public class OneWayBookingSteps {
	BookingPage bookingpage = new BookingPage();
	Utilities util = new Utilities();
	/*
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	*/
	
	/*
	@Before
	public void setup() {
		
	
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		
		
	}
*/





	@QAFTestStep(description = "User is on Delta Booking Page")
	public void navigateToDeltaBookingPage() {
		//test = extent.createTest("Validate user can navigate to Delta Booking Page");
		BookingPage bookingpage = new BookingPage();
		bookingpage.openPage(null, "");
		Validator.assertTrue(bookingpage.getBook().isDisplayed(), "User failed to navigate to Booking Page", "User successfully navigated to booking page");
		
	}

//	@QAFTestStep(description = "User clicks on From Link")
//	public void clickOnFromLink(){
//		//test = extent.createTest("Verify From Link");
//		BookingPage bookingpage = new BookingPage();
//		Reporter.log(bookingpage.getFrom().isEnabled() + " is enabled ");
//		Reporter.log(bookingpage.getFrom().isDisplayed()+ " is displayed");
//		Reporter.log(bookingpage.getFrom().isPresent() + " is present");
//		
//		Validator.assertTrue(bookingpage.getAirPortSearchTextBox().isPresent(), "Script failed to click on From Link", "Script successfully clicked on From Link");
		
//		if(bookingpage.getAirPortSearchTextBox().isPresent()) {
//			System.out.println("USER SUCCESSFULLY CLICK ON FROM LINK.I HOPE YOU CAN SEE THIS MESSAGE");
//			//test.log(Status.PASS,"Script successfully clicked on From Link");
//		} else {
//			//test.log(Status.FAIL,"Script failed to click on From Link");
//		}
//		
			
		
	
//	}
	@QAFTestStep(description = "User clicks on From Test")
	public void clickTest(){
		bookingpage.getFrom().waitForPresent(10000);
		Reporter.log(bookingpage.getFrom().isEnabled() + " is enabled ");
		Reporter.log(bookingpage.getFrom().isDisplayed()+ " is displayed");
		Reporter.log(bookingpage.getFrom().isPresent() + " is present");
	}
	
	@QAFTestStep(description = "User clicks on From Link")
	public void userClickOnFromLink(){
		util.scrollAndClick(bookingpage.getDriver(), bookingpage.getFrom());
		bookingpage.getFrom().waitForPresent(10000);
		bookingpage.getFrom().click();
		bookingpage.getAirPortSearchTextBox().waitForPresent(10000);
		Validator.assertTrue(bookingpage.getAirPortSearchTextBox().isPresent(), "Script failed to click on From Link", "Script successfully clicked on From Link");
	}

	@QAFTestStep(description = "User enters departure airport {dAirPort}")
	public void clickOnFromLink(String dAirPort) {
		//test = extent.createTest("Validate User can click on From Link");

	}

	@QAFTestStep(description = "User selects departure airport from search results")
	public void selectDepartureAirportFromList() {
		//test = extent.createTest("Validate user can select departure airport from the airport List");

	}

	@QAFTestStep(description = "User clicks on To link")
	public void clickOnToLink() {
		//test = extent.createTest("Validate user can click on 'To' link");

	}

	@QAFTestStep(description = "User enters destination airport {aAirPort}")
	public void enterDestinationAirport(String aAirPort) {
		//test = extent.createTest("Validate user can enter destination airport");

	}

	@QAFTestStep(description = "User selects destination airport from search results")
	public void selectDestinationAirportFromList() {
		//test = extent.createTest("Validate user can select destination airport from the list");

	}

	@QAFTestStep(description = "User selects trip type {trip}")
	public void selectOneWayTrip(String trip) throws InterruptedException {
//		bookingpage.getButtonUnderstand().waitForPresent(10000);
//		Reporter.log(bookingpage.getButtonUnderstand().isDisplayed()+" Is 'I understand' button is displayed");
//		Utilities.switchToNewTab(bookingpage.getDriver());
//		bookingpage.getButtonUnderstand().click();
		
		//bookingpage.getTrip().waitForPresent(10000);
		//Utilities.scrollAndClick(bookingpage.getDriver(), bookingpage.getTrip());
//		bookingpage.getTxtBoxTrip().waitForPresent(10000);
//		Reporter.log(bookingpage.getTxtBoxTrip().isDisplayed() + " Is the txtbox trip present");
		bookingpage.getTxtBoxTrip().click();
		
		List<WebElement> ddList = bookingpage.getDropDownTrip().findElements(By.xpath(trip));
		Reporter.log(ddList.size() + " what is the size of the dropdown list *********");
		for(WebElement ele:ddList) {
			if(ele.getText().trim().equalsIgnoreCase(trip)) {
				ele.click();
				Reporter.log(trip + "Element selected is");
				Validator.assertTrue(bookingpage.getDropDownTrip().getText().trim().equalsIgnoreCase(trip), "User failed to select " + trip, "User successfully selected "+ trip);
			}
		}
		//Utilities.selectFromDropdown(bookingpage.getDropDownTrip(), trip);
		Reporter.log(bookingpage.getDropDownTrip().getAttribute("value")+" Value selected for dropdown is '?'");
		Thread.sleep(10000);
//		bookingpage.getOneWay().click();
//		Validator.assertTrue(bookingpage.getButtonTrip().getText().trim().equalsIgnoreCase(trip), "User failed to select " + trip, "User successfully selected "+trip);
		
	}
	
	@QAFTestStep(description = "User clicks on Trip type dropdown")
	public void selectTripTypee() {
//		Reporter.log(bookingpage.getButtonUnderstand().isDisplayed()+ " Button is displayed");
//		bookingpage.getButtonUnderstand().click();
		bookingpage.getTxtBoxTrip().click();
	}
	

	@QAFTestStep(description = "User selects departure date '02/05/2022'")
	public void selectDepartureDate() {

	}

	@QAFTestStep(description = "User selects number of passenger '2'")
	public void selectNumberOfPassenger() {

	}

	@QAFTestStep(description = "User clicks on search button")
	public void clickOnSearchButton() {

	}

	@QAFTestStep(description = "list of flights should generate")
	public void generateListOfFlights() {

	}



}
