package com.automationpractice.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider(String fileName)
	{
		
		
		File src = new File("./Data/" + fileName);
		
		try 
	   {
			
		FileInputStream fis = new FileInputStream(src);
		
		wb = new XSSFWorkbook(fis);
		
		}
		
		catch (Exception e) 
	     {
			System.out.println("unable to read Excel file" +e.getMessage());
	     }
	}
		
	
    public Double getNumericData (String sheetName, int row, int column) {
		
		return wb.getSheet("sheetName").getRow(row).getCell(column).getNumericCellValue();
		
		}
	
	public String getStringData(String sheetName, int row, int column) {
			
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		
		}
	
	public String getStringData(int sheetIndex, int row, int column) {
		
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		
		}
		
	
	}

	
	

