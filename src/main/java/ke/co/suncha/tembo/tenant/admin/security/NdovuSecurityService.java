package ke.co.suncha.tembo.tenant.admin.security;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import ke.co.suncha.tembo.remote.Response;
import ke.co.suncha.tembo.tenant.admin.users.roles.UserRole;
import ke.co.suncha.tembo.tenant.admin.users.sessions.UserSession;
import ke.co.suncha.tembo.tenant.helpers.errors.Errors;
import ke.co.suncha.tembo.tenant.helpers.request.ResponseObject;
import ke.co.suncha.tembo.tenant.helpers.request.RestRequestObject;
import ke.co.suncha.tembo.tenant.helpers.request.RestResponse;
import ke.co.suncha.tembo.tenant.organization.BusinessUnit;

import java.util.List;

/**
 * Created by maitha.manyala on 10/5/15.
 */
public interface NdovuSecurityService {
    Response authenticate(Credential credential);

    Response getLoggedInUserRoles();

    Response getRoleBusinessUnits(UserRole userRole);

    Response getBusinessUnitWarehouses(BusinessUnit businessUnit);
}
