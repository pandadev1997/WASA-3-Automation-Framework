package practice1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import vtiger.Generalutility.All_file_path;

public class PropertyFileUtility {
	public String readDataFromProperty(String key) throws IOException {
	
	FileInputStream fis=new FileInputStream(All_file_path.propertyfilepath);
	Properties pobj=new Properties();
	pobj.load(fis);
	String value = pobj.getProperty(key);
	return value;
	}

}
