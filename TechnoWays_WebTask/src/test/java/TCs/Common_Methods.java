package TCs;

import java.io.IOException;

import utils.ReadingPropertiesFile;

public class Common_Methods {
	 static utils.ReadingPropertiesFile data;
	static utils.LogInFile Logger = new utils.LogInFile(Common_Methods.class);
	
	
	public static  ReadingPropertiesFile Call_ReadPropFile () throws IOException{
		try {
			
		 data = new utils.ReadingPropertiesFile(".\\Input\\Configuration.properities");
		 
		 
		} catch (Exception e) {
			e.printStackTrace();
			Logger.WriteLog(" Line " + Thread.currentThread().getStackTrace()[1].getLineNumber() + "\n", e);
		}
		return data;
	}
	
}
