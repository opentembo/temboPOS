package ke.co.suncha.tembo.tenant.admin.users.permissions;

import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * System action entity class
 *
 * @author Maitha Manyala <maitha.manyala at gmail.com>
 */
public class Permission extends BaseEntity {
    private long permissionId;
    private String name;
    private String description;
    private Boolean active = true;

    public long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}