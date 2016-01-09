package ke.co.suncha.tembo.tenant.documents.inventory.tax;

import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;
import ke.co.suncha.tembo.tenant.documents.inventory.Inventory;
import ke.co.suncha.tembo.tenant.documents.Document;
import ke.co.suncha.tembo.tenant.products.taxes.TaxRate;
import java.io.Serializable;

/**
 * Created by maitha.manyala on 11/15/15.
 */
public class InventoryTax extends BaseEntity implements Serializable {
    private Long inventoryTaxId;
    private Document document;
    private Inventory inventory;
    private TaxRate taxRate;
    private Integer percentage = 0;
    private Long parentTaxRate = 0l;
    private Boolean documentLevel = false;
    private Double taxableAmount = 0d;
    private Double taxAmount = 0d;

    public Long getInventoryTaxId() {
        return inventoryTaxId;
    }

    public void setInventoryTaxId(Long inventoryTaxId) {
        this.inventoryTaxId = inventoryTaxId;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public TaxRate getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(TaxRate taxRate) {
        this.taxRate = taxRate;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public Long getParentTaxRate() {
        return parentTaxRate;
    }

    public void setParentTaxRate(Long parentTaxRate) {
        this.parentTaxRate = parentTaxRate;
    }

    public Boolean getDocumentLevel() {
        return documentLevel;
    }

    public void setDocumentLevel(Boolean documentLevel) {
        this.documentLevel = documentLevel;
    }

    public Double getTaxableAmount() {
        return taxableAmount;
    }

    public void setTaxableAmount(Double taxableAmount) {
        this.taxableAmount = taxableAmount;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }
}
