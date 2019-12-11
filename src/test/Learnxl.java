package test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Learnxl {

	public static void main(String[] args) throws Exception{
		
		File src=new File("C:\\Users\\beerar\\Downloads\\Automation_2019\\TestData.xlsx");
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//XSSFWorkbook ab= new XSSFWorkbook();
		//XSSFSheet Sheeet2 = ab.getSheet("")
		
		
	//	HSSFWorkbook wb1=new HSSFWorkbook(fis);
		
		XSSFSheet Sheet2=wb.getSheetAt(0);
		 int rowcount = Sheet2.getLastRowNum();
		 System.out.println("Tota Row is "+rowcount+1);
		 
		 for(int i =0;i<rowcount;i++){
		 String data0= Sheet2.getRow(i).getCell(0).getStringCellValue();
		 System.out.println("Data from Ro is "+i+"is "+data0);
		 }
		 
		 }
		//XSSFSheet sheet1= wb.getSheet("Sheet1");
		
		//String data0=sheet1.getRow(0).getCell(0).getStringCellValue();
		//String data1=sheet1.getRow(2).getCell(3).getStringCellValue();
		//System.out.println("Data from xl is with row 0 and column 0 "+data0);
		//System.out.println("Data from xl is with row 0 and column 0 "+data1);
		//wb.close();
		
	}
