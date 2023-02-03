package cn.sichu.system.dto;

/**
 * 用户登录dto
 *
 * @author sichu
 * @date 2023/01/18
 **/
public class SysUserLoginParam {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
