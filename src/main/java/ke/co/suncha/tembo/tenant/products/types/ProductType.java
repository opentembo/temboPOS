package ke.co.suncha.tembo.tenant.products.types;

import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;

import java.io.Serializable;

/**
 * Created by maitha.manyala on 8/25/15.
 */

public class ProductType extends BaseEntity implements Serializable {
    private long productTypeId;

    private String name;

    private String description = "Not Available";

    public long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(long productTypeId) {
        this.productTypeId = productTypeId;
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
}
