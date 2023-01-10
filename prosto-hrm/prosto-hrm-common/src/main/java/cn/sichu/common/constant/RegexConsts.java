package cn.sichu.common.constant;

/**
 * @author sichu
 * @date 2023/01/10
 **/
public class RegexConsts {
    public static final String STRONG_PASSWORD =
        "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[\\!\\@\\#\\$\\%\\^\\&\\*])(?=.{8,})";

    public static final String MEDIUM_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})";

    public static final String WEAK_PASSWORD_LOWER = "^(?=.*[a-z])(?=.*[0-9])(?=.{8,})";

    public static final String WEAK_PASSWORD_UPPER = "^(?=.*[A-Z])(?=.*[0-9])(?=.{8,})";
}
