package ke.co.suncha.tembo.tenant.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.organization.warehousing.Warehouse;
import ke.co.suncha.tembo.tenant.utils.address.Address;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maitha.manyala on 8/23/15.
 */
public class BusinessUnit extends BaseEntity implements Serializable {
    private long businessUnitId;
    private String name;
    private String description = "Not Available";
    private Boolean isDefault = false;
    private Boolean active = true;
    private String logoUrl;
    private Tenant tenant;
    @JsonIgnore
    private String searchKey = "";

    @JsonIgnore
    private List<Warehouse> warehouses;

    private List<Address> addresses;

    //TODO;
    // organization type

    public long getBusinessUnitId() {
        return businessUnitId;
    }

    public void setBusinessUnitId(long businessUnitId) {
        this.businessUnitId = businessUnitId;
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

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public List<Address> getAddresses() {
        if (addresses == null) {
            addresses = new ArrayList<>();
        }
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return "BusinessUnit{" +
                "businessUnitId=" + businessUnitId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", logoUrl='" + logoUrl + '\'' +
                '}';
    }
}
