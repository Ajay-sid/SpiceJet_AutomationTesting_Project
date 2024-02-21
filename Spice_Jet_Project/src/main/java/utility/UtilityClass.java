package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//BestBuy
public class UtilityClass {
	public WebDriver driver;
	public File file;
	public Properties prop;
	public FileInputStream fis;
	public String excelFile;
	public Actions action;
	public String screenShotFolderName;
	
	
	

	// Launching URL
	public void launch(String browser, String url) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;	
		default:
			System.err.println("Invalid browser name");
			break;
		}
		
		driver.manage().window().maximize();
		try {
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		}catch(Exception e) {
			
		}
		
	}
	
	public String urlCheck(String link) throws IOException {
		
		
		try {
			HttpURLConnection huc =(HttpURLConnection)(new URL(link).openConnection());
			huc.connect();
			int code =huc.getResponseCode();
			System.out.println(code);
			if(code>=400) {
				return "Link is Broken";
			}else {
				return "Link is valid";
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return e.getMessage();
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return e.getMessage();
		}
		
		
		
	}
	
	public String [] ReadSingle(String excelname) throws IOException {
			
		XSSFWorkbook book = new XSSFWorkbook("allData\\"+excelname+".xlsx");
			XSSFSheet sheet = book.getSheetAt(0);

			int rowCount = sheet.getLastRowNum();
			String[] data =new String[rowCount];
			for (int i=1;i<=rowCount;i++) {
				XSSFRow row = sheet.getRow(i);
				XSSFCell cell = row.getCell(0);
				data[i-1]=cell.getStringCellValue();
				
			}
			return data;
			
		
	}
	
	
		
	// Excel data to array - Appache POI
	public static String[][] ReadExcel(String excelname) throws IOException {

		XSSFWorkbook book = new XSSFWorkbook("allData\\" + excelname + ".xlsx");

		XSSFSheet sheet = book.getSheetAt(0);

		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
//		System.out.println(rowCount);
//		System.out.println(colCount);

		String[][] data = new String[rowCount][colCount];

		for (int i = 1; i <= rowCount; i++) {

			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < colCount; j++) {

				XSSFCell cell = row.getCell(j);

				data[i - 1][j] = cell.getStringCellValue();
			}
		}
		book.close();
		return data;

	}
	
	
	
	//close active window
	public void close() {

		driver.close();

	}
	
	
	//close entire browser
	public void quit() {
		driver.quit();
	}
	
	//Click an element
	public void elementClick(WebElement element) {
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		}catch(WebDriverException e){
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			
		}
		
	}
	public WebElement getElementFormList(List<WebElement> elements,String str) {
//		
		return  elements.stream().filter(m->m.getText().equalsIgnoreCase(str)).findFirst().get();
	

	}
	
	
	//SendKeys
	public void sendKeys(WebElement element,String string) {
		element.sendKeys(string,Keys.TAB);
		
		
	}
	public void tabOutofTextField(WebElement element) {
		element.sendKeys(Keys.TAB);
		
		
	}
	
	//------------------------------------switch to--------------------------------//
	public void switchWindow(String window) {
		driver.switchTo().window(window);
	}
	
	//Getting page Title
	public String getPageTitle() {
        return driver.getTitle();
    }
	
	public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
	

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void goForward() {
        driver.navigate().forward();
    }
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }
    
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }
    
    //-----------------------------Actions--------------------------------//
    
    public void actionElementClick(WebElement element) {
    	action = new Actions(driver);
    	action.moveToElement(element).click().build().perform();	
    }
    
    public void scrollElement(WebElement element) {
    	action = new Actions(driver);
    	action.scrollToElement(element).perform();
    }
    public void clickElementInNewWindow(WebElement element) {
    	action=new Actions(driver);
		action.moveToElement(element).keyDown(Keys.CONTROL).click().build().perform();
    }
 
    
    
    
    //-----------------------Select dropdowns-----------------------------//
    public void selectDropDownUsingText(WebElement element,String option) {
    	Select select = new Select(element);
    	select.selectByVisibleText(option);
    	
    }
    public void selectDropDownUsingValue(WebElement element,String option) {
    	Select select = new Select(element);
    	select.selectByValue(option);
    	
    }
    
    
    //-----------------------------Waits---------------------------//
    
    public void waitTillVisbilityofElement(WebElement element) {
    	
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    		wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public void waitTillInVisbilityofElement(WebElement element) {
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        		wait.until(ExpectedConditions.invisibilityOf(element));
        }
    
  
    
    //------------date -----------------------------
    
	public String[] dateChecker(String date) throws Exception {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MMMM/yyyy");
		try {
			formatter.setLenient(false);
			String strDate = formatter.format(formatter.parse(date));
			System.out.println(strDate);
			String[] strArray = strDate.split("/");
			System.out.println(Arrays.toString(strArray));
			return strArray;
		} catch (Exception e) {
			throw new Exception("Invalid date formatt");
		}
	}
    
    
}
