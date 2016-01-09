package ke.co.suncha.tembo.tenant.partner;

import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.utils.address.Address;
import ke.co.suncha.tembo.tenant.partner.groups.BusinessPartnerGroup;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;
import ke.co.suncha.tembo.tenant.prices.versions.PriceListVersion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maitha.manyala on 9/9/15.
 */
public class BusinessPartner extends BaseEntity implements Serializable {
    private long businessPartnerId;
    private String name;
    private String description = "Not Available";
    private Boolean active = true;
    private Integer partnerType = 0;
    private String refNo = "";
    private String taxId = "";
    private String phoneNumber = "";
    private String emailAddress = "";
    private Double openBalance = 0.0;
    private Double creditLimit = 0.0;
    private BusinessPartnerGroup businessPartnerGroup;
    private PriceListVersion priceListVersion;
    private Tenant tenant;
    private String searchKey = "";
    private List<Address> addresses;


    public long getBusinessPartnerId() {
        return businessPartnerId;
    }

    public void setBusinessPartnerId(long businessPartnerId) {
        this.businessPartnerId = businessPartnerId;
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

    public Integer getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(Integer partnerType) {
        this.partnerType = partnerType;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Double getOpenBalance() {
        return openBalance;
    }

    public void setOpenBalance(Double openBalance) {
        this.openBalance = openBalance;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BusinessPartnerGroup getBusinessPartnerGroup() {
        return businessPartnerGroup;
    }

    public void setBusinessPartnerGroup(BusinessPartnerGroup businessPartnerGroup) {
        this.businessPartnerGroup = businessPartnerGroup;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public PriceListVersion getPriceListVersion() {
        return priceListVersion;
    }

    public void setPriceListVersion(PriceListVersion priceListVersion) {
        this.priceListVersion = priceListVersion;
    }

    public List<Address> getAddresses() {
        if (addresses == null) {
            addresses = new ArrayList<>();
        }
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    @Override
    public String toString() {
        return "BusinessPartner{" +
                "businessPartnerId=" + businessPartnerId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", partnerType=" + partnerType +
                ", refNo='" + refNo + '\'' +
                ", taxId='" + taxId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", openBalance=" + openBalance +
                ", creditLimit=" + creditLimit +
                '}';
    }
}
