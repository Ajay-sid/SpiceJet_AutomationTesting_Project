package test;

import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.LandingPage;

public class SearchingFlight extends ProjectSpecification {

	
	
	@Test
		public void searchingFlightOneWay() {
			
		LandingPage lp =new LandingPage(driver);
		getElementFormList(lp.getTripMode(),"One Way").click();
		sendKeys(lp.getDepFrom(),"MAA");
		sendKeys(lp.getDepTo(), "DEL");
		//date formatt is day-MonthName-Year
		lp.departureDate("19-May-2024");
			
			
		}
		@Test
		public void searchingFlightRoundTrip() {
			
			LandingPage lp =new LandingPage(driver);
			getElementFormList(lp.getTripMode(),"Round Trip").click();
			sendKeys(lp.getDepFrom(),"MAA");
			sendKeys(lp.getDepTo(), "DEL");
			//date formatt is day-MonthName-Year
			lp.departureDate("19-May-2024");
			lp.departureDate("30-May-2024");
				
				
			}
		
}
