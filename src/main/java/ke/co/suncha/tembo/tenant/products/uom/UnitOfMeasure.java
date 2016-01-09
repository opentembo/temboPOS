package ke.co.suncha.tembo.tenant.products.uom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;
import java.io.Serializable;

/**
 * Created by maitha.manyala on 8/25/15.
 */

public class UnitOfMeasure extends BaseEntity implements Serializable {
    private long unitOfMeasureId;
    private String name;
    private String description = "Not Available";
    private Boolean active = true;
    private String symbol;
    private Integer standardPrecision = 0;
    private Integer costingPrecision = 0;

    @JsonIgnore
    private Tenant tenant;

    public long getUnitOfMeasureId() {
        return unitOfMeasureId;
    }

    public void setUnitOfMeasureId(long unitOfMeasureId) {
        this.unitOfMeasureId = unitOfMeasureId;
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getStandardPrecision() {
        return standardPrecision;
    }

    public void setStandardPrecision(Integer standardPrecision) {
        this.standardPrecision = standardPrecision;
    }

    public Integer getCostingPrecision() {
        return costingPrecision;
    }

    public void setCostingPrecision(Integer costingPrecision) {
        this.costingPrecision = costingPrecision;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}
