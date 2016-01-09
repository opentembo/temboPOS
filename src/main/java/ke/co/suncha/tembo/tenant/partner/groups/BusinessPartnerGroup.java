package ke.co.suncha.tembo.tenant.partner.groups;

import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;
import java.io.Serializable;

/**
 * Created by maitha.manyala on 9/9/15.
 */
public class BusinessPartnerGroup extends BaseEntity implements Serializable {
    private long businessPartnerGroupId;
    private BusinessPartnerGroupType businessPartnerGroupType = BusinessPartnerGroupType.CUSTOMER;
    private Tenant tenant;
    private String name;
    private String description = "Not Available";
    private Boolean active = true;

    public long getBusinessPartnerGroupId() {
        return businessPartnerGroupId;
    }

    public void setBusinessPartnerGroupId(long businessPartnerGroupId) {
        this.businessPartnerGroupId = businessPartnerGroupId;
    }

    public BusinessPartnerGroupType getBusinessPartnerGroupType() {
        return businessPartnerGroupType;
    }

    public void setBusinessPartnerGroupType(BusinessPartnerGroupType businessPartnerGroupType) {
        this.businessPartnerGroupType = businessPartnerGroupType;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
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
