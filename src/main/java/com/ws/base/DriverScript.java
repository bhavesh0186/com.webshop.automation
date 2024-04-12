package com.ws.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * Class: DriverScripts-This calass is responsible to manage driver across the project.
 */


public class DriverScript {
	/*
	 * public driver reference which can be access across the project
	 * prop global variable to access across prject
	 */
	public static WebDriver driver;
	static Properties prop;
	
	
/*
 * This constructor is responisble to load property file.	public DriverScript() {
 */
	{
		
		try {
			
			File file = new File("./src/test/resources/config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Unable to load the propeties file");
			e.printStackTrace();
			
		}
		
		
	}
	/*
	 * This method used to launch the browser and apply all the wait settings
	 * navigate to the application
	 */
	
	public void initApplication() {
		String browser = prop.getProperty("browser");
		
		if(browser.trim().equalsIgnoreCase("chrome"))
		{
			System.out.println("Browser in use: "+browser);
			driver = new ChromeDriver();
		}
		else if(browser.trim().equalsIgnoreCase("firefox"))
		{
			System.out.println("Browser in use: "+browser);
			driver = new FirefoxDriver();
		} 
		else if(browser.trim().equalsIgnoreCase("edge"))
		{
			System.out.println("Browser in use: "+browser);
			driver = new EdgeDriver();
		}
		else 
		{
			System.out.println("Unsupported Browser type! Please check the config file");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		
		getAppurl();
	}
	
	public static void getAppurl()
	{
	 String url = prop.getProperty("url");
	 driver.get(url);
	}
	
	public static void quitDriver()
	{
		driver.quit();
	}
	
}

