package utils;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class ConfigReader {

    private static Properties prop;
    static{

        try{
        prop=new Properties();
        FileInputStream fis= new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key)
    {
        return prop.getProperty(key);
    }
    
}
