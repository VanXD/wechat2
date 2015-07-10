package util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

public class PropertyUtil {

	public Properties loadProperties() {
		Properties properties = new Properties();
		InputStream stream = this.getClass().getClassLoader()
				.getResourceAsStream("/handlerFactory.properties");
		try {
			properties.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}
}
