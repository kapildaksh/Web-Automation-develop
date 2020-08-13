package com.prenetics.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReturnExcelSheetData {

	@DataProvider(name = "extractData")
	public static Object[][] returnExcelSheetData(Method method) throws BiffException, IOException {

		String filePath = ReadExcelAnnotation.extractAnnotationValue(method).get("filePath");
		String fileName = ReadExcelAnnotation.extractAnnotationValue(method).get("fileName");
		String sheetName = ReadExcelAnnotation.extractAnnotationValue(method).get("sheetName");

		String absolutePath = filePath.concat("/").concat(fileName);
		FileInputStream file = new FileInputStream(new File(absolutePath));
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet worksheet = workbook.getSheet(sheetName);

		int ROWS = worksheet.getRows() - 1;
		int COLS = worksheet.getColumns();

		Object[][] dataset = new Object[ROWS][COLS];
		for (int rowCount = 0; rowCount < ROWS; rowCount++) {
			for (int colCount = 0; colCount < COLS; colCount++) {
				dataset[rowCount][colCount] = worksheet.getCell(colCount, rowCount + 1).getContents();
			}
		}
		workbook.close();
		file.close();
		return dataset;
	}
}