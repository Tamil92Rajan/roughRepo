package com.ipt.octbatch.IPT_Project_Zoho;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XLSX_Reader {
	static String value;
	public static String readSingleData(String sheetName, int rowNo, int cellNo) throws IOException {
		File f = new File("C:\\Users\\Tamil\\Desktop\\amazon & flipkart.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w= new XSSFWorkbook(fi);
		Sheet s  = w.getSheet(sheetName);
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		CellType ce = c.getCellType();
		if (ce.equals(CellType.STRING)) {
			value = c.getStringCellValue();
		}else if (ce.equals(CellType.NUMERIC)) {
			double d = c.getNumericCellValue();
			int in = (int)d;
			value= String.valueOf(in);
		}
		return value;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
