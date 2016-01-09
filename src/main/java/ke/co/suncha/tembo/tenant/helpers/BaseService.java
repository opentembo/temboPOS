package ke.co.suncha.tembo.tenant.helpers;

import ke.co.suncha.tembo.tenant.helpers.request.RestResponse;

/**
 * Created by maitha.manyala on 9/11/15.
 */
public interface BaseService<T> {
    public RestResponse create(T t);
}
