package com.AderantOmega.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.AderantOmega.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public static String TESTDATA_SHEET_PATH="E:\\ProjectWorkSpace\\NewAderantOmegaTest\\src\\main\\java\\com"
			+ "\\AderantOmega\\qa\\testdata\\AderantOmegaTestData.xlsx";
	
	public static Object[][] getTestData(String sheetName) {
		
		XSSFWorkbook wbook = null;
		try {
			wbook = new XSSFWorkbook(TESTDATA_SHEET_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet=wbook.getSheetAt(0);
		
		int rowNum=sheet.getLastRowNum();
		
		int cellNum=sheet.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[rowNum][cellNum];
		
		for(int j=0;j<rowNum;j++) {
			XSSFRow row=sheet.getRow(j);
			
			for(int i=0;i<cellNum;i++) {
				XSSFCell cell=row.getCell(i);
				
				/*String value=cell.getStringCellValue();
				
				System.out.println(value);
			
				data[j-1][i]=value;*/
				
				data[j][i]=sheet.getRow(j+1).getCell(i).toString();
			}
		}
		return data;

	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		
	File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	File target=new File("E:\\ProjectWorkSpace\\NewAderantOmegaTest"+"/screenshot/"+System.currentTimeMillis()+".png");
	
	FileUtils.copyFile(source,target);
		
	}

}


