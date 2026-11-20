package automation_excercise_utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	
	
	public Object[][] excelDataReader() throws IOException
	{
		DataFormatter formatter = new DataFormatter();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")
		        + "/src/test/resources/TestData/search-data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowCount=sheet.getPhysicalNumberOfRows();
		XSSFRow row=sheet.getRow(0);
		int calColumn =row.getLastCellNum();
		Object data[][] = new Object[rowCount-1][calColumn];
		for(int i=0; i<rowCount-1; i++)
		{
			row=sheet.getRow(i+1);
			for(int j=0;j<calColumn; j++)
			{
			    XSSFCell cell =row.getCell(j);
			    data[i][j]=formatter.formatCellValue(cell);
			}
		}
		return data;
	}

}
