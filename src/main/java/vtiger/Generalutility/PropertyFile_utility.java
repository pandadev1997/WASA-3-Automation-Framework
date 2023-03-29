package vtiger.Generalutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class consist of generic method to read data from property file
 * @author debasish
 *
 */

public class PropertyFile_utility {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String readDataFromPropertyFile(String key) throws Exception {
		FileInputStream fis=new FileInputStream(All_file_path.propertyfilepath);
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
	}
	

}
