package constants;

public class FrameworkConstants {
    
    public static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config.properties";
    public static final String TESTDATA_PATH = System.getProperty("user.dir") + "/src/test/resources/testdata/";
    public static final String REPORTS_PATH = System.getProperty("user.dir") + "/reports/";
    public static final String SCREENSHOTS_PATH = System.getProperty("user.dir") + "/screenshots/";
    
    public static final int EXPLICIT_WAIT = 20;
    public static final int PAGE_LOAD_TIMEOUT = 60;
    public static final int IMPLICIT_WAIT = 10;
}
