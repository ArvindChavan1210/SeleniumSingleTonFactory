package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	public static String getProperty(String fileName, String requiredProperty) {

		String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\" + fileName.toLowerCase()
				+ ".properties";
		try {
			File f = new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			Properties pr = new Properties();
			pr.load(fis);

			return pr.get(requiredProperty).toString();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		getProperty("config123", null);
	}

}
