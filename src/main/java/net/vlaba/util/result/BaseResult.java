package net.vlaba.util.result;

import java.io.Serializable;

import net.vlaba.util.enums.BaseExceptionMsg;

import org.apache.commons.lang.builder.ToStringBuilder;

public class BaseResult implements Serializable {
	
	private static final long serialVersionUID = -8049555033985078317L;
	
	private String rspCode = "000000";
	private String rspMsg = "success";
	
	public BaseResult() {}
	
	public BaseResult(String rspCode, String rspMsg) {
		this.rspCode = rspCode;
		this.rspMsg = rspMsg;
	}

	public BaseResult(BaseExceptionMsg msg) {
		this.rspCode = msg.getCode();
		this.rspMsg = msg.getMessage();
	}

	public String getRspCode() {
		return rspCode;
	}
	
	public void setRspCode(String rspCode) {
		this.rspCode = rspCode;
	}
	
	public String getRspMsg() {
		return rspMsg;
	}
	
	public void setRspMsg(String rspMsg) {
		this.rspMsg = rspMsg;
	}
	
	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
	
}
