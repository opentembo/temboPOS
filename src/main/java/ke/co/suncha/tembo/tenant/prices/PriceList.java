package ke.co.suncha.tembo.tenant.prices;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;
import ke.co.suncha.tembo.tenant.utils.currencies.Currency;
import ke.co.suncha.tembo.tenant.organization.BusinessUnit;

import java.io.Serializable;

/**
 * Created by maitha.manyala on 8/31/15.
 */
public class PriceList extends BaseEntity implements Serializable {
    private long priceListId;

    private String name;
    private String description = "Not Available";
    private Boolean active = true;
    private Boolean tenantLevel = true;
    private BusinessUnit businessUnit;
    private Currency currency;
    private Integer pricePrecision = 2;
    private Boolean enforcePriceLimit = true;
    private Boolean salesPriceList = true;
    private Boolean priceIncludesTax = false;
    @JsonIgnore
    private Tenant tenant;

    public long getPriceListId() {
        return priceListId;
    }

    public void setPriceListId(long priceListId) {
        this.priceListId = priceListId;
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Integer getPricePrecision() {
        return pricePrecision;
    }

    public void setPricePrecision(Integer pricePrecision) {
        this.pricePrecision = pricePrecision;
    }

    public Boolean getEnforcePriceLimit() {
        return enforcePriceLimit;
    }

    public void setEnforcePriceLimit(Boolean enforcePriceLimit) {
        this.enforcePriceLimit = enforcePriceLimit;
    }

    public Boolean getSalesPriceList() {
        return salesPriceList;
    }

    public void setSalesPriceList(Boolean salesPriceList) {
        this.salesPriceList = salesPriceList;
    }

    public Boolean getPriceIncludesTax() {
        return priceIncludesTax;
    }

    public void setPriceIncludesTax(Boolean priceIncludesTax) {
        this.priceIncludesTax = priceIncludesTax;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Boolean getTenantLevel() {
        return tenantLevel;
    }

    public void setTenantLevel(Boolean tenantLevel) {
        this.tenantLevel = tenantLevel;
    }

    public BusinessUnit getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(BusinessUnit businessUnit) {
        this.businessUnit = businessUnit;
    }
}
