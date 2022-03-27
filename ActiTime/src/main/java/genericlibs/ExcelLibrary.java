package genericlibs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary implements constants
{
	public static final String FILEPATH = XLPATH;
	private static Workbook workbook;
	static {
		FileInputStream fin;
		try {
			fin = new FileInputStream(FILEPATH);
			workbook=WorkbookFactory.create(fin);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		public static String getStringData(String sheetname, int rowNumber, int cellNumber) {
			return workbook.getSheet(sheetname).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
			
		}
		public static double getNumericData(String sheetname, int rowNumber, int cellNumber) {
			return workbook.getSheet(sheetname).getRow(rowNumber).getCell(cellNumber).getNumericCellValue();
			
		}
		public static Date getDateData(String sheetname, int rowNumber, int cellNumber) {
			return workbook.getSheet(sheetname).getRow(rowNumber).getCell(cellNumber).getDateCellValue();
			
		}
	}

