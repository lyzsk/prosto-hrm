package cn.sichu.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

/**
 * 自定义过滤器
 *
 * @author sichu
 * @date 2023/01/17
 **/
@Component
public class LoginFilter extends ZuulFilter {

    /**
     * pre: 在执行路由请求之前执行
     * routing: 在路由请求时调用
     * post: 在routing和error过滤器之后执行
     * error: 处理请求出现异常的时候执行
     *
     * @return 返回过滤器类型
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 定义过滤器的优先级: 数字越小, 优先级越高
     *
     * @return 过滤器的优先级
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断过滤器是否需要执行
     *
     * @return true/false
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器中负责的具体业务逻辑
     *
     * @return 返回null, 继续向后执行
     * @throws ZuulException ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
