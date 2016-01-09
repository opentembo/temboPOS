package ke.co.suncha.tembo.tenant.products.attributes.set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;
import ke.co.suncha.tembo.tenant.products.attributes.ProductAttribute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maitha.manyala on 8/26/15.
 */
public class ProductAttributeSet extends BaseEntity implements Serializable {
    private long productAttributeSetId;
    private String name;
    private String description = "Not Available";
    private Boolean active = true;
    private List<ProductAttribute> productAttributes;
    @JsonIgnore
    private Tenant tenant;

    public long getProductAttributeSetId() {
        return productAttributeSetId;
    }

    public void setProductAttributeSetId(long productAttributeSetId) {
        this.productAttributeSetId = productAttributeSetId;
    }

    public List<ProductAttribute> getProductAttributes() {
        if (productAttributes == null) {
            productAttributes = new ArrayList<>();
        }
        return productAttributes;
    }

    public void setProductAttributes(List<ProductAttribute> productAttributes) {
        this.productAttributes = productAttributes;
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
