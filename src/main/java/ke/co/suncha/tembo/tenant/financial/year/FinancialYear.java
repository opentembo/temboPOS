package ke.co.suncha.tembo.tenant.financial.year;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.financial.calendar.FinancialCalendar;
import ke.co.suncha.tembo.tenant.financial.period.FinancialPeriod;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maitha.manyala on 8/19/15.
 */
public class FinancialYear extends BaseEntity implements Serializable {
    private long financialYearId;
    private Integer name;
    private String description = "Not Available";
    private Boolean active = false;

    @JsonIgnore
    private FinancialCalendar financialCalendar;
    private Tenant tenant;

    @JsonIgnore
    private List<FinancialPeriod> financialPeriods;

    public long getFinancialYearId() {
        return financialYearId;
    }

    public void setFinancialYearId(long financialYearId) {
        this.financialYearId = financialYearId;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
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

    public FinancialCalendar getFinancialCalendar() {
        return financialCalendar;
    }

    public void setFinancialCalendar(FinancialCalendar financialCalendar) {
        this.financialCalendar = financialCalendar;
    }

    public List<FinancialPeriod> getFinancialPeriods() {
        if(financialPeriods==null){
            financialPeriods= new ArrayList<>();
        }
        return financialPeriods;
    }

    public void setFinancialPeriods(List<FinancialPeriod> financialPeriods) {
        this.financialPeriods = financialPeriods;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public String toString() {
        return "FinancialYear{" +
                "financialYearId=" + financialYearId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
//                ", financialCalendar=" + financialCalendar +
                '}';
    }
}
