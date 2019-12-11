package test;

import Lib.ExcelDataConfig;

public class ReadExcel {

	public static void main(String[] args){
		
		ExcelDataConfig excel = new ExcelDataConfig("C:\\Users\\beerar\\Downloads\\Automation_2019\\TestData.xlsx");
		System.out.println(excel.getData(0, 0, 0));
		
	}
}
