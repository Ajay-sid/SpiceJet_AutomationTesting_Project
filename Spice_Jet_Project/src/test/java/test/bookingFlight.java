package test;

import base.ProjectSpecification;
import pages.FlightsPage;
import pages.LandingPage;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class bookingFlight extends ProjectSpecification {

	LandingPage lp;
	FlightsPage fp;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void launchbrowser1(String browser,String url) {
		 
		launch(browser, url);
		System.out.println("browser Launched - before class");
		
	}
	
	@Override
	@BeforeMethod
	@Parameters({"browser","url"})
	public void launchBrowser(String browser,String url) {
		 
		System.out.println("Before Method Overidden");
		
	}
	
	
	@Test
	public void searchingFlightOneWay() {
		
		 lp =new LandingPage(driver);
		getElementFormList(lp.getTripMode(),"One Way").click();
		sendKeys(lp.getDepFrom(),"MAA");
		sendKeys(lp.getDepTo(), "DEL");
		//date formatt is day-MonthName-Year
		fp=lp.departureDate("19-May-2024").clickSearchFlight();
		
		}
	
	
	
	@Test(dependsOnMethods = ("searchingFlightOneWay"))
	public void bookindFlight() {
		
		fp.selectAnyFlight().clickContiueWithFlight();
		
		
		
	}
	
	@Test(dependsOnMethods= {"searchingFlightOneWay","bookindFlight"})
	public void fillingContactAndPassangerDetails() {
	
		fp.clickContactTitle().selectContactTitle("Mr").contactFirstname("Sidick").contactLastname("Desmond")
			.contactMobileNum("9876543211").contactEmail("randon@gmail.con").clickPassangerTitle()
			
			.selectPassangerTitle("Mr").passangerFirstName("Sidick").passangerLastName("DesMond").clickContiueWithPassanger();
		
		
		
		
		
		
	}
	@Override
	@AfterMethod()
	public void tear(ITestResult result){

	}
	
	
	@AfterClass
	public void tear() {
		close();
	}
	
	
	
	
	
	
	
	
	
	
	
}
