package base;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utility.UtilityClass;

public class ProjectSpecification extends UtilityClass implements ITestListener{
	
	
	
//	//@Override
//	public void onTestFailure(ITestResult result) {
//	captureScreenshot(result.getMethod().getMethodName()+".jpg");
//		
//		
//	}
	//Screenshot code for failed testcases
	public void captureScreenshot(String fileName)  {
		try {
			//date
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd_MM_yyyy_HHmmss");
			screenShotFolderName = myDateObj.format(myFormatObj);
			
			String formattedDate = myDateObj.format(myFormatObj);
			System.out.println("After formatting: " + formattedDate);
			//screenshot code
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destination = new File("./ScreenShots/"+screenShotFolderName+"/"+fileName);
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot saved successfully");
		} catch (Exception e) {
			System.out.println("Screenshot Failed!");
			System.out.println(e.getMessage());
		}
	}
	

	//@BeforeTest()
	public void propertiesLoad() throws IOException {
		
		 file = new File("src/main/java/property/data.properties");
		 prop = new Properties();
		 fis = new FileInputStream(file);
		 prop.load(fis);
		 System.out.println("Property Loaded");
	}
	
	@DataProvider(name="getSingleArrayData")
	public String[] getSingleData() throws IOException {
	return ReadSingle(excelFile) ;
	
	}

	@DataProvider(name="getData")
	public String[][] getData() throws IOException {

		return  ReadExcel(excelFile);
		
		
	}
	
	
	
	
	
	
	
	
	@Parameters({"browser","url"})
	@BeforeMethod()
	public void launchBrowser(String browser,String url) {
		 
		launch(browser, url);
		System.out.println("browser Launched - before Method");
		
	}
	
	
	
	
	
	
	
	@AfterMethod()
	public void tear(ITestResult result){
//		if(result.getStatus()==ITestResult.FAILURE) {
//			captureScreenshot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".jpg");
//		}
	close();
	}
	
	

	
}
