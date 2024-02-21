package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class SignUp extends AbstractComponents{
	
	//title drop down
	@FindBy(xpath="//select[@class='form-control form-select ']")
	WebElement titleDropDown;
	
	@FindBy(id="first_name")
	WebElement firstAndMiddleName;
	
	@FindBy(id="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//select[@class='form-control form-select']")
	WebElement contryDropDown;
//-----------date----------------------------//	
	@FindBy(id="dobDate")
	WebElement dateOfBirthSelector;
	
	
	@FindBy(xpath="//select[@class='react-datepicker__year-select']//option")
	List<WebElement> year;
	
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']")
	WebElement month;
	
	
	@FindBy(xpath="//div[@class='react-datepicker__month']/div/div")
	List<WebElement> days;
	
//------------------------------------------------//	
	
	
	
	@FindBy(xpath="//input[@class=' form-control' and @placeholder='+91 01234 56789']")
	WebElement mobileNumber;
	
	@FindBy(id="email_id")
	WebElement emailId;
	
	@FindBy(id="new-password")
	WebElement password;
	
	
	@FindBy(id="c-password")
	WebElement confirmPassword;
	
	@FindBy(id="defaultCheck1")
	WebElement acceptTermsCheckBox;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submitButton;
	
	
	
	
	public SignUp(WebDriver driver) {
		super(driver);
	}
	
	public SignUp title(String option) {
		selectDropDownUsingText(titleDropDown, option);	
		return this;
	}
	
	public SignUp firstAndMiddleNameInput(String fname) {
		sendKeys(firstAndMiddleName, fname);
		return this;
	}
	
	public SignUp lastNameInput(String lname) {
		sendKeys(lastName, lname);
		return this;
		
	}
	
	public SignUp contry(String option) {
		//selectDropDownUsingText(contryDropDown, option+" ");
		contryDropDown.click();
		List<WebElement> countr= driver.findElements(By.xpath("//select[@class='form-control form-select']//option"));
		countr.stream().filter(m->m.getText().equals(option)).findFirst().get().click();
		return this;
	}
	
	public SignUp dateOfBirth(String date) throws Exception {
		dateOfBirthSelector.click();
		String d[] = dateChecker(date);
		getElementFormList(year, d[2]).click();
		selectDropDownUsingText(month, d[1]);
		days.stream().filter(m->m.getAttribute("aria-label")
				.contains(d[1])).filter(m->m.getText().equals(String.valueOf(Integer.valueOf(d[0])))).findFirst().get().click();
		return this;
		
	}
	
	public SignUp moblieNumberInput(String num) throws InterruptedException {
		
		sendKeys(mobileNumber, num);
		Thread.sleep(2000);
		return this;
	}
	
	public SignUp emailInput(String email) throws InterruptedException {
		
		sendKeys(emailId, email);
		Thread.sleep(2000);
		return this;
	}
	public SignUp passwordInput(String pass) {
		sendKeys(password, pass);
		return this;
	}
	public SignUp conformPasswordInput(String conPass) {
		sendKeys(confirmPassword, conPass);
		return this;
	}
	
	public SignUp acceptTerms() {
	elementClick(acceptTermsCheckBox);
	return this;
	}
	

}
