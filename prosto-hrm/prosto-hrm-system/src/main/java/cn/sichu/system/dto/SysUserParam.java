package cn.sichu.system.dto;

/**
 * SysUser 的 Dto, 用于用户注册
 * TODO: 加入 security 后 添加 Notblank 注解
 *
 * @author sichu
 * @date 2023/01/07
 **/
public class SysUserParam {

    private String username;

    private String password;

    private String name;

    private String email;

    private String phone;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
