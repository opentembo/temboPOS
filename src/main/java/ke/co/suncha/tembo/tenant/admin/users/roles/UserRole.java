package ke.co.suncha.tembo.tenant.admin.users.roles;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.admin.users.User;
import ke.co.suncha.tembo.tenant.organization.BusinessUnit;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;
import ke.co.suncha.tembo.tenant.admin.users.permissions.Permission;

/**
 * User role entity class
 *
 * @author Maitha Manyala <maitha.manyala at gmail.com>
 */
@JsonSerialize
public class UserRole extends BaseEntity {
    private long roleId;
    private String name = "";
    private String description = "";
    private Boolean tenantLevel = false;
    private Boolean active = false;
    private List<Permission> permissions;

    @JsonIgnore
    private List<BusinessUnit> businessUnits;

    @JsonIgnore
    private List<User> users;

    @JsonIgnore
    private Tenant tenant;
    private Boolean system = false;


    // ==============
    // PUBLIC FIELDS
    // ==============


    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public List<BusinessUnit> getBusinessUnits() {
        if (businessUnits == null) {
            businessUnits = new ArrayList<>();
        }
        return businessUnits;
    }

    public void setBusinessUnits(List<BusinessUnit> businessUnits) {
        this.businessUnits = businessUnits;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Boolean getSystem() {
        return system;
    }

    public void setSystem(Boolean system) {
        this.system = system;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public Boolean getTenantLevel() {
        return tenantLevel;
    }

    public void setTenantLevel(Boolean tenantLevel) {
        this.tenantLevel = tenantLevel;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}