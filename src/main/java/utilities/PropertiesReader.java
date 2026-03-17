package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

	public static String getProperties(String fileName, String propertyName) {
		String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\" + fileName.toLowerCase()
				+ ".properties";
		String property = null;

		try {
			
			File f = new File(filePath);
			Properties pr = new Properties();
			pr.load(new FileInputStream(f));
			property = pr.getProperty(propertyName).toString();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return property;
	}

	public static void main(String[] args) {
		System.out.println(getProperties("config", "url"));
	}

}
