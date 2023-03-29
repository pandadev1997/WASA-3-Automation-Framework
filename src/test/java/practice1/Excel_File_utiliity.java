package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import vtiger.Generalutility.All_file_path;

public class Excel_File_utiliity {
	public String readDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(All_file_path.Excelfilepath);
		Workbook book = WorkbookFactory.create(fis);
		String value = book.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	public void writeDataintoExcel(String sheet,int row,int cell,String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(All_file_path.Excelfilepath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheet);
		Row rw = sh.createRow(row);
		Cell cel = rw.createCell(cell);
		cel.setCellValue(value);
		FileOutputStream fos=new FileOutputStream(All_file_path.Excelfilepath);
		book.write(fos);
		book.close();

	}

}
