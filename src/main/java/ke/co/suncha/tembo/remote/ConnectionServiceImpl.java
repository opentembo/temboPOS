package ke.co.suncha.tembo.remote;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import ke.co.suncha.tembo.TemboServiceFactory;
import ke.co.suncha.tembo.tenant.admin.security.LoginResponse;
import ke.co.suncha.tembo.tenant.admin.users.sessions.UserSession;
import ke.co.suncha.tembo.tenant.helpers.request.ResponseObject;
import ke.co.suncha.tembo.tenant.helpers.request.RestRequestObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

/**
 * Created by maitha.manyala on 1/7/16.
 */
@Service
public class ConnectionServiceImpl implements ConnectionService {
    @Autowired
    LoginResponse loginResponse;

    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    private ObjectMapper mapper = new ObjectMapper();
    //TODO; migrate this to a settings file
    final String BASE_URL = "https://api.opentembo.io/tembo/api/v1/";

    HttpClient httpClient = new DefaultHttpClient();

    @PostConstruct
    public void init() {
        mapper.registerModule(new JodaModule());
        mapper.configure(SerializationFeature.WRITE_DATES_WITH_ZONE_ID, true);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(mapper);
    }

    @Override
    public ObjectMapper getMapper() {
        return mapper;
    }

    @Override
    public Response post(String serviceUrl, String request) {
        Response connectionResponse = new Response();
        String msg = "";
        try {
            HttpPost postRequest = new HttpPost(BASE_URL + serviceUrl);
            StringEntity input = new StringEntity(request);
            input.setContentType("application/json");
            postRequest.setEntity(input);
            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() == 201 || response.getStatusLine().getStatusCode() == 200) {
                connectionResponse.setRequestError(false);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

            String output;

            while ((output = br.readLine()) != null) {
                msg += output;
            }
            connectionResponse.setPayload(msg);
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
            connectionResponse.setInternalError(true);
            connectionResponse.setPayload(e.getMessage());
        } catch (UnknownHostException e) {
            connectionResponse.setInternalError(true);
            connectionResponse.setPayload("Sorry we couldn't connect to OpenTembo. Please try again.");
            log.error(e.getMessage());
        } catch (IOException e) {
            connectionResponse.setInternalError(true);
            connectionResponse.setPayload(e.getMessage());
            log.error(e.getMessage());
        }
        return connectionResponse;
    }

    @Override
    public Response postObject(String serviceUrl, Object object) {
        Response connectionResponse = new Response();
        String msg = "";
        try {
            HttpPost postRequest = new HttpPost(BASE_URL + serviceUrl);
            RestRequestObject request = new RestRequestObject();
            request.setToken(loginResponse.getToken());
            request.setObject(object);
            String jsonRequest = this.getMapper().writeValueAsString(request);

            StringEntity input = new StringEntity(jsonRequest);
            input.setContentType("application/json");
            postRequest.setEntity(input);
            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() == 201 || response.getStatusLine().getStatusCode() == 200) {
                connectionResponse.setRequestError(false);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

            String output;

            while ((output = br.readLine()) != null) {
                msg += output;
            }
            connectionResponse.setPayload(msg);
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
            connectionResponse.setInternalError(true);
            connectionResponse.setPayload(e.getMessage());
        } catch (UnknownHostException e) {
            connectionResponse.setInternalError(true);
            connectionResponse.setPayload("Sorry we couldn't connect to OpenTembo. Please try again.");
            log.error(e.getMessage());
        } catch (IOException e) {
            connectionResponse.setInternalError(true);
            connectionResponse.setPayload(e.getMessage());
            log.error(e.getMessage());
        }
        return connectionResponse;
    }

    @Override
    public Response put(String serviceUrl, String request) {
        Response connectionResponse = new Response();
        String msg = "";
        try {
            HttpPut postRequest = new HttpPut(BASE_URL + serviceUrl);
            StringEntity input = new StringEntity(request);
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);

            if (response.getStatusLine().getStatusCode() == 201) {
                connectionResponse.setRequestError(false);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

            String output;

            while ((output = br.readLine()) != null) {
                msg += output;
            }
            connectionResponse.setPayload(msg);
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
            connectionResponse.setPayload(e.getMessage());
            connectionResponse.setInternalError(true);
        } catch (UnknownHostException e) {
            connectionResponse.setInternalError(true);
            connectionResponse.setPayload("Sorry we couldn't connect to OpenTembo. Please try again.");
            log.error(e.getMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
            connectionResponse.setPayload(e.getMessage());
            connectionResponse.setInternalError(true);
        }
        return connectionResponse;
    }

    @Override
    public void setLoginResponse(String payload) {
        try {
            ResponseObject restResponse = this.getMapper().readValue(payload, ResponseObject.class);
            LoginResponse loginResponse = this.getMapper().readValue(this.getMapper().writeValueAsString(restResponse.getPayload()), LoginResponse.class);
            this.loginResponse.setName(loginResponse.getName());
            this.loginResponse.setToken(loginResponse.getToken());
            this.loginResponse.setTenantName(loginResponse.getTenantName());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void setUserSession(UserSession userSession) {
        UserSession us = TemboServiceFactory.getService(UserSession.class);
        us.setBusinessUnit(userSession.getBusinessUnit());
        us.setTenantLevel(userSession.getTenantLevel());
        us.setUserRole(userSession.getUserRole());
        us.setWarehouse(userSession.getWarehouse());
    }
}
