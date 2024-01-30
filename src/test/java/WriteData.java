import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import com.genericUtility.ExcelFileUtility;

public class WriteData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		 ExcelFileUtility euf=new ExcelFileUtility();
         euf.writeMUltipleData();
	}

}
