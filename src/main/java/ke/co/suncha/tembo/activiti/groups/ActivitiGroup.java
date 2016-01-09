package ke.co.suncha.tembo.activiti.groups;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by maitha.manyala on 10/4/15.
 */
public class ActivitiGroup implements Serializable {
    private String activitiGroupId;
    private Integer rev = 1;
    private String name;
    private String type = "security-role";

    public String getActivitiGroupId() {
        return activitiGroupId;
    }

    public void setActivitiGroupId(String activitiGroupId) {
        this.activitiGroupId = activitiGroupId;
    }

    public Integer getRev() {
        return rev;
    }

    public void setRev(Integer rev) {
        this.rev = rev;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
