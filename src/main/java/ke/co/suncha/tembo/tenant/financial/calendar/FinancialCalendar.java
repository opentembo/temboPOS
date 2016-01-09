package ke.co.suncha.tembo.tenant.financial.calendar;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.financial.year.FinancialYear;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by maitha.manyala on 8/19/15.
 */
public class FinancialCalendar extends BaseEntity implements Serializable {
    private long financialCalendarId;
    private String name;
    private String description = "Not Available";
    private Boolean active = true;

    @JsonIgnore
    private List<FinancialYear> financialYears;

    @JsonIgnore
    private Tenant tenant;


    public long getFinancialCalendarId() {
        return financialCalendarId;
    }

    public void setFinancialCalendarId(long financialCalendarId) {
        this.financialCalendarId = financialCalendarId;
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

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<FinancialYear> getFinancialYears() {
        return financialYears;
    }

    public void setFinancialYears(List<FinancialYear> financialYears) {
        this.financialYears = financialYears;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public String toString() {
        return "FinancialCalendar{" +
                "financialCalendarId=" + financialCalendarId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                '}';
    }
}
