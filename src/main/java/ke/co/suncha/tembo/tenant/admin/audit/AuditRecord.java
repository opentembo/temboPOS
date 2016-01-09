package ke.co.suncha.tembo.tenant.admin.audit;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ke.co.suncha.tembo.tenant.admin.models.BaseEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by manyala on 5/12/15.
 */

public class AuditRecord extends BaseEntity implements Serializable {
    private long recordId;
    private String operation;
    private String parentID;
    private String parentObject;
    private String previousData;
    private String currentData;
    private String notes;
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getRecordId() {
        return recordId;
    }

    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public String getParentObject() {
        return parentObject;
    }

    public void setParentObject(String parentObject) {
        this.parentObject = parentObject;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getPreviousData() {
        return previousData;
    }

    public void setPreviousData(String previousDate) {
        this.previousData = previousDate;
    }

    public String getCurrentData() {
        return currentData;
    }

    public void setCurrentData(String currentData) {
        this.currentData = currentData;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
