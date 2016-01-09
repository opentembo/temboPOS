package ke.co.suncha.tembo.tenant.documents;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;
import ke.co.suncha.tembo.tenant.documents.inventory.Inventory;
import ke.co.suncha.tembo.tenant.documents.inventory.InvoiceTerm;
import ke.co.suncha.tembo.tenant.organization.BusinessUnit;
import ke.co.suncha.tembo.tenant.organization.warehousing.Warehouse;
import ke.co.suncha.tembo.tenant.partner.BusinessPartner;
import ke.co.suncha.tembo.tenant.payments.invoices.schedule.InvoiceSchedule;
import ke.co.suncha.tembo.tenant.payments.terms.PaymentTerm;
import ke.co.suncha.tembo.tenant.prices.versions.PriceListVersion;
import ke.co.suncha.tembo.tenant.utils.address.Address;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maitha.manyala on 11/15/15.
 */

public class Document extends BaseEntity implements Serializable {
    private long documentId;
    private Boolean edit = true;
    private String docNumber;
    private String orderRef;
    private Double totalTax = 0d;
    private Double totalWithoutTax = 0d;
    private Double totalAll = 0d;
    private Double balance = 0d;
    private Integer quantity = 0;
    private Long parentId = 0l;
    private String description = "";
    private DateTime docDate = new DateTime(DateTimeZone.UTC);
    private DateTime accountingDate = new DateTime(DateTimeZone.UTC);
    private DateTime deliveryDate = new DateTime(DateTimeZone.UTC);
    private Tenant tenant;
    private BusinessUnit businessUnit;
    private Warehouse warehouse;
    private BusinessPartner businessPartner;
    private Address address;
    private PriceListVersion priceListVersion;
    private PaymentTerm paymentTerm;
    private InvoiceSchedule invoiceSchedule;
    private Integer documentStatus = DocumentStatus.DRAFT;
    private Integer documentType = 0;
    private Integer childDocumentType = 0; //applicable to sales orders
    private String docStatus;

    private Integer invoiceTerm = InvoiceTerm.IMMEDIATE;

    @JsonIgnore
    private List<Inventory> inventoryList;

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(long documentId) {
        this.documentId = documentId;
    }

    public DateTime getDocDate() {
        return docDate;
    }

    public void setDocDate(DateTime docDate) {
        this.docDate = docDate;
    }

    public DateTime getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(DateTime accountingDate) {
        this.accountingDate = accountingDate;
    }

    public List<Inventory> getInventoryList() {
        if (inventoryList == null) {
            inventoryList = new ArrayList<>();
        }
        return inventoryList;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public DateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(DateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
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

    public BusinessPartner getBusinessPartner() {
        return businessPartner;
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        this.businessPartner = businessPartner;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PriceListVersion getPriceListVersion() {
        return priceListVersion;
    }

    public void setPriceListVersion(PriceListVersion priceListVersion) {
        this.priceListVersion = priceListVersion;
    }

    public PaymentTerm getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(PaymentTerm paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public InvoiceSchedule getInvoiceSchedule() {
        return invoiceSchedule;
    }

    public void setInvoiceSchedule(InvoiceSchedule invoiceSchedule) {
        this.invoiceSchedule = invoiceSchedule;
    }

    public Integer getDocumentType() {
        return documentType;
    }

    public void setDocumentType(Integer documentType) {
        this.documentType = documentType;
    }

    public Integer getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(Integer documentStatus) {
        this.documentStatus = documentStatus;
    }

    public Integer getInvoiceTerm() {
        return invoiceTerm;
    }

    public void setInvoiceTerm(Integer invoiceTerm) {
        this.invoiceTerm = invoiceTerm;
    }

    public Boolean canEdit() {
        if (this.getDocumentStatus() != null) {
            if (this.getDocumentStatus() != DocumentStatus.DRAFT) {
                this.edit = false;
            }
        }
        return edit;
    }

    public String getDocStatus() {
        if (documentStatus == DocumentStatus.DRAFT) {
            docStatus = "DRAFT";
        } else if (documentStatus == DocumentStatus.POSTED) {
            docStatus = "POSTED";
        } else if (documentStatus == DocumentStatus.PROCESSING) {
            docStatus = "PROCESSING";
        } else if (documentStatus == DocumentStatus.VOIDED) {
            docStatus = "VOIDED";
        } else if (documentStatus == DocumentStatus.CLOSED) {
            docStatus = "CLOSED";
        }
        return docStatus;
    }

    public Integer getChildDocumentType() {
        return childDocumentType;
    }

    public void setChildDocumentType(Integer childDocumentType) {
        this.childDocumentType = childDocumentType;
    }

    public Double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(Double totalTax) {
        this.totalTax = totalTax;
    }

    public Double getTotalWithoutTax() {
        return totalWithoutTax;
    }

    public void setTotalWithoutTax(Double totalWithoutTax) {
        this.totalWithoutTax = totalWithoutTax;
    }

    public Double getTotalAll() {
        return totalAll;
    }

    public void setTotalAll(Double totalAll) {
        this.totalAll = totalAll;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Document{" +
                "  documentId=" + documentId +
                ", edit=" + edit +
                ", docNumber='" + docNumber + '\'' +
                ", orderRef='" + orderRef + '\'' +
                ", totalTax=" + totalTax +
                ", totalWithoutTax=" + totalWithoutTax +
                ", totalAll=" + totalAll +
                ", balance=" + balance +
                ", quantity=" + quantity +
                ", parentId=" + parentId +
                ", description='" + description + '\'' +
                ", docDate=" + docDate +
                ", accountingDate=" + accountingDate +
                ", deliveryDate=" + deliveryDate +
                ", documentStatus=" + documentStatus +
                ", docStatus='" + docStatus + '\'' +
                '}';
    }
}
