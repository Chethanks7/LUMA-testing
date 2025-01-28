package framework.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties ;

    static {
        String path = "src/test/resources/config/config.properties";
        try {
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperties(String key){
       return properties.getProperty(key);
    }
}
