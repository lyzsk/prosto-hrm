package cn.sichu.system.dto;

/**
 * @author sichu
 * @date 2023/01/12
 **/
public class SysPermissionParam {

    private String name;

    private String description;

    private String uri;

    public SysPermissionParam() {
    }

    public SysPermissionParam(String name, String description, String uri) {
        this.name = name;
        this.description = description;
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "SysPermissionParam{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", uri='" + uri
            + '\'' + '}';
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

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
