package ke.co.suncha.tembo.tenant.products.taxes.categories;

import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;
import ke.co.suncha.tembo.tenant.products.images.ProductImage;
import ke.co.suncha.tembo.tenant.products.taxes.TaxRate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maitha.manyala on 8/25/15.
 */
public class TaxCategory extends BaseEntity implements Serializable {
    private long taxCategoryId;
    private String name;
    private String description = "Not Available";
    private Boolean active = true;
    private Tenant tenant;
    private List<TaxRate> taxRates;

    public long getTaxCategoryId() {
        return taxCategoryId;
    }

    public void setTaxCategoryId(long taxCategoryId) {
        this.taxCategoryId = taxCategoryId;
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

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public List<TaxRate> getTaxRates() {
        if (taxRates == null) {
            taxRates = new ArrayList<>();
        }
        return taxRates;
    }

    public void setTaxRates(List<TaxRate> taxRates) {
        this.taxRates = taxRates;
    }
}
