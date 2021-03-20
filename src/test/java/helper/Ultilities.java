package test.java.helper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Ultilities {
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }
    public static String getReportPath() {
        return getProjectPath()+File.separator+"output"+File.separator+"report"+File.separator;
    }
    public static String getScreenshotsPath() {
        return getReportPath()+ "screenshots" + File.separator;
    }
    public static String generateNumber(int length){
        String number = "0123456789";
        Random rand = new Random();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(number.charAt(rand.nextInt(number.length())));
        return sb.toString();
    }

    public static String getCurrentTime(){
        return new SimpleDateFormat("ddMMyyHHmmss").format(Calendar.getInstance().getTime());
    }

    public static String removeSpecialCharacter(String string){
        return string.replaceAll("[^a-zA-Z0-9]", "");
    }


    public static String getCurrentMethodName()
    {
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        return ste[2].getMethodName();
    }
}
