package utils;

import java.io.IOException;
import java.util.Properties;

import java.io.InputStream;

public class PropertiesReader {
    private static final String MAIN_URL_FILE = "URL.properties";
    private Properties properties;

    public PropertiesReader() {
        loadProperties();
    }

    /**
     * Loads properties from the "main.properties" file located in the resources directory.
     * If the file cannot be found or read, an IOException is thrown.
     */
    private void loadProperties() {
        properties = new Properties();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(MAIN_URL_FILE)) {
            if (is != null) {
                properties.load(is);
            } else {
                throw new IOException("Properties file not found: " + MAIN_URL_FILE);
            }
        } catch (IOException e) {
            System.out.println("Properties file can't be read: " + e.getMessage());
        }
    }

    public String getMainUrl() {
        return properties.getProperty("mainIPAPIUrl");
    }
}
