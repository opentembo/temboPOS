package ke.co.suncha.tembo.tenant.admin.users.roles;

import ke.co.suncha.tembo.tenant.admin.users.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maitha.manyala on 10/13/15.
 */
public class RoleUsers implements Serializable {
    List<User> assigned = new ArrayList<>();
    List<User> available = new ArrayList<>();

    public List<User> getAssigned() {
        return assigned;
    }

    public void setAssigned(List<User> assigned) {
        this.assigned = assigned;
    }

    public List<User> getAvailable() {
        return available;
    }

    public void setAvailable(List<User> available) {
        this.available = available;
    }
}
