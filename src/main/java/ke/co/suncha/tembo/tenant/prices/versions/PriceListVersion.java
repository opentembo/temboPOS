package ke.co.suncha.tembo.tenant.prices.versions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;
import ke.co.suncha.tembo.tenant.prices.PriceList;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.Serializable;

/**
 * Created by maitha.manyala on 8/31/15.
 */
public class PriceListVersion extends BaseEntity implements Serializable {
    private long priceListVersionId;
    private String name;
    private String description = "Not Available";
    private Boolean active = true;
    private DateTime validFrom = new DateTime(DateTimeZone.UTC);

    @JsonIgnore
    private PriceList priceList;

    @JsonIgnore
    private Tenant tenant;

    public long getPriceListVersionId() {
        return priceListVersionId;
    }

    public void setPriceListVersionId(long priceListVersionId) {
        this.priceListVersionId = priceListVersionId;
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

    public DateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(DateTime validFrom) {
        this.validFrom = validFrom;
    }

    public PriceList getPriceList() {
        return priceList;
    }

    public void setPriceList(PriceList priceList) {
        this.priceList = priceList;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}
