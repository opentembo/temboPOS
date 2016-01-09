package ke.co.suncha.tembo.tenant.documents.inventory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;
import ke.co.suncha.tembo.tenant.documents.Document;
import ke.co.suncha.tembo.tenant.documents.DocumentType;
import ke.co.suncha.tembo.tenant.documents.inventory.tax.InventoryTax;
import ke.co.suncha.tembo.tenant.organization.BusinessUnit;
import ke.co.suncha.tembo.tenant.organization.warehousing.Warehouse;
import ke.co.suncha.tembo.tenant.organization.warehousing.locator.WarehouseLocator;
import ke.co.suncha.tembo.tenant.prices.versions.PriceListVersion;
import ke.co.suncha.tembo.tenant.products.Product;
import ke.co.suncha.tembo.tenant.products.attributes.set.instance.AttributeSetInstance;
import ke.co.suncha.tembo.tenant.products.taxes.categories.TaxCategory;
import ke.co.suncha.tembo.tenant.products.uom.UnitOfMeasure;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maitha.manyala on 11/13/15.
 */

public class Inventory extends BaseEntity implements Serializable {
    private long inventoryId;
    private Integer quantity = 1;
    private Integer lineNumber = 0;
    private Boolean sold = false;
    private Boolean edit = false;
    private Boolean lineValid = false;
    private Integer posted = 0;
    private Integer movement = 0;
    private String attributeValues;
    private Document document;
    private UnitOfMeasure unitOfMeasure;
    private AttributeSetInstance attributeSetInstance;
    private Integer documentType = DocumentType.GOODS_RECEIPT;
    private Integer childDocumentType = 0; //applicable to sales orders
    private Tenant tenant;
    private BusinessUnit businessUnit;
    private Warehouse warehouse;
    private WarehouseLocator warehouseLocator;
    private PriceListVersion priceListVersion;
    private TaxCategory taxCategory;
    private Double price = 0d;
    private Double listPrice = 0d;
    private Double limitPrice = 0d;
    private Double taxAmount = 0d;
    private Double amount = 0d;
    private Double amountAndTax = 0d;
    private Product product;
    private Boolean editAttributes;
    @JsonIgnore
    private List<InventoryTax> inventoryTaxes;

    public long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getMovement() {
        if (documentType == DocumentType.GOODS_RECEIPT) {
            this.movement = 0; //IN
        } else if (documentType == DocumentType.SALES_ORDER) {
            this.movement = 1; //Booked
        } else if (documentType == DocumentType.DELIVERY_NOTE) {
            this.movement = 2; //Out
        }
        return movement;
    }

    public void setMovement(Integer movement) {
        this.movement = movement;
    }


    public String getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(String attributeValues) {
        this.attributeValues = attributeValues;
    }

    public AttributeSetInstance getAttributeSetInstance() {
        return attributeSetInstance;
    }

    public void setAttributeSetInstance(AttributeSetInstance attributeSetInstance) {
        this.attributeSetInstance = attributeSetInstance;
    }

    public Integer getDocumentType() {
        return documentType;
    }

    public void setDocumentType(Integer documentType) {
        this.documentType = documentType;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public BusinessUnit getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(BusinessUnit businessUnit) {
        this.businessUnit = businessUnit;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public WarehouseLocator getWarehouseLocator() {
        return warehouseLocator;
    }

    public void setWarehouseLocator(WarehouseLocator warehouseLocator) {
        this.warehouseLocator = warehouseLocator;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Boolean getLineValid() {
        return lineValid;
    }

    public void setLineValid(Boolean lineValid) {
        this.lineValid = lineValid;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public PriceListVersion getPriceListVersion() {
        return priceListVersion;
    }

    public void setPriceListVersion(PriceListVersion priceListVersion) {
        this.priceListVersion = priceListVersion;
    }

    public TaxCategory getTaxCategory() {
        return taxCategory;
    }

    public void setTaxCategory(TaxCategory taxCategory) {
        this.taxCategory = taxCategory;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(Double limitPrice) {
        this.limitPrice = limitPrice;
    }


    public Double getAmountAndTax() {
        return amountAndTax;
    }

    public void setAmountAndTax(Double amountAndTax) {
        this.amountAndTax = amountAndTax;
    }

    public List<InventoryTax> getInventoryTaxes() {
        if (inventoryTaxes == null) {
            inventoryTaxes = new ArrayList<>();
        }
        return inventoryTaxes;
    }

    public void setInventoryTaxes(List<InventoryTax> inventoryTaxes) {
        this.inventoryTaxes = inventoryTaxes;
    }

    public Boolean getEdit() {
        if (this.getDocument() != null) {
            this.edit = this.getDocument().canEdit();
        }
        return edit;
    }

    public Integer getPosted() {
        return posted;
    }

    public void setPosted(Integer posted) {
        this.posted = posted;
    }

    public Integer getChildDocumentType() {
        return childDocumentType;
    }

    public void setChildDocumentType(Integer childDocumentType) {
        this.childDocumentType = childDocumentType;
    }


    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

}
