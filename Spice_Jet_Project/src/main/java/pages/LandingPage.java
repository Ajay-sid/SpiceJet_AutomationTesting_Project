package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends AbstractComponents {

	@FindBy(xpath="//div[@class='css-76zvg2 r-homxoj r-ubezar r-1ozqkpa']")
	List<WebElement> tripMode;
	
	@FindBy(xpath="//div[@data-testid='home-page-flight-cta']")
	WebElement searchFlight;
	

	@FindBy(xpath="//div[@data-testid='to-testID-origin']//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']")
	WebElement depFrom;
	
	@FindBy(xpath="//div[@data-testid='to-testID-destination']//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']")
	WebElement depTo;
	
	
	
	
	
	public LandingPage(WebDriver driver) {
		super(driver);
	}
	
	
	public LandingPage departureDate(String date) {
		String [] d=date.split("-");
		String day = d[0];
		String month = d[1];
		String year =d[2];
		
		List<WebElement> depmonth =driver.findElements(By.xpath("//div[@data-testid='undefined-month-"+month+"-"+year+"']//div[not(contains(@data-testid,'undefined-calendar-day-undefined'))]//div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41']"));
		WebElement ele =getElementFormList(depmonth, day);
		actionElementClick(ele);
		return this;
	
	}
	
	public FlightsPage clickSearchFlight() {
		elementClick(searchFlight);
		return new FlightsPage(driver);
	}
	

	public List<WebElement> getTripMode() {
		return tripMode;
	}


	public WebElement getDepFrom() {
		return depFrom;
	}


	public WebElement getDepTo() {
		return depTo;
	}

	
	
	
	
	
}
