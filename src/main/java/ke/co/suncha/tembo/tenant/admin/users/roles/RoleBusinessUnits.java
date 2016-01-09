package ke.co.suncha.tembo.tenant.admin.users.roles;

import ke.co.suncha.tembo.tenant.organization.BusinessUnit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maitha.manyala on 10/13/15.
 */
public class RoleBusinessUnits implements Serializable {
    List<BusinessUnit> assigned = new ArrayList<>();
    List<BusinessUnit> available = new ArrayList<>();

    public List<BusinessUnit> getAssigned() {
        return assigned;
    }

    public void setAssigned(List<BusinessUnit> assigned) {
        this.assigned = assigned;
    }

    public List<BusinessUnit> getAvailable() {
        return available;
    }

    public void setAvailable(List<BusinessUnit> available) {
        this.available = available;
    }
}
