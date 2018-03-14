package net.vlaba.util.enums;

public enum BaseExceptionMsg {
	
	/**
	 * 错误码命名规则：六位数字
	 * 000000-000999 为公共异常，使用该类扩展
	 * 要求全部大写，用下划线连接字母
	 * 错误码：
	 * 		前两位表示系统编号，用于多个关联系统
	 * 		三四位表示功能模块
	 * 		五六位表示错误编号
	 */
	SUCCESS("000000", "success"),
    NUKNOW_ERROR("999999", "unknow error"),
    PARAM_IS_NULL("000001", "param is null"),
    PARAM_ERROR("000002", "param error"),
    CALL_REMOTE_SERVICE_FAILED("000003", "call remote service is failed"),
    ;
	
	private String code;
	private String message;
	private BaseExceptionMsg(String code, String message) {
		this.code = code;
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
