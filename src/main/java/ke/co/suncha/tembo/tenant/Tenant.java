package ke.co.suncha.tembo.tenant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;
import ke.co.suncha.tembo.tenant.financial.calendar.FinancialCalendar;
import ke.co.suncha.tembo.tenant.utils.currencies.Currency;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by maitha.manyala on 9/28/15.
 */
public class Tenant extends BaseEntity implements Serializable {
    private Long tenantId;

    private String name;

    private String description="";

    private Boolean active = true;

    private String webAddress;

    @JsonIgnore
    private List<FinancialCalendar> financialCalendars;

    private Currency currency;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public List<FinancialCalendar> getFinancialCalendars() {
        return financialCalendars;
    }

    public void setFinancialCalendars(List<FinancialCalendar> financialCalendars) {
        this.financialCalendars = financialCalendars;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
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
}
