package cn.sichu.hrms.utils;

import cn.sichu.hrms.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author sichu
 * @date 2022/10/05
 **/
public class HrUtils {
    public static Hr getCurrentHr() {
        return ((Hr)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
