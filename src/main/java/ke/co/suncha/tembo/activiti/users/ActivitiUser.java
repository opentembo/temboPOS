package ke.co.suncha.tembo.activiti.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ke.co.suncha.tembo.activiti.groups.ActivitiGroup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maitha.manyala on 10/4/15.
 */
public class ActivitiUser implements Serializable {

    private String activitiUserId;
    
    private Integer rev = 1;

    private String firstName;

    private String lastName;

    private String email;

    private String pwd;

    private String pictureId;

    //TODO; added after creating of activiti default tables
    @JsonIgnore
    private List<ActivitiGroup> activitiGroups;


    public String getActivitiUserId() {
        return activitiUserId;
    }

    public void setActivitiUserId(String activitiUserId) {
        this.activitiUserId = activitiUserId;
    }

    public Integer getRev() {
        return rev;
    }

    public void setRev(Integer rev) {
        this.rev = rev;
    }

    public List<ActivitiGroup> getActivitiGroups() {
        if (activitiGroups == null) {
            activitiGroups = new ArrayList<>();
        }
        return activitiGroups;
    }

    public void setActivitiGroups(List<ActivitiGroup> activitiGroups) {
        this.activitiGroups = activitiGroups;
    }
}
