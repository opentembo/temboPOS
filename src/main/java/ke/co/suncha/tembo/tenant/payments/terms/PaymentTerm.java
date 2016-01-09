package ke.co.suncha.tembo.tenant.payments.terms;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.payments.terms.schedule.PaymentTermSchedule;
import ke.co.suncha.tembo.tenant.admin.models.BaseGenericEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by maitha.manyala on 9/4/15.
 */
public class PaymentTerm extends BaseGenericEntity implements Serializable {
    private long paymentTermId;
    private Integer netDays = 0;
    private Boolean nextBusinessDay = true;
    private Integer firstDiscountDays = 0;
    private Integer firstDiscount = 0;
    private Integer secondDiscountDays = 0;
    private Integer secondDiscount = 0;
    private String documentNote;
    private Boolean fixedDueDate = false;
    private Integer fixMonthDay = 0;
    private Integer fixMonthOffset = 0;
    private Boolean isDefault = false;
    private PaymentTermUsage paymentTermUsage = PaymentTermUsage.BOTH;
    @JsonIgnore
    private Tenant tenant;

    @JsonIgnore
    private List<PaymentTermSchedule> paymentTermSchedules;

    public long getPaymentTermId() {
        return paymentTermId;
    }

    public void setPaymentTermId(long paymentTermId) {
        this.paymentTermId = paymentTermId;
    }

    public Integer getNetDays() {
        return netDays;
    }

    public void setNetDays(Integer netDays) {
        this.netDays = netDays;
    }

    public Boolean getNextBusinessDay() {
        return nextBusinessDay;
    }

    public void setNextBusinessDay(Boolean nextBusinessDay) {
        this.nextBusinessDay = nextBusinessDay;
    }

    public Integer getFirstDiscountDays() {
        return firstDiscountDays;
    }

    public void setFirstDiscountDays(Integer firstDiscountDays) {
        this.firstDiscountDays = firstDiscountDays;
    }

    public Integer getFirstDiscount() {
        return firstDiscount;
    }

    public void setFirstDiscount(Integer firstDiscount) {
        this.firstDiscount = firstDiscount;
    }

    public Integer getSecondDiscountDays() {
        return secondDiscountDays;
    }

    public void setSecondDiscountDays(Integer secondDiscountDays) {
        this.secondDiscountDays = secondDiscountDays;
    }

    public Integer getSecondDiscount() {
        return secondDiscount;
    }

    public void setSecondDiscount(Integer secondDiscount) {
        this.secondDiscount = secondDiscount;
    }

    public String getDocumentNote() {
        return documentNote;
    }

    public void setDocumentNote(String documentNote) {
        this.documentNote = documentNote;
    }

    public Boolean getFixedDueDate() {
        return fixedDueDate;
    }

    public void setFixedDueDate(Boolean fixedDueDate) {
        this.fixedDueDate = fixedDueDate;
    }

    public Integer getFixMonthDay() {
        return fixMonthDay;
    }

    public void setFixMonthDay(Integer fixMonthDay) {
        this.fixMonthDay = fixMonthDay;
    }

    public Integer getFixMonthOffset() {
        return fixMonthOffset;
    }

    public void setFixMonthOffset(Integer fixMonthOffset) {
        this.fixMonthOffset = fixMonthOffset;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public PaymentTermUsage getPaymentTermUsage() {
        return paymentTermUsage;
    }

    public void setPaymentTermUsage(PaymentTermUsage paymentTermUsage) {
        this.paymentTermUsage = paymentTermUsage;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public List<PaymentTermSchedule> getPaymentTermSchedules() {
        return paymentTermSchedules;
    }

    public void setPaymentTermSchedules(List<PaymentTermSchedule> paymentTermSchedules) {
        this.paymentTermSchedules = paymentTermSchedules;
    }
}
