package ke.co.suncha.tembo.tenant.organization.warehousing.locator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;
import ke.co.suncha.tembo.tenant.organization.warehousing.Warehouse;
import java.io.Serializable;

/**
 * Created by maitha.manyala on 8/20/15.
 */

public class WarehouseLocator extends BaseEntity implements Serializable {
    private long warehouseLocatorId;
    private String name;
    private String description = "Not Available";
    private Boolean active = true;
    private Boolean isDefault = false;
    private String aisle;
    private String binY;
    private String levelZ;

    @JsonIgnore
    private Warehouse warehouse;

    public long getWarehouseLocatorId() {
        return warehouseLocatorId;
    }

    public void setWarehouseLocatorId(long warehouseLocatorId) {
        this.warehouseLocatorId = warehouseLocatorId;
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

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public String getBinY() {
        return binY;
    }

    public void setBinY(String binY) {
        this.binY = binY;
    }

    public String getLevelZ() {
        return levelZ;
    }

    public void setLevelZ(String levelZ) {
        this.levelZ = levelZ;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
