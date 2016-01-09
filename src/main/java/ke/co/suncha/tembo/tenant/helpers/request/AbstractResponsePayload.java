package ke.co.suncha.tembo.tenant.helpers.request;

/**
 * Created by maitha.manyala on 10/6/15.
 */
public abstract class AbstractResponsePayload {
    private Boolean authorized = false;

    public Boolean getAuthorized() {
        return authorized;
    }

    public void setAuthorized(Boolean authorized) {
        this.authorized = authorized;
    }
}
