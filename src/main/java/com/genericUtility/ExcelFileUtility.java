package com.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelFileUtility {
	
	/**
	 * This method will read the data from the excel based on the Sheetname,RoemNo,CellNo and return the data to tha caller.
	 * @param Sheetname
	 * @param RowNo
	 * @param CellNo
	 * @return 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDatafromExcel(String Sheetname,int RowNo, int CellNo) throws EncryptedDocumentException, IOException 
	{
		FileInputStream FIS=new FileInputStream(IPathConstants.ExcelPath);
	                    Workbook wb = WorkbookFactory.create(FIS);
	                    Sheet sheet = wb.getSheet(Sheetname);
		String value = sheet.getRow(RowNo).getCell(CellNo).getStringCellValue();
		return value;
	}
	
	
	/**
	 * This method will give the last row number by reading the excel sheet and return to the caller.
	 * @param Sheetname
	 * @param RowNo
	 * @param CellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastRowfromExcel(String Sheetname ) throws EncryptedDocumentException, IOException 
	{
		FileInputStream FIS=new FileInputStream(IPathConstants.ExcelPath);
	                    Workbook wb = WorkbookFactory.create(FIS);
	                    Sheet sheet = wb.getSheet(Sheetname);
		                int rowNo = sheet.getLastRowNum();
		                return rowNo;
	}
	
	/**
	 *  This method will give the last cell number by reading the excel sheet and return to the caller.
	 * @param Sheetname
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public int getLastcellnumber(String Sheetname) throws Throwable, IOException 
	{
		FileInputStream FIS=new FileInputStream(IPathConstants.ExcelPath);
        Workbook wb = WorkbookFactory.create(FIS);
        Sheet sheet = wb.getSheet(Sheetname);
        int cellNo = sheet.getRow(0).getLastCellNum();
		return cellNo;
	}
	
	/**
	 * This method is used to write the data into the excel shhet
	 * @param Sheetname
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String Sheetname,int rowNo,int cellNo,String data) throws EncryptedDocumentException, IOException 
	{
		FileInputStream FIS=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(FIS);
		 wb.getSheet(Sheetname).getRow(rowNo).getCell(cellNo).setCellValue(data);
		 FileOutputStream FIO=new FileOutputStream(IPathConstants.ExcelPath);
		 wb.write(FIO);
		
	}
	
	public HashMap<String,String> getHashMapData(String sheetname,int cellNum) throws EncryptedDocumentException, IOException 
	{
		FileInputStream FIS=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(FIS);
		Sheet sheet = wb.getSheet(sheetname);
		int row = sheet.getLastRowNum();
		HashMap<String, String> map=new HashMap<String, String>();
		
		for(int i=0; i<row;i++) 
		{
			String KEY = sheet.getRow(i).getCell(0).getStringCellValue();
			String VALUE = sheet.getRow(i).getCell(1).getStringCellValue();
			map.put(KEY, VALUE);
		}
		 return map;
	}
	
	@DataProvider
	public Object[][] dataFetchingFromExcel(String SheetName) throws  IOException 
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		int Row = wb.getSheet(SheetName).getPhysicalNumberOfRows();
		int Cell = wb.getSheet(SheetName).getRow(0).getPhysicalNumberOfCells();
		Object[][] obj=new Object[Row][Cell];
		for(int i=0;i<Row;i++) 
		{
			for(int j=0;j<Cell;j++) 
			{
				obj [i][j]=wb.getSheet("create doctor").getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}
	
	
	public void writeMUltipleData() throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb= WorkbookFactory.create(fis);
		String [][] st= {{"dell","hp","lenoveo"},{"dell1","hp1","lenovo1"}};
		Sheet sheet = wb.getSheet("Data");
		
	  for(int i=1;i<2;i++) 
	  {
		  for(int j=0;j<3;j++) 
		  {
			 sheet.createRow(i).createCell(j).setCellValue("dell");
		  }
	  }
	  FileOutputStream fos=new FileOutputStream(IPathConstants.ExcelPath);
	  wb.write(fos);
		
	}


 
	}    
	
	


