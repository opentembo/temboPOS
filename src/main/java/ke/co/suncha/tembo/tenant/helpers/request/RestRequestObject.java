package ke.co.suncha.tembo.tenant.helpers.request;


/**
 * @author Maitha Manyala <maitha.manyala at gmail.com>
 */
public class RestRequestObject<T> {
    private String token;
    private T object;

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the object
     */
    public T getObject() {
        return object;
    }

    /**
     * @param object the object to set
     */
    public void setObject(T object) {
        this.object = object;
    }

}
