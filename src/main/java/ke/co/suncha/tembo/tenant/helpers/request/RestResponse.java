/**
 * @author Maitha Manyala <maithamanyala@gmail.com>
 */
package ke.co.suncha.tembo.tenant.helpers.request;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/*
 * Error information in the response
 */
@XmlRootElement
@JsonSerialize
public class RestResponse extends ResponseEntity<ResponseObject> {

    private Boolean authorized = false;

    public Boolean getAuthorized() {
        return authorized;
    }

    public RestResponse(ResponseObject body, HttpStatus statusCode) {
        super(body, statusCode);
    }

    public Boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(Boolean authorized) {
        this.authorized = authorized;
    }

    public RestResponse created(Object object) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setMessage("Your request has been submitted successfully.");
        responseObject.setPayload(object);
        return new RestResponse(responseObject, HttpStatus.CREATED);
    }

    public RestResponse fetched(Object object) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setMessage("Fetched data successfully.");
        responseObject.setPayload(object);
        return new RestResponse(responseObject, HttpStatus.CREATED);
    }

    public RestResponse exception(Exception ex) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setMessage(ex.getLocalizedMessage());
        responseObject.setPayload("");
        return new RestResponse(responseObject, HttpStatus.EXPECTATION_FAILED);
    }

    public RestResponse expectationFailed(String message) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setMessage(message);
        responseObject.setPayload("");
        return new RestResponse(responseObject, HttpStatus.EXPECTATION_FAILED);
    }
}
