package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.ProjectSpecification;
import pages.LandingPage;
import pages.SignUp;

public class SignupTest extends ProjectSpecification {

	
	
	@Test 
	public void signUpFunctionality() throws Exception {
		//date format should be 01/JAN/1990
		String parent=getWindowHandle();
		SignUp sp = new LandingPage(driver).goToSignUp().title("Mr").firstAndMiddleNameInput("Test")
				.lastNameInput("Jet").contry("India").dateOfBirth("6/FEB/1999").moblieNumberInput("8610041165")
				.emailInput("Testingpurpose6299@gmail.com").passwordInput("Test@123").conformPasswordInput("Test@123")
				.acceptTerms();
				close();
				switchWindow(parent);
				
	}
	
	@Test
	public void login() {
	LandingPage lp =	new LandingPage(driver);
	lp.login();
	waitTillVisbilityofElement(lp.getLoginButton());
	lp.selectLoginRadioButton("Email")
	.loginMobileorEmailInput("Testingpurpose6299@gmail.com")
	.loginPasswordInput("Test@123").clickLoginButton();
	
	}
	
	
	
	
	
	
	
	
	
}
