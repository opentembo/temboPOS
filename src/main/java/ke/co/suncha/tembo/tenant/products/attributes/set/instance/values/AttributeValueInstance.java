package ke.co.suncha.tembo.tenant.products.attributes.set.instance.values;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ke.co.suncha.tembo.tenant.products.attributes.ProductAttribute;
import ke.co.suncha.tembo.tenant.products.attributes.set.instance.AttributeSetInstance;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;

import java.io.Serializable;

/**
 * Created by maitha.manyala on 9/21/15.
 */

public class AttributeValueInstance extends BaseEntity implements Serializable {
    private long attributeValueInstanceId;
    @JsonBackReference
    private AttributeSetInstance attributeSetInstance;
    private ProductAttribute productAttribute;
    private String value;

    public long getAttributeValueInstanceId() {
        return attributeValueInstanceId;
    }

    public void setAttributeValueInstanceId(long attributeValueInstanceId) {
        this.attributeValueInstanceId = attributeValueInstanceId;
    }

    public AttributeSetInstance getAttributeSetInstance() {
        return attributeSetInstance;
    }

    public void setAttributeSetInstance(AttributeSetInstance attributeSetInstance) {
        this.attributeSetInstance = attributeSetInstance;
    }

    public ProductAttribute getProductAttribute() {
        return productAttribute;
    }

    public void setProductAttribute(ProductAttribute productAttribute) {
        this.productAttribute = productAttribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AttributeValueInstance{" +
                "value='" + value + '\'' +
                ", productAttribute=" + productAttribute +
                '}';
    }
}
