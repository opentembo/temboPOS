package ke.co.suncha.tembo.tenant.helpers.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Maitha Manyala <maitha.manyala at gmail.com>
 *
 */
@JsonSerialize
@Component
@Scope("prototype")
public class ResponseObject implements Serializable {
	private String message;
	private Boolean error;

	private Object payload;

	public ResponseObject(String msg, Object payload){
		this.message= msg;
		this.payload= payload;
	}

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	public ResponseObject(){
		this.payload="";
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		if(StringUtils.isNotBlank(message)){
			message=message.replace("<br>","");
		}
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the payload
	 */
	public Object getPayload() {
		if(this.payload==null){
			this.payload="";
		}
		return payload;
	}

	/**
	 * @param payload
	 *            the payload to set
	 */
	public void setPayload(Object payload) {
		this.payload = payload;
	}
}
