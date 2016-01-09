package ke.co.suncha.tembo.tenant.products.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;
import ke.co.suncha.tembo.tenant.products.attributes.values.AttributeValue;

import java.io.Serializable;
import java.util.List;

/**
 * Created by maitha.manyala on 8/25/15.
 */
public class ProductAttribute extends BaseEntity implements Serializable {
    private long productAttributeId;
    private String name;
    private String description = "Not Available";
    private Boolean active = true;
    private AttributeType attributeType = AttributeType.TEXT;
    private String caption;
    private Boolean mandatory = false;
    private Boolean list = false;
    private Boolean instance = false;
    private Boolean unique = false;
    private String otherName;
    private String value;

    @JsonIgnore
    private Tenant tenant;
    private List<AttributeValue> attributeValues;

    public long getProductAttributeId() {
        return productAttributeId;
    }

    public void setProductAttributeId(long productAttributeId) {
        this.productAttributeId = productAttributeId;
    }

    public AttributeType getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(AttributeType attributeType) {
        this.attributeType = attributeType;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Boolean getMandatory() {
        return mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    public Boolean getInstance() {
        return instance;
    }

    public void setInstance(Boolean instance) {
        this.instance = instance;
    }

    public Boolean getUnique() {
        return unique;
    }

    public void setUnique(Boolean unique) {
        this.unique = unique;
    }

    public List<AttributeValue> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(List<AttributeValue> attributeValues) {
        this.attributeValues = attributeValues;
    }

    public Boolean isList() {
        if (this.getAttributeType() == AttributeType.LIST) {
            this.list = true;
        }
        return list;
    }

    public String getOtherName() {
        if (this.getName() != null) {
            this.otherName = this.getName().trim().replace(" ", "").toLowerCase();
        }
        return otherName;
    }


    public String getValue() {
        return value;
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
}
