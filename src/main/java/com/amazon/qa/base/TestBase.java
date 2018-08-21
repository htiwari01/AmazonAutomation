package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.util.TestUtil;

public class TestBase {
	
	WebDriverWait wait;
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\htiwari\\Desktop\\Himanshu\\Selenium\\AmazonAutomationTest\\src"
					+ "\\main\\java\\com\\amazon\\qa\\config\\config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}		
	}	
	public void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			 System.setProperty("webdriver.chrome.driver","C:\\Users\\htiwari\\Desktop\\Himanshu\\Selenium\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
		}else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\htiwari\\Desktop\\Himanshu\\Selenium\\WebDrivers\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	

}
