package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightsPage extends AbstractComponents{
	//------------------Flights info----------------------------------//
	@FindBy(xpath="//div[@class='css-1dbjc4n r-14lw9ot r-3aj1re r-18u37iz']")
	List<WebElement> flights;
	
	@FindBy(xpath="//div[@data-testid='continue-search-page-cta']")
	WebElement continueWithFlight;
	
	//-------------------Contact Info---------------------------//
	
	
	@FindBy(xpath="//div[@data-testid='title-contact-detail-card']")
	WebElement contactTitleDropDown;
	
	@FindBy(xpath="//div[@class='css-76zvg2 r-homxoj r-poiln3 r-ubezar']")
	List<WebElement> contactTitles;
	
	@FindBy(xpath="//input[@data-testid='first-inputbox-contact-details']")
	WebElement contactFirstName;
	
	@FindBy(xpath="//input[@data-testid='last-inputbox-contact-details']")
	WebElement contactLastName;
	
	@FindBy(xpath="//input[@data-testid='contact-number-input-box']")
	WebElement contactMobileNum;
	
	@FindBy(xpath="//input[@data-testid='emailAddress-inputbox-contact-details']")
	WebElement contactEmail;
	
//----------------------------Passanger info-----------------------------------
	
	@FindBy(xpath="//div[@data-testid=\"traveller-info-continue-cta\"]")
	WebElement passangerContinue;
	
	@FindBy(xpath="//input[@data-testid='traveller-0-first-traveller-info-input-box']")
	WebElement passangerFirstName;
	
	@FindBy(xpath="//input[@data-testid=\"traveller-0-last-traveller-info-input-box\"]")
	WebElement passangerLastName;
	
	@FindBy(xpath="//div[@data-testid=\"traveller-0-title-field\"]")
	WebElement passangerTitleDropdown;
	
	@FindBy(xpath="//div[@class=\"css-76zvg2 r-homxoj r-poiln3 r-ubezar\"]")
	List<WebElement> passangerTitles;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public FlightsPage(WebDriver driver) {
		super(driver);
	}
	
	
	//filghts getters
	public List<WebElement> getFlights() {
		return flights;
	}

	
	public FlightsPage selectAnyFlight() {
		WebElement randomFlight = flights.stream().findAny().get();
		elementClick(randomFlight);
		return this;
	}


	public FlightsPage clickContiueWithFlight() {
		elementClick(continueWithFlight);
		return this;
	}
 
	public FlightsPage clickContactTitle() {
		elementClick(contactTitleDropDown);
		return this;
	}
	
	public FlightsPage selectContactTitle(String title) {
	elementClick(getElementFormList(contactTitles, title));	
	return this;
	}
	
	public FlightsPage contactFirstname(String name) {
		sendKeys(contactFirstName, name);
		return this;
	}
	
	public FlightsPage contactLastname(String name) {
		sendKeys(contactLastName, name);
		return this;
	}
	public FlightsPage contactMobileNum(String num) {
		sendKeys(contactMobileNum, num);
		return this;
	}
	public FlightsPage contactEmail(String email) {
		sendKeys(contactEmail, email);
		return this;
	}
	
	//------------------------passanger methods------------------------------------
	
	public FlightsPage clickPassangerTitle() {
		elementClick(passangerTitleDropdown);
		return this;
	}
	
	
	public FlightsPage passangerFirstName(String name) {
		sendKeys(passangerFirstName, name);
		return this;
	}
	
	public FlightsPage passangerLastName(String name) {
		sendKeys(passangerLastName, name);
		return this;
	}
	
	public FlightsPage selectPassangerTitle(String title) {
	elementClick(getElementFormList(passangerTitles, title));	
		return this;
	}
	
	public FlightsPage clickContiueWithPassanger() {
		elementClick(passangerContinue);
		return this;
	}
	
}
