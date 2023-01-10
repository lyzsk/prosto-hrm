package cn.sichu.system.dto;

/**
 * SysRole 的 dto, 用于添加 Role
 * TODO: 加入 security 后 添加 Notblank 注解
 *
 * @author sichu
 * @date 2023/01/09
 **/
public class SysRoleParam {
    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色描述
     */
    private String description;

    public SysRoleParam() {
    }

    public SysRoleParam(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "SysRoleParam{" + "name='" + name + '\'' + ", description='" + description + '\'' + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
