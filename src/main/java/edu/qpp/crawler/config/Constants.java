package edu.qpp.crawler.config;

/**
 * Application constants.
 */
public final class Constants {

    //Regex for acceptable logins
    public static final String LOGIN_REGEX = "^[_'.@A-Za-z0-9-]*$";

    public static final String SYSTEM_ACCOUNT = "system";
    public static final String ANONYMOUS_USER = "anonymoususer";

    //成功标示
    public final static int SUCCESS_CODE = 0;

    //失败标志
    public final static int FAIL_CODE = 1;

    //主题输入错误
    public final static String THEME_ERROR = "0010";

    public final static String THEME_SUC = "0020";

    private Constants() {
    }
}
