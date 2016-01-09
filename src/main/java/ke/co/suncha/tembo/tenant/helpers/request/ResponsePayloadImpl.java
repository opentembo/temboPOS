package ke.co.suncha.tembo.tenant.helpers.request;

import ke.co.suncha.tembo.tenant.helpers.errors.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by maitha.manyala on 10/5/15.
 */
@Component
@Scope("prototype")
public class ResponsePayloadImpl implements ResponsePayload {

    @Autowired
    ResponseObject responseObject;

    private RestResponse restResponse = new RestResponse(new ResponseObject(), HttpStatus.OK);

    @Override
    public RestResponse unauthorized() {
        responseObject.setMessage("Access to this resource denied, please contact your admin.");
        responseObject.setPayload("");
        restResponse = new RestResponse(responseObject, HttpStatus.EXPECTATION_FAILED);
        return restResponse;
    }

    @Override
    public RestResponse unauthorized(Errors errors) {
        responseObject.setMessage(errors.errorListHtml());
        responseObject.setPayload(errors.getErrorObjects());
        restResponse = new RestResponse(responseObject, HttpStatus.EXPECTATION_FAILED);
        return restResponse;
    }

    @Override
    public RestResponse expectationFailed(Errors errors) {
        if (errors.hasErrors()) {
            this.expectationFailedResponse(errors.errorListHtml());
        }
        return restResponse;
    }

    @Override
    public RestResponse created(Object object) {
        this.createdResponse(object);
        return restResponse;
    }

    @Override
    public RestResponse ok(Object object) {
        this.okResponse(object);
        return restResponse;
    }

    @Override
    public RestResponse fetched(Object object) {
        responseObject.setMessage("Data fetched successfully.");
        responseObject.setPayload(object);
        restResponse = new RestResponse(responseObject, HttpStatus.OK);
        return restResponse;
    }

    @Override
    public RestResponse sessionExpired() {
        responseObject.setMessage("Your session has expired.");
        responseObject.setPayload("");
        restResponse = new RestResponse(responseObject, HttpStatus.UNAUTHORIZED);
        return restResponse;
    }

    private void expectationFailedResponse(String message) {
        responseObject.setMessage(message);
        responseObject.setPayload("");
        restResponse = new RestResponse(responseObject, HttpStatus.EXPECTATION_FAILED);
    }

    private void createdResponse(Object object) {
        responseObject.setMessage("Your request has been submitted successfully");
        responseObject.setPayload(object);
        restResponse = new RestResponse(responseObject, HttpStatus.CREATED);
    }

    private void okResponse(Object object) {
        responseObject.setMessage("Login successful");
        responseObject.setPayload(object);
        restResponse = new RestResponse(responseObject, HttpStatus.OK);
    }

    private void deniedResponse(String message, Object object) {
        responseObject.setMessage(message);
        responseObject.setPayload(object);
        restResponse = new RestResponse(responseObject, HttpStatus.UNAUTHORIZED);
    }
}
