package ke.co.suncha.tembo.tenant.products.attributes.values;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.products.attributes.ProductAttribute;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;

import java.io.Serializable;

/**
 * Created by maitha.manyala on 8/26/15.
 */
public class AttributeValue extends BaseEntity implements Serializable {
    private long attributeValueId;
    private String name;
    private Boolean active = true;
    @JsonIgnore
    private ProductAttribute productAttribute;
    @JsonIgnore
    private Tenant tenant;

    public long getAttributeValueId() {
        return attributeValueId;
    }

    public void setAttributeValueId(long attributeValueId) {
        this.attributeValueId = attributeValueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductAttribute getProductAttribute() {
        return productAttribute;
    }

    public void setProductAttribute(ProductAttribute productAttribute) {
        this.productAttribute = productAttribute;
    }

    public Boolean isActive() {
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
}
