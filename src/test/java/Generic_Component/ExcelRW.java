package Generic_Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRW {

	FileInputStream fis;
	XSSFWorkbook wb;
	
	public ExcelRW(String filePath) throws IOException
	{
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
	}

	public int getRowCount(String sheetName)
	{
		XSSFSheet ws = wb.getSheet(sheetName);	
		int rowCount = ws.getLastRowNum();
		return rowCount;
	}
	public int getColCount(String sheetName)
	{
		XSSFSheet ws = wb.getSheet(sheetName);	
		int colCount = ws.getRow(0).getLastCellNum();
		return colCount;
	}
	public String readCell(String sheetName,int row,int col)
	{
		XSSFSheet ws = wb.getSheet(sheetName);
		XSSFCell cellVal = ws.getRow(row).getCell(col);
		String cellText="";
		if(cellVal.getCellType()== cellVal.CELL_TYPE_STRING)
		{
			cellText = cellVal.getStringCellValue();
		}
		if(cellVal.getCellType() == cellVal.CELL_TYPE_NUMERIC)
		{
			cellText = String.valueOf(cellVal);
		}
		if(cellVal.getCellType()==cellVal.CELL_TYPE_BLANK)
		{
			cellText="";
		}
		return cellText;
		
	}
	public void writeCell(String sheetName, int row, int col,String value)
	{
		XSSFSheet ws = wb.getSheet(sheetName);
		ws.getRow(row).getCell(col).setCellValue(value);
	}
	public void saveAndClose(String filePath) throws IOException
	{
		fis.close();
		FileOutputStream fos = new FileOutputStream(filePath);
		wb.write(fos);
		fos.close();
	}

}
