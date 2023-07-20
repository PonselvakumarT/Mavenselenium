package test.Selenium;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadData {

	static Object s;

	String filepath = System.getProperty("user.dir")+"\\Input";

	public Object[][] ExcelRead(String Filename, String Sheetname) throws IOException {

	
		Object[][] excelreadarray = null;
		File F = new File(filepath+Filename);
		FileInputStream fs = new FileInputStream(F);
		XSSFWorkbook wbk = new XSSFWorkbook(fs);
		Sheet sh = hsf.getSheet(Sheetname);

		int totalusedrows=sh.getLastRowNum();
		int totalusedrows=sh.getPhysicalNumberOfRows();
		int usedcolu=sh.getRow(0).getLastCellNum();


		excelreadarray=new Object[totalusedros][usedcolu];
		for(int i=0; i<totalusedrows;i++)
		{
			Row rw=sh.getRow(i);
			int usedcolumn=rw.getLastCellNum();
			for(int j=0; j<usedcolumn; j++)
			{
			Cell value=rw.getCell(j);
			System.out.println(value);
			readdataassuch(value);
			excelreadarray[i][j]=value.toString();
			excelreadarray[i][j]=readdataassuch(value);

			}	
			}

		hsf.close();
		fs.close();

		return excelreadarray;

	}

	
	public static Object readdataassuch(Cell cellvalue)

	{
		if(cellvalue.getCellType().equals(CellType.STRING))
		{
			s=cellvalue.getStringCellValue();
		}

		else if(cellvalue.getCellType().equals(CellType.NUMERIC))
		{
			DataFormatter dataFormatter=new DataFormatter();
			s=dataFormatter.formatCellValue(cellvalue);
		}	

		return s;

		}
