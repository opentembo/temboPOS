package ke.co.suncha.tembo.tenant.products.images;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.tenant.products.Product;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;

import java.io.Serializable;

/**
 * Created by maitha.manyala on 9/1/15.
 */
public class ProductImage extends BaseEntity implements Serializable {
    private long productImageId;
    private String name;
    private String image;
    @JsonIgnore
    private Product product;

    public long getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(long productImageId) {
        this.productImageId = productImageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
