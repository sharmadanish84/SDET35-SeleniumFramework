package genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {

	public String propertyKeyAndValue(String key) throws Throwable {
	
		FileInputStream fis = new FileInputStream(IConstant.commonPath);
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
		
		/**
		 * this method is used to fetch the data from properties file
		 * @author Danish
		 */

	}

}
