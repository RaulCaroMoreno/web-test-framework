package utils;

import static utils.Constants.SOURCE_PROPERTIES_FILE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesUtil {
    private Properties properties;

    public PropertiesUtil() {
        properties = new Properties();
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(SOURCE_PROPERTIES_FILE);
        }catch(FileNotFoundException error) {
            throw new IllegalArgumentException("File not found");
        }
        try{
            properties.load(fis);
        } catch(Exception e) {
            throw new IllegalArgumentException("Properties cannot be loaded");
        }

    }

    public String getProperty(String property) {
        return properties.get(property).toString();
    }

}
