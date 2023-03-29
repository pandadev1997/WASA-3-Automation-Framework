package vtiger.Generalutility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consist of generic method to read data from excel file
 * @author debas
 *
 */

public class Excel_File_utility {
	/**
	 * 
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws Exception
	 */
	public String Excel(String sheet,int row,int cell) throws Exception {
	FileInputStream fis=new FileInputStream(All_file_path.Excelfilepath);
	Workbook book = WorkbookFactory.create(fis);
	Sheet sh = book.getSheet(sheet);
	DataFormatter df=new DataFormatter();
	//String testdata=book.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	String testdata=df.formatCellValue(sh.getRow(row).getCell(cell));
	book.close();
	return testdata;
	}
	/**
	 * 
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws Exception
	 */
	public int getlastrow(String sheet) throws Exception {
		FileInputStream fis=new FileInputStream(All_file_path.Excelfilepath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheet);
		int rowcount=sh.getLastRowNum();
		book.close();
		return rowcount;
	}
	
	public void writeDataIntoExcel(String sheet,int row,int cell,String value) throws Exception, IOException {
		FileInputStream fis=new FileInputStream(All_file_path.Excelfilepath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheet);
		sh.createRow(row).createCell(cell).setCellValue(value);
		FileOutputStream fos=new FileOutputStream(All_file_path.Excelfilepath);
		book.write(fos);
		book.close();
		
	}
	public Object[][] readMultipledata(String sheetname) throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream(All_file_path.Excelfilepath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);
		int lastrow = sh.getLastRowNum();
		int lastcell = sh.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++) {
			for(int j=0;j<lastcell;j++) {
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
}
