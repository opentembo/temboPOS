package ke.co.suncha.tembo.tenant.prices.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.prices.versions.PriceListVersion;
import ke.co.suncha.tembo.tenant.products.Product;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;
import java.io.Serializable;

/**
 * Created by maitha.manyala on 9/3/15.
 */
public class ProductPrice extends BaseEntity implements Serializable {
    private long productPriceId;

    private Double limitPrice = 0.0;

    private Double listPrice = 0.0;

    private Boolean active = true;

    private PriceListVersion priceListVersion;
    private Product product;

    @JsonIgnore
    private Tenant tenant;

    public long getProductPriceId() {
        return productPriceId;
    }

    public void setProductPriceId(long productPriceId) {
        this.productPriceId = productPriceId;
    }

    public Double getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(Double limitPrice) {
        this.limitPrice = limitPrice;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public PriceListVersion getPriceListVersion() {
        return priceListVersion;
    }

    public void setPriceListVersion(PriceListVersion priceListVersion) {
        this.priceListVersion = priceListVersion;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}
