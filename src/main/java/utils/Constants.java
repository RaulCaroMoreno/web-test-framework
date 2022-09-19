package utils;

public class Constants {

    private static final String USER_DIRECTORY = System.getProperty("user.dir");

    private Constants() {

    }

    public static final String SOURCE_PROPERTIES_FILE = USER_DIRECTORY +"//src//main//resources//regression.properties";
    public static final String SOURCE_REPORT_FILE = USER_DIRECTORY + "//reports//index.html";
    public static final String SOURCE_TEST_DATA = USER_DIRECTORY + "//src//main///resources//data//";

}
