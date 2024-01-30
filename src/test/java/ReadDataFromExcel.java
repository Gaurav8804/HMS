import org.testng.annotations.Test;

public class ReadDataFromExcel {
	                         //classname                                methodname  of Dataprovider
	@Test(dataProviderClass=DataFetchingFromExcel.class,dataProvider="dataFetchingFromExcel")
	public void ReadData(String Locator,String data) //names what ever we want we can provide locator,xpath etc
	{
		System.out.println(Locator+"------>"+data);
	}

}
