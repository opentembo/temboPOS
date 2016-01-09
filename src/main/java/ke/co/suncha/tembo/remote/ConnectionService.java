package ke.co.suncha.tembo.remote;

import com.fasterxml.jackson.databind.ObjectMapper;
import ke.co.suncha.tembo.tenant.admin.security.LoginResponse;
import ke.co.suncha.tembo.tenant.admin.users.sessions.UserSession;

/**
 * Created by maitha.manyala on 1/7/16.
 */
public interface ConnectionService {
    Response post(String serviceUrl, String request);

    Response postObject(String serviceUrl, Object object);

    Response put(String serviceUrl, String request);

    ObjectMapper getMapper();

    void setLoginResponse(String payload);

    void setUserSession(UserSession userSession);
}
