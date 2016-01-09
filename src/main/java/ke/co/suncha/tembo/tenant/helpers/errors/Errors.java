package ke.co.suncha.tembo.tenant.helpers.errors;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maitha.manyala on 10/5/15.
 */
@Component
@Scope("prototype")
public class Errors {
    private Boolean errors = false;
    List<ErrorObject> errorObjects;

    public Errors() {
        this.errorObjects= new ArrayList<>();
    }

    public Boolean hasErrors() {
        if (errorObjects != null) {
            if (!errorObjects.isEmpty()) {
                errors = true;
            }
        }
        return errors;
    }

    public List<ErrorObject> getErrorObjects() {
        return errorObjects;
    }

    public void setErrorObjects(List<ErrorObject> errorObjects) {
        this.errorObjects = errorObjects;
    }

    public String errorListHtml() {

        StringBuilder content = new StringBuilder();
        if (this.hasErrors()) {
            for (ErrorObject errorObject : this.getErrorObjects()) {
                content.append(errorObject.getMessage() + "<br>");
            }
        }
        return content.toString();
    }

    @Override
    public String toString() {
        return "Errors{" +
                "errorObjects=" + errorObjects +
                '}';
    }
}
