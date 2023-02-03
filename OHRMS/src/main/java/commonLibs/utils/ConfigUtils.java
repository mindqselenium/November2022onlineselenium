package commonLibs.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ConfigUtils {

	public static Properties readproperties(String filename) throws Exception {
		filename = filename.trim();
		InputStream filereader = new FileInputStream(filename);
		Properties property = new Properties();
		property.load(filereader);
		return property;
	}
}
