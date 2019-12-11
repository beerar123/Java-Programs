package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class google {
	
	public static void main(String [] args) throws Exception{
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\beerar\\Downloads\\Automation_2019\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	// searching for user data file
driver.get("https://www.flipkart.com/");

}
}