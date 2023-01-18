package cn.sichu.gateway.utils;

import org.springframework.util.AntPathMatcher;

/**
 * @author sichu
 * @date 2023/01/18
 **/
public class PathUtil {

    private static AntPathMatcher matcher = new AntPathMatcher();

    public static boolean isPathMatch(String pattern, String path) {
        return matcher.match(pattern, path);
    }
}
