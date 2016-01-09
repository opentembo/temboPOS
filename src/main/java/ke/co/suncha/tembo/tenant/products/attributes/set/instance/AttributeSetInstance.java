package ke.co.suncha.tembo.tenant.products.attributes.set.instance;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ke.co.suncha.tembo.tenant.products.attributes.set.ProductAttributeSet;
import ke.co.suncha.tembo.tenant.products.attributes.set.instance.values.AttributeValueInstance;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maitha.manyala on 9/21/15.
 */

public class AttributeSetInstance extends BaseEntity implements Serializable {
    private long attributeSetInstanceId;
    private ProductAttributeSet productAttributeSet;
    //this is what i need to fetch
    @JsonManagedReference
    private List<AttributeValueInstance> attributeValueInstances;

    public long getAttributeSetInstanceId() {
        return attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(long attributeSetInstanceId) {
        this.attributeSetInstanceId = attributeSetInstanceId;
    }

    public ProductAttributeSet getProductAttributeSet() {
        return productAttributeSet;
    }

    public void setProductAttributeSet(ProductAttributeSet productAttributeSet) {
        this.productAttributeSet = productAttributeSet;
    }

    public List<AttributeValueInstance> getAttributeValueInstances() {
        if (attributeValueInstances == null) {
            attributeValueInstances = new ArrayList<>();
        }
        return attributeValueInstances;
    }

    public void setAttributeValueInstances(List<AttributeValueInstance> attributeValueInstances) {
        this.attributeValueInstances = attributeValueInstances;
    }
}
