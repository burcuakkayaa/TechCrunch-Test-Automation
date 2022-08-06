package utils;

public class Constants {

    public static final String BASE_URL = "https://techcrunch.com";
    public static final String IMPLICIT_WAIT_DURATION = "1";
    public static final String PAGE_LOAD_TIMEOUT = "180000";
    public static final String[] CHROME_OPTIONS = {
            "--disable-cache"
            , "--incognito"
            , "start-maximized"
            , "--no-sandbox"
            , "--disable-gpu"
            , "--disable-dev-shm-usage"
            , "--disable-infobars"
            , "--disable-notifications"
            , "--enable-automation"
            , "--ignore-certificate-errors"
            , "--ignore-ssl-errors"
            , "--disable-cache"
    };

    public static final String[] FIREFOX_OPTIONS = {
            "--ignore-certificate-errors"
            , "--ignore-ssl-errors"
            , "--disable-notifications"
            , "--disable-infobars"
            , "--incognito"
    };

}
