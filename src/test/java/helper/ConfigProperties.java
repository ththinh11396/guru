package test.java.helper;

import test.java.common.Constant;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
    static Properties properties = new Properties();
    static InputStream inputStream = null;
    static String value = "";

    public static String getValue(String key) {
        try {
            inputStream = new FileInputStream(Constant.CONFIG_PROPERTIES_PATH);
            if(inputStream!=null)
                properties.load(inputStream);
            else
                throw new FileNotFoundException("Config Properties file not found");

            value = properties.getProperty(key);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    public static String getURL(){
        return getValue("url");
    }
    public static String getUsername(){return getValue("username");}
    public static String getPassword(){return getValue("password");}
    public static long getWaitTimeout(){
        return Long.parseLong(getValue("waitTimeout"));
    }
    public static long getWaitShortTime(){
        return Long.parseLong(getValue("waitShortTime"));
    }
    public static long getWaitMediumTime(){
        return Long.parseLong(getValue("waitMediumTime"));
    }
    public static long getWaitLongTime(){
        return Long.parseLong(getValue("waitLongTime"));
    }

}
