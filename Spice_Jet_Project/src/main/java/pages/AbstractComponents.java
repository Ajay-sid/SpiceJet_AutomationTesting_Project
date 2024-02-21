package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecification;

public class AbstractComponents extends ProjectSpecification{
	
	//Loading icon
	@FindBy(xpath="//div[@data-testid='app-loader']")
	WebElement loadingIcon;
	

	//signUp Link
	@FindBy(xpath="//div[text()='Signup']")
	WebElement signUpLink;
	
	//Login Link
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginLink;
	
	//------------------Login Window------------------------------
	@FindBy(xpath="//input[@data-testid='user-mobileno-input-box']")
	WebElement loginMobileNumorEmail;
	
	@FindBy(xpath="//input[@data-testid='password-input-box-cta']")
	WebElement loginPassword;
	
	@FindBy(xpath="//div[@data-testid='login-cta']")
	WebElement loginButton;
	
	

	@FindBy(xpath="//div[@class='css-1dbjc4n r-18u37iz r-1w6e6rj r-p1pxzi']//div[@class='css-76zvg2 r-homxoj r-ubezar r-1ozqkpa']")
	List<WebElement> loginRadioButton;
	
	//--------------------------------------------------------------	
	
	
	
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public SignUp goToSignUp() {
		elementClick(signUpLink);
		for(String s:getWindowHandles()) {
			switchWindow(s);
		}
		return new SignUp(driver);
		
	}
	
	public AbstractComponents login() {
		elementClick(loginLink);
		return this;
	}
	
	public AbstractComponents loginMobileorEmailInput(String num) {
		sendKeys(loginMobileNumorEmail, num);
		return this;
	}

	public AbstractComponents loginPasswordInput(String pass) {
		sendKeys(loginPassword, pass);
		return this;
	}
	
	public AbstractComponents selectLoginRadioButton(String str) {
	 elementClick(getElementFormList(loginRadioButton, str));
		return this;
		
	}
	
	public AbstractComponents clickLoginButton() {
		elementClick(loginButton);
		return this;
	}
	
	
	public WebElement getLoadingIcon() {
		return loadingIcon;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	
}
