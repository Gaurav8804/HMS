package com.genericUtility;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;

public class MapCheck {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		ExcelFileUtility efu=new ExcelFileUtility();
		HashMap<String, String> datas = efu.getHashMapData("create doctor",0 );
		 for( Entry<String, String> data:datas.entrySet()) 
		 {
			 System.out.println(data.getKey()+" : "+data.getValue());
		 }
		
		
	}
	

}
