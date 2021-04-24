package com.ascendum.lopal.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExcelOperations extends TestBase {
	public static final Logger log = Logger.getLogger(ExcelOperations.class.getName());

	FileInputStream fis =new FileInputStream(System.getProperty("user.dir") + properties.getProperty("excelFilePath"));
	XSSFWorkbook workbook =new XSSFWorkbook(fis);
	XSSFSheet sheet= workbook.getSheetAt(0);
	XSSFRow row;
	XSSFCell cell = null;
	DataFormatter formateData=new DataFormatter();

	public ExcelOperations() throws IOException {}

	// close the file opened
	public void closeFile() throws IOException {
		fis.close();
	}

	// code to read data at a particular row
	public String readDataFromExcel(int rowNo, int cellNo) {
		String cellVal = formateData.formatCellValue(sheet.getRow(rowNo).getCell(cellNo));
		log.info("Data in the cell is : " + cellVal);
		return cellVal;
	}

	// code to read data at a particular row - cell and enters it in the specified
	// element on the web page
	public Object readCellDataFromExcel(int rowNo, int cellNo, By locator) {
		row = sheet.getRow(rowNo);
		cell = row.getCell(cellNo);
		WebElement element = driver.findElement(locator);
		element.sendKeys(cell.toString());
		log.info("The cell data is : " + "\"" + cell.toString() + "\""
				+ " is succesfully entered in the specified web element");
		return cell;

	}


}
