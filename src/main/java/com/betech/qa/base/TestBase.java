package com.betech.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;






public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties Prop;
	
	public TestBase() throws IOException 
	{
		try 
		{
			//********************************MUST READ******************************************************
		//the path of this config.properties file will be changed when you will import the project in your system
		//so pass new path here 
		// to find path follow these steps
		//open src/main/java
		//open com.betech.qa.config
		//right click on config.properties
		//select properties
		//copy the path
			//**************************************************************************************************	
			
		Prop = new Properties();
		FileInputStream io = new FileInputStream ("C:\\Users\\muzammil.riaz\\eclipse-workspace\\betech\\src\\main\\java\\com\\betech\\qa\\config\\config.properties" );
		Prop.load(io);	
		}
		catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		}
		catch (IOException e2)
		{
			
			e2.printStackTrace();
		}
	}
	public static void initialization () throws IOException  
	{
		String browsername = Prop.getProperty("browser");
		if (browsername.contentEquals("chrome"))
		{
			//**************MUST READ**********************
			//give address of your own chromedriver.exe file
			//**********************************************
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\muzammil.riaz\\Desktop\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		else if (browsername.contentEquals("firefox"))
		{
			//**************MUST READ**********************
			//give address of your own geckodriver.exe file
			//**********************************************
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\muzammil.riaz\\Desktop\\geckodriver.exe");
			driver= new FirefoxDriver();
			
		}
		
		else if (browsername.contentEquals("IE"))
		{
			//**************MUST READ**********************
			//give address of your own IEDriverServer.exe file
			//**********************************************
			
			System.setProperty("webdriver.ie.driver", "C:\\Users\\muzammil.riaz\\Desktop\\IEDriverServer.exe"); 
			driver = new InternetExplorerDriver();
		}
	
		
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(com.betech.qa.util.TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(com.betech.qa.util.TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(Prop.getProperty("url"));
	
	}	

}
