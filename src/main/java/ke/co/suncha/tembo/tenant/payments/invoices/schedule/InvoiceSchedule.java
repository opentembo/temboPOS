package ke.co.suncha.tembo.tenant.payments.invoices.schedule;

import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;

import java.io.Serializable;

/**
 * Created by maitha.manyala on 9/7/15.
 */
public class InvoiceSchedule extends BaseEntity implements Serializable {
    private long invoiceScheduleId;
    private String name;
    private String description = "Not Available";
    private Boolean active = true;
    private Boolean amountLimit = false;
    private Boolean isDefault = false;
    private Double amount = 0.0;
    private Integer invoiceDay = 0;
    private Integer invoiceDayCutOff = 0;
    private InvoiceFrequency invoiceFrequency = InvoiceFrequency.MONTHLY;
    private Tenant tenant;

    public long getInvoiceScheduleId() {
        return invoiceScheduleId;
    }

    public void setInvoiceScheduleId(long invoiceScheduleId) {
        this.invoiceScheduleId = invoiceScheduleId;
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

    public Boolean getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(Boolean amountLimit) {
        this.amountLimit = amountLimit;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getInvoiceDay() {
        return invoiceDay;
    }

    public void setInvoiceDay(Integer invoiceDay) {
        this.invoiceDay = invoiceDay;
    }

    public Integer getInvoiceDayCutOff() {
        return invoiceDayCutOff;
    }

    public void setInvoiceDayCutOff(Integer invoiceDayCutOff) {
        this.invoiceDayCutOff = invoiceDayCutOff;
    }

    public InvoiceFrequency getInvoiceFrequency() {
        return invoiceFrequency;
    }

    public void setInvoiceFrequency(InvoiceFrequency invoiceFrequency) {
        this.invoiceFrequency = invoiceFrequency;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}
