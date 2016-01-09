package ke.co.suncha.tembo.tenant.organization.warehousing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.organization.BusinessUnit;
import ke.co.suncha.tembo.tenant.utils.address.Address;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;
import ke.co.suncha.tembo.tenant.organization.warehousing.locator.WarehouseLocator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maitha.manyala on 8/20/15.
 */
public class Warehouse extends BaseEntity implements Serializable {
    private long warehouseId;
    private String name;
    private String description = "Not Available";
    private Boolean active = true;
    private Boolean inTransit = false;
    private Boolean negativeInventory = false;
    @JsonIgnore
    private Tenant tenant;
    private BusinessUnit businessUnit;
    private List<Address> addresses;
    private Integer inventoryIn = 0;
    private Integer inventoryOut = 0;
    private Integer inventoryBooked = 0;

    @JsonIgnore
    private List<WarehouseLocator> warehouseLocators;

    public long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(long warehouseId) {
        this.warehouseId = warehouseId;
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

    public Boolean getInTransit() {
        return inTransit;
    }

    public void setInTransit(Boolean inTransit) {
        this.inTransit = inTransit;
    }

    public Boolean getNegativeInventory() {
        return negativeInventory;
    }

    public void setNegativeInventory(Boolean negativeInventory) {
        this.negativeInventory = negativeInventory;
    }

    public BusinessUnit getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(BusinessUnit businessUnit) {
        this.businessUnit = businessUnit;
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

    public List<WarehouseLocator> getWarehouseLocators() {
        if (warehouseLocators == null) {
            warehouseLocators = new ArrayList<>();
        }
        return warehouseLocators;
    }

    public void setWarehouseLocators(List<WarehouseLocator> warehouseLocators) {
        this.warehouseLocators = warehouseLocators;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Integer getInventoryIn() {
        return inventoryIn;
    }

    public void setInventoryIn(Integer inventoryIn) {
        this.inventoryIn = inventoryIn;
    }

    public Integer getInventoryOut() {
        return inventoryOut;
    }

    public void setInventoryOut(Integer inventoryOut) {
        this.inventoryOut = inventoryOut;
    }

    public Integer getInventoryBooked() {
        return inventoryBooked;
    }

    public void setInventoryBooked(Integer inventoryBooked) {
        this.inventoryBooked = inventoryBooked;
    }
}
