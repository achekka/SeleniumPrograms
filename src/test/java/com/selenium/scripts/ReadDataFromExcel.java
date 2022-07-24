package com.selenium.scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;

public class ReadDataFromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String filePath=".\\DataFolder\\Student Marks.xlsx";
		
		FileInputStream inputStream=new FileInputStream(filePath);
		
		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
		
		XSSFSheet worksheet=workbook.getSheetAt(0);
		
		Iterator iterator=worksheet.iterator();
		
		while(iterator.hasNext()) {
			
			XSSFRow row=(XSSFRow) iterator.next();
			
			Iterator cellIterator=row.cellIterator();
			
		while(cellIterator.hasNext()) {
			
			XSSFCell cell=(XSSFCell) cellIterator.next();
			
			switch(cell.getCellType()) {
			
			case NUMERIC: System.out.print(cell.getNumericCellValue()); break;
			case BOOLEAN: System.out.print(cell.getBooleanCellValue()); break;
			case STRING: System.out.print(cell.getStringCellValue()); break;
			
			}
			
			System.out.print(" | ");	
		}
		
		System.out.println();
			
		}	
			
		}
	}
