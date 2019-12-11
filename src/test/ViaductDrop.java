package test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Lib.Utility4;

public class ViaductDrop {
	
//declaring the public static variable
	 static String sFileName ="\\USHOUHOME01\\beerar\\workspace\\Raj\\Automation_2019\\src\\test\\ViaductDroppinglist.xlsx" ;
	 static String sSheetName ="Sheet1";
	 static String sRunMode;
	 
//main method
public static void main(String[] args) throws Exception {
{    
	
//browser properties
System.setProperty("webdriver.chrome.driver", "C:\\Users\\beerar\\Downloads\\Automation_2019\\chromedriver.exe");
WebDriver driver = new ChromeDriver(); 
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//loading the excel file
try {
Utility4.setExcelFile("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\ViaductDroppinglist.xlsx", "Sheet1");}
catch (Exception e){System.out.println("invalid excel file");
	}

//navigating to Viaduct UAT instance from excel file
driver.get(Utility4.getCellData(sFileName, sSheetName, 1, 7));
Thread.sleep(3000);

//login details from excel file
driver.findElement(By.name("SWEUserName")).sendKeys(Utility4.getCellData(sFileName, sSheetName, 1, 5));
driver.findElement(By.name("SWEPassword")).sendKeys(Utility4.getCellData(sFileName, sSheetName, 1, 6));
driver.findElement(By.id("s_swepi_22")).click();
Thread.sleep(3000);

//browser refresh
driver.navigate().refresh();
Thread.sleep(5000);

//click on communication tab

WebDriverWait wait2 = new WebDriverWait(driver, 10);
wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-tabindex='tabScreen10']"))).click();;

//Getting total project or communications from sheet1 that need to drop
String sSheet1 = "Sheet1";
int totalNoOfRows = Utility4.rowcount(sSheet1);
System.out.println(+totalNoOfRows);

for (int row = 1; row <= totalNoOfRows; row++) 
{
//setting and verifying the Run mode
	
sRunMode=Utility4.getCellData(sFileName, sSheetName, row, 2);
//checking RunMode status that need to drop

if(sRunMode.equals("Yes")) {
	
//click on query
driver.findElement(By.xpath("//*[@id='s_1_1_8_0_Ctrl']")).click();

//Entering the communication name from excel file

driver.findElement(By.xpath("//table[@id='s_1_l']/tbody/tr[2]/td[2]/input")).sendKeys(Utility4.getCellData(sFileName, sSheetName, row, 0));

//click on Go button
driver.findElement(By.xpath("//*[@id='s_1_1_5_0_Ctrl']")).click();

//click on show active
driver.findElement(By.xpath("//*[@id='s_3_1_3_0_Ctrl']")).click();

//Getting the sheet name
System.out.println(Utility4.getCellData(sFileName,sSheetName,row, 1));
String str = Utility4.getCellData(sFileName,sSheetName,row, 1);
System.out.println("account sheetname"+str);

//Knowing the account numbers for that communication instance 
int totalNoOfRows1 = Utility4.rowcount(str);
	
for(int Arow=0;Arow<=totalNoOfRows1;Arow++)
			
{

//click on act query
driver.findElement(By.xpath("//button[@id='s_2_1_11_0_Ctrl']")).click();

//Enter the account number or communication name from excel file
driver.findElement(By.xpath("//input[@id='1_Account_Number']")).sendKeys(Utility4.getCellData(sFileName,str,Arow, 0));

//click on Go button
driver.findElement(By.xpath("//*[@id='s_2_1_8_0_Ctrl']")).click();

//click on communication instance
driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[2]/td[9]/a")).click();


Thread.sleep(5000);
//click on Adhoc submit
driver.findElement(By.xpath("//button[@aria-label='Communication Maintenance:Adhoc Submit']")).click();

Thread.sleep(5000);
//Handling the alert window
Alert promptAlert = driver.switchTo().alert();

//Enter the given Effective date i.e Quarterly or Monthly dates
promptAlert.sendKeys(Utility4.getCellData(sFileName,sSheetName,row, 3));

promptAlert.accept();
Thread.sleep(8000);
Alert promptAlert1 = driver.switchTo().alert();
Thread.sleep(5000);
promptAlert1.accept();

//Return back to communication tab
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id='siebui-threadbar']/li[1]/span/a")).click();
Thread.sleep(5000);


}}
//these communications which or depended on communication instances names no account numbers 
	else if (sRunMode.equals("Type2")) {
		
		//Click on Query button 
		driver.findElement(By.xpath("//*[@id='s_1_1_8_0_Ctrl']")).click();
		
		//Enter the Communication name
		driver.findElement(By.xpath("//table[@id='s_1_l']/tbody/tr[2]/td[2]/input")).sendKeys(Utility4.getCellData(sFileName, sSheetName, row, 0));

		//click on Go button
		driver.findElement(By.xpath("//*[@id='s_1_1_5_0_Ctrl']")).click();

		//click on show active
		driver.findElement(By.xpath("//*[@id='s_3_1_3_0_Ctrl']")).click();
		
		 //Getting sheet number for Test accounts 
		System.out.println(Utility4.getCellData(sFileName,sSheetName,row, 1));

		String str = Utility4.getCellData(sFileName,sSheetName,row, 1);
			
		System.out.println("account sheetname"+str);
		Thread.sleep(5000);
		
		//Knowing the count of test accounts of the communications
		int totalNoOfRows1 = Utility4.rowcount(str);
		for(int Arow=0;Arow<=totalNoOfRows1;Arow++)
			
		{

		//click on act query
		driver.findElement(By.xpath("//button[@id='s_2_1_11_0_Ctrl']")).click();
		
		//Navigating to the column to enter the communication
		driver.findElement(By.xpath("//input[@id='1_Account_Number']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@id='1_Account_Name']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@id='1_Product']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@id='1_Account_Managing_COE']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@id='1_Account_Product_Delivery']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@id='1_Participant_Fund_Name']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@id='1_Client_Name']")).sendKeys(Keys.TAB);
		
		WebElement e1=driver.findElement(By.xpath("//*[@id='1_Name']"));

		//Entering the communication instance name
		e1.sendKeys(Utility4.getCellData(sFileName,str,Arow, 0));
		
		//click on go button
		driver.findElement(By.xpath("//*[@id='s_2_1_8_0_Ctrl']")).click();
		
		//Refreshing the browser
		driver.navigate().refresh();
		
		//Click on the instance Link
		driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[2]/td[9]/a")).click();

		//Navigate to communication instance window
		Thread.sleep(5000);
		//click on Adhoc submit
		driver.findElement(By.xpath("//button[@aria-label='Communication Maintenance:Adhoc Submit']")).click();
		
		Thread.sleep(5000);
		//Switch to alert window to enter the Effective date
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys(Utility4.getCellData(sFileName,sSheetName,row, 3));
		promptAlert.accept();
		Thread.sleep(8000);
		Alert promptAlert1 = driver.switchTo().alert();
		Thread.sleep(5000);
		promptAlert1.accept();

		//Return back to communication tab
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='siebui-threadbar']/li[1]/span/a")).click();
		Thread.sleep(5000);


		}}
	}
	
}}}
