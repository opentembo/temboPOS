package ke.co.suncha.tembo.tenant.helpers.errors;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by maitha.manyala on 10/5/15.
 */
@Component
@Scope("prototype")
public class ErrorObject {
    private String name;
    private String message;

    public ErrorObject(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorObject{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
