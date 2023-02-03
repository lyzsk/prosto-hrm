package cn.sichu.common.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 公共shiro realm
 *
 * @author sichu
 * @date 2023/01/19
 **/
public class CustomRealm extends AuthorizingRealm {

    @Override
    public void setName(String name) {
        super.setName("CustomRealm");
    }

    /**
     * 授权方法
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取安全数据
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
        return null;
    }

    /**
     * 认证方法, 在微服务里重写
     *
     * @param authenticationToken authenticationToken
     * @return null
     * @throws AuthenticationException AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
        throws AuthenticationException {
        return null;
    }
}
