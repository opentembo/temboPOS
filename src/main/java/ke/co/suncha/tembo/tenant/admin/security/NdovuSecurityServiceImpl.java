package ke.co.suncha.tembo.tenant.admin.security;

import ke.co.suncha.tembo.remote.Response;
import ke.co.suncha.tembo.remote.ConnectionService;
import ke.co.suncha.tembo.tenant.admin.users.roles.UserRole;
import ke.co.suncha.tembo.tenant.helpers.request.ResponseObject;
import ke.co.suncha.tembo.tenant.helpers.request.ResponsePayload;
import ke.co.suncha.tembo.tenant.helpers.request.RestRequestObject;
import ke.co.suncha.tembo.tenant.organization.BusinessUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maitha.manyala on 1/7/16.
 */
@Service
public class NdovuSecurityServiceImpl implements NdovuSecurityService {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ConnectionService connectionService;

    @Autowired
    ResponsePayload responsePayload;

    @Autowired
    LoginResponse loginResponse;

    @Override
    public Response authenticate(Credential credential) {
        Response response = new Response();


        try {
            // RestRequestObject request = new RestRequestObject();
            //request.setObject(credential);
            String jsonRequest = connectionService.getMapper().writeValueAsString(credential);
            response = connectionService.post("security/login", jsonRequest);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            response.setPayload(ex.getMessage());
            response.setInternalError(true);
        }
        return response;
    }

    @Override
    public Response getLoggedInUserRoles() {
        Response response = new Response();
        try {
            RestRequestObject request = new RestRequestObject();
            request.setToken(loginResponse.getToken());
            String jsonRequest = connectionService.getMapper().writeValueAsString(request);
            response = connectionService.post("roles/loggedInUser", jsonRequest);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            response.setPayload(ex.getMessage());
            response.setInternalError(true);
        }
        return response;
    }

    @Override
    public Response getRoleBusinessUnits(UserRole userRole) {
        Response response = new Response();
        try {
            RestRequestObject request = new RestRequestObject();
            request.setToken(loginResponse.getToken());
            request.setObject(userRole);
            String jsonRequest = connectionService.getMapper().writeValueAsString(request);
            response = connectionService.post("businessUnits/role", jsonRequest);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            response.setPayload(ex.getMessage());
            response.setInternalError(true);
        }
        return response;
    }

    @Override
    public Response getBusinessUnitWarehouses(BusinessUnit businessUnit) {
        Response response = new Response();
        try {
//            RestRequestObject request = new RestRequestObject();
//            request.setToken(loginResponse.getToken());
//            request.setObject(businessUnit);
//            String jsonRequest = connectionService.getMapper().writeValueAsString(request);
            response = connectionService.postObject("warehouses/businessUnit", businessUnit);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            response.setPayload(ex.getMessage());
            response.setInternalError(true);
        }
        return response;
    }
}
