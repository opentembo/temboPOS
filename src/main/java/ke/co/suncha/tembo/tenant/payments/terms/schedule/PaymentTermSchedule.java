package ke.co.suncha.tembo.tenant.payments.terms.schedule;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.payments.terms.PaymentTerm;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;
import java.io.Serializable;

/**
 * Created by maitha.manyala on 9/4/15.
 */

public class PaymentTermSchedule extends BaseEntity implements Serializable {
    private long paymentTermScheduleId;
    private Integer percentage = 0;
    private Integer netDays = 0;
    private Integer discountDays = 0;
    private Integer discount = 0;
    private Boolean active = false;
    @JsonIgnore
    private PaymentTerm paymentTerm;

    @JsonIgnore
    private Tenant tenant;

    public long getPaymentTermScheduleId() {
        return paymentTermScheduleId;
    }

    public void setPaymentTermScheduleId(long paymentTermScheduleId) {
        this.paymentTermScheduleId = paymentTermScheduleId;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public Integer getNetDays() {
        return netDays;
    }

    public void setNetDays(Integer netDays) {
        this.netDays = netDays;
    }

    public Integer getDiscountDays() {
        return discountDays;
    }

    public void setDiscountDays(Integer discountDays) {
        this.discountDays = discountDays;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public PaymentTerm getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(PaymentTerm paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }
}
