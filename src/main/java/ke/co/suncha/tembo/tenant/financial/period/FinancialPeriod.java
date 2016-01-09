package ke.co.suncha.tembo.tenant.financial.period;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ke.co.suncha.tembo.tenant.financial.year.FinancialYear;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.Serializable;


/**
 * Created by maitha.manyala on 8/19/15.
 */
public class FinancialPeriod extends BaseEntity implements Serializable {
    private long financialPeriodId;
    private String name;
    private Integer periodNumber;
    private DateTime startDate = new DateTime(DateTimeZone.UTC);
    private DateTime endDate = new DateTime(DateTimeZone.UTC);
    private Boolean active = false;
    @JsonIgnore
    private FinancialYear financialYear;

    public long getFinancialPeriodId() {
        return financialPeriodId;
    }

    public void setFinancialPeriodId(long financialPeriodId) {
        this.financialPeriodId = financialPeriodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPeriodNumber() {
        return periodNumber;
    }

    public void setPeriodNumber(Integer periodNumber) {
        this.periodNumber = periodNumber;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public FinancialYear getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(FinancialYear financialYear) {
        this.financialYear = financialYear;
    }
}
