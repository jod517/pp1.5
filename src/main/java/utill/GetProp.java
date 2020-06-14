package utill;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProp {
    public static String getPropertyValue(String key) {
        Properties properties = new Properties();
        InputStream propertyStream = GetProp.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(propertyStream);
            properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}

