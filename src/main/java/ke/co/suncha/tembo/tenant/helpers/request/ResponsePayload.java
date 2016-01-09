package ke.co.suncha.tembo.tenant.helpers.request;

import ke.co.suncha.tembo.tenant.helpers.errors.Errors;

/**
 * Created by maitha.manyala on 10/5/15.
 */

public interface ResponsePayload {

    RestResponse expectationFailed(Errors errors);

    RestResponse unauthorized();

    RestResponse unauthorized(Errors errors);

    RestResponse sessionExpired();

    RestResponse created(Object object);

    RestResponse ok(Object object);

    RestResponse fetched(Object object);
}
