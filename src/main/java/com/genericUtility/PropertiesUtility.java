package com.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
   
	/**
	 * This method is used to read the data from the properties file by passing the key and return the value to the caller.  
	 * @param Key
	 * @return
	 * @throws IOException
	 */
	public String getLoginDetails(String Key) throws IOException 
   {
	   FileInputStream FIS=new FileInputStream(IPathConstants.FilePath);
	   Properties prop=new Properties();
	   prop.load(FIS);
	   String Value = prop.getProperty(Key);
	   return Value;
   }
	 	
 
}
