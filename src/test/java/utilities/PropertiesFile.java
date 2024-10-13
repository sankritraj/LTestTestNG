package utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesFile {
	Properties prop;
	public Logger LOGGER = Logger.getLogger(PropertiesFile.class);
	public Properties properties() {
		try {
			FileReader fileReader = new FileReader(System.getProperty("user.dir") + File.separator + "src"
					+ File.separator + "test" + File.separator + "resources" + File.separator + "config.properties");
			LOGGER.info("Properties file for config is picked from " + System.getProperty("user.dir") + File.separator
					+ "src" + File.separator + "test" + File.separator + "resources" + File.separator
					+ "config.properties");
			prop = new Properties();
			prop.load(fileReader);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return prop;

	}

}
