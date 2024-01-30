import org.testng.annotations.Test;

public class DataProviderPrint {

	@Test(dataProviderClass= DataProvider.class,dataProvider="Datatesting") 
	public void executeTest(String State ,String Capital) 
	{
		System.out.println(State+"----->"+Capital);
	}
	
	
	
}
