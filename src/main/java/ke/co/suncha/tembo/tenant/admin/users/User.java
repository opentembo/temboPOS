package ke.co.suncha.tembo.tenant.admin.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.admin.users.auth.UserAuth;
import ke.co.suncha.tembo.tenant.admin.users.sessions.UserSession;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;
import ke.co.suncha.tembo.tenant.admin.users.roles.UserRole;

/**
 * System user entity class
 *
 * @author Maitha Manyala <maitha.manyala at gmail.com>
 */
public class User extends BaseEntity implements Serializable {
    // ==============
    // PRIVATE FIELDS
    // ==============

    // An autogenerated id (unique for each user in the db)
    private long userId;

    // The user email
    private String emailAddress;

    // The user first name
    private String firstName;

    // The user last name
    private String lastName;

    // The user account status
    private Boolean active = false;

    @JsonIgnore
    private List<UserRole> userRoles;

    @JsonIgnore
    private UserAuth userAuth;

    @JsonIgnore
    private UserSession userSession;

    @JsonIgnore
    private Tenant tenant;

    private Boolean system = false;


    // ==============
    // PUBLIC FIELDS
    // ==============


    /**
     * @return the active
     */
    public Boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * @return the userAuth
     */
    public UserAuth getUserAuth() {
        return userAuth;
    }

    /**
     * @param userAuth the userAuth to set
     */
    public void setUserAuth(UserAuth userAuth) {
        this.userAuth = userAuth;
    }

    /**
     * @return the userId
     */
    public long getUserId() {
        return userId;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public List<UserRole> getUserRoles() {
        if (userRoles == null) {
            userRoles = new ArrayList<>();
        }
        return userRoles;
    }


    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    /*
                     * (non-Javadoc)
                     *
                     * @see java.lang.Object#toString()
                     */
    @Override
    public String toString() {
        return "User [userId=" + userId + ", emailAddress=" + emailAddress + ", firstName=" + firstName + ", lastName=" + lastName + "dateAdded=" + this.getCreatedOn() + ", status=" + active + "]";
    }

    public UserSession getUserSession() {
        if (userSession == null) {
            userSession = new UserSession();
        }
        return userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }
}