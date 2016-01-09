package ke.co.suncha.tembo.tenant.products.taxes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.products.taxes.categories.TaxCategory;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by maitha.manyala on 8/28/15.
 */
public class TaxRate extends BaseEntity implements Serializable, Comparable<TaxRate> {
    private long taxRateId;
    private String name;
    private String description = "Not Available";
    private Boolean active = true;
    private Calendar validFrom = Calendar.getInstance();
    private Boolean documentLevel = false;
    private TaxRateType taxRateType = TaxRateType.SALES_PURCHASE;
    private Integer rate = 0;
    private Long parentTaxRateId = 0L;

    @JsonIgnore
    private TaxCategory taxCategory;
    private Tenant tenant;

    public long getTaxRateId() {
        return taxRateId;
    }

    public void setTaxRateId(long taxRateId) {
        this.taxRateId = taxRateId;
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

    public Calendar getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Calendar validFrom) {
        this.validFrom = validFrom;
    }

    public Boolean getDocumentLevel() {
        return documentLevel;
    }

    public void setDocumentLevel(Boolean documentLevel) {
        this.documentLevel = documentLevel;
    }

    public TaxRateType getTaxRateType() {
        return taxRateType;
    }

    public void setTaxRateType(TaxRateType taxRateType) {
        this.taxRateType = taxRateType;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Long getParentTaxRateId() {
        return parentTaxRateId;
    }

    public void setParentTaxRateId(Long parentTaxRateId) {
        this.parentTaxRateId = parentTaxRateId;
    }

    public TaxCategory getTaxCategory() {
        return taxCategory;
    }

    public void setTaxCategory(TaxCategory taxCategory) {
        this.taxCategory = taxCategory;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public int compareTo(TaxRate taxRate) {
        Long parentId = ((TaxRate) taxRate).getParentTaxRateId();

        //ascending order
        Long result = this.parentTaxRateId - parentId;
        return Integer.valueOf(result.toString());
    }
}
