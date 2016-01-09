package ke.co.suncha.tembo.tenant.products;

import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.organization.warehousing.Warehouse;
import ke.co.suncha.tembo.tenant.products.attributes.set.ProductAttributeSet;
import ke.co.suncha.tembo.tenant.products.categories.ProductCategory;
import ke.co.suncha.tembo.tenant.products.images.ProductImage;
import ke.co.suncha.tembo.tenant.products.taxes.categories.TaxCategory;
import ke.co.suncha.tembo.tenant.products.types.ProductType;
import ke.co.suncha.tembo.tenant.products.uom.UnitOfMeasure;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maitha.manyala on 9/1/15.
 */
public class Product extends BaseEntity implements Serializable {
    private long productId;
    private String name;
    private String description;
    private String comments;
    private String upc;
    private String sku;
    private Boolean active = true;
    private Boolean purchased = true;
    private Boolean sold = true;
    private Boolean manufactured = true;
    private Boolean hasAttributeSet = false;
    private Boolean trackInventory = true;
    private List<ProductImage> productImages;
    private List<Warehouse> warehouses;
    private ProductCategory productCategory;
    private TaxCategory taxCategory;
    private UnitOfMeasure unitOfMeasure;
    private ProductType productType;
    private ProductAttributeSet productAttributeSet;
    private Tenant tenant;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getPurchased() {
        return purchased;
    }

    public void setPurchased(Boolean purchased) {
        this.purchased = purchased;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    public Boolean getManufactured() {
        return manufactured;
    }

    public void setManufactured(Boolean manufactured) {
        this.manufactured = manufactured;
    }

    public Boolean getTrackInventory() {
        return trackInventory;
    }

    public void setTrackInventory(Boolean trackInventory) {
        this.trackInventory = trackInventory;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public TaxCategory getTaxCategory() {
        return taxCategory;
    }

    public void setTaxCategory(TaxCategory taxCategory) {
        this.taxCategory = taxCategory;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ProductAttributeSet getProductAttributeSet() {
        return productAttributeSet;
    }

    public void setProductAttributeSet(ProductAttributeSet productAttributeSet) {
        this.productAttributeSet = productAttributeSet;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Boolean getHasAttributeSet() {
        if (this.getProductAttributeSet() != null) {
            this.hasAttributeSet = true;
        }
        return hasAttributeSet;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public List<Warehouse> getWarehouses() {
        if (warehouses == null) {
            warehouses = new ArrayList<>();
        }
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }
}
