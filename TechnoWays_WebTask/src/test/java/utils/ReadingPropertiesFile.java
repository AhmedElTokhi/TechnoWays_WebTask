package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropertiesFile {

	protected Properties Prop = null;
	protected FileInputStream LoadFile = null;

	public ReadingPropertiesFile(String FilePath) throws IOException {
		Prop = new Properties();
		LoadFile = new FileInputStream(FilePath);
		Prop.load(LoadFile);
	}

	// ===== Driver Methods =======
	public String GetBrowser() {
		return Prop.getProperty("browser");
	}
	public String GetURL() {
		return Prop.getProperty("URL");
	}
	
	public String GetKeyword1 (){
		return Prop.getProperty("Keyword1");
	}

	public String GetCase1VideoNo() {
		return Prop.getProperty("Case1VideoNo");
	}

	public String GetKeyword2() {
		return Prop.getProperty("Keyword2");
	}

	public String GetCase3VideoNo() {
		return Prop.getProperty("Case3VideoNo");
	}
	
}
