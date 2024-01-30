import java.io.FileInputStream;
import java.io.IOException;

 
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.genericUtility.IPathConstants;

public class DataFetchingFromExcel {
	@DataProvider
	public Object[][] dataFetchingFromExcel() throws  IOException 
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		int Row = wb.getSheet("create doctor").getPhysicalNumberOfRows();
		int Cell = wb.getSheet("create doctor").getRow(0).getPhysicalNumberOfCells();
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
	
	

}
