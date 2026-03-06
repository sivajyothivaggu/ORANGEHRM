package utils;

import constants.FrameworkConstants;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    
    private static Properties properties;
    
    static {
        try {
            FileInputStream fis = new FileInputStream(FrameworkConstants.CONFIG_FILE_PATH);
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public static String getUrl() {
        return properties.getProperty("url");
    }
    
    public static String getBrowser() {
        return properties.getProperty("browser");
    }
    
    public static String getUsername() {
        return properties.getProperty("username");
    }
    
    public static String getPassword() {
        return properties.getProperty("password");
    }
}
