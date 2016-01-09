package ke.co.suncha.tembo.tenant.admin.users.permissions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maitha Manyala <maitha.manyala at gmail.com>
 */
public class RolePermissions {
    private List<Permission> available = new ArrayList<>();
    private List<Permission> assigned = new ArrayList<>();

    /**
     * @return the available
     */
    public List<Permission> getAvailable() {
        return available;
    }

    /**
     * @param available the available to set
     */
    public void setAvailable(List<Permission> available) {
        this.available = available;
    }

    /**
     * @return the assigned
     */
    public List<Permission> getAssigned() {
        return assigned;
    }

    /**
     * @param assigned the assigned to set
     */
    public void setAssigned(List<Permission> assigned) {
        this.assigned = assigned;
    }

}
