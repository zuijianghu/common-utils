package net.vlaba.util.result;

import net.vlaba.util.enums.BaseExceptionMsg;

public class ResultInfo<T> extends BaseResult {

	private static final long serialVersionUID = 7914278115796963925L;
	
	private T data;

	public ResultInfo(T data) {
		this.data = data;
	}
	
	public ResultInfo(String rspCode, String rspMsg, T data) {
		this.setRspCode(rspCode);
		this.setRspMsg(rspMsg);
		this.setData(data);
	}
	
	public ResultInfo(BaseExceptionMsg msg, T data) {
		this.setRspCode(msg.getCode());
		this.setRspMsg(msg.getMessage());
		this.data = data;
	}
	
	public ResultInfo(String rspCode, String rspMsg) {
		this.setRspCode(rspCode);
		this.setRspMsg(rspMsg);
	}
	
	public ResultInfo(BaseExceptionMsg msg) {
		this.setRspCode(msg.getCode());
		this.setRspMsg(msg.getMessage());
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
