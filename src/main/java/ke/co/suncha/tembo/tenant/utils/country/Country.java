package ke.co.suncha.tembo.tenant.utils.country;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;

import java.io.Serializable;

/**
 * Created by maitha.manyala on 10/30/15.
 */
public class Country implements Serializable {
    private long countryId;
    private String code;
    private String name;

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
