package ke.co.suncha.tembo.tenant.admin.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ke.co.suncha.tembo.tenant.admin.users.User;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * @author Maitha Manyala <maitha.manyala at gmail.com>
 */
public abstract class BaseEntity {

    private DateTime createdOn = new DateTime(DateTimeZone.UTC);


    private Long dateCreated;

    @JsonIgnore
    private DateTime lastModifiedDate = new DateTime(DateTimeZone.UTC);

    @JsonIgnore
    private User createdBy;

    private String addedBy;

    @JsonIgnore
    private User lastModifiedBy;

    public DateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(DateTime createdOn) {
        this.createdOn = createdOn;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(DateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Long getDateCreated() {
        if (this.createdOn != null) {
            dateCreated = this.createdOn.getMillis();
        }
        return dateCreated;
    }

    public String getAddedBy() {
        if (this.createdBy != null) {
            String[] content = StringUtils.split(this.createdBy.getEmailAddress(), "@");
            if (content.length == 2) {
                this.addedBy = content[0].toLowerCase();
            }
        }
        return addedBy;
    }
}
