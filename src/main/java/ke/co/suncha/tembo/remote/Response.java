package ke.co.suncha.tembo.remote;

/**
 * Created by maitha.manyala on 1/7/16.
 */
public class Response {
    private Boolean requestError = true;
    private Boolean internalError = false;
    private String payload;

    public Boolean isRequestError() {
        return requestError;
    }

    public void setRequestError(Boolean requestError) {
        this.requestError = requestError;
    }

    public Boolean isInternalError() {
        return internalError;
    }

    public void setInternalError(Boolean internalError) {
        this.internalError = internalError;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
