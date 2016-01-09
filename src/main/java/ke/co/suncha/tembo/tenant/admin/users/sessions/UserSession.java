package ke.co.suncha.tembo.tenant.admin.users.sessions;

import ke.co.suncha.tembo.tenant.admin.users.roles.UserRole;
import ke.co.suncha.tembo.tenant.organization.BusinessUnit;
import ke.co.suncha.tembo.tenant.organization.warehousing.Warehouse;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by maitha.manyala on 10/10/15.
 */

@Service
public class UserSession implements Serializable {
    private long sessionId;
    private Boolean tenantLevel = false;
    private UserRole userRole;
    private BusinessUnit businessUnit;
    private Warehouse warehouse;

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public Boolean getTenantLevel() {
        return tenantLevel;
    }

    public void setTenantLevel(Boolean tenantLevel) {
        this.tenantLevel = tenantLevel;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public BusinessUnit getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(BusinessUnit businessUnit) {
        this.businessUnit = businessUnit;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
