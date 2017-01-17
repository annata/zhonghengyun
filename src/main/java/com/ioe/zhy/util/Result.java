/**
 * 
 */
package com.ioe.zhy.util;

/**
 * @author hq
 *
 */
public class Result {
	/**
	 * 请求消息的唯一标识
	 */
	private String requestId = null;
	
	/**
	 * 错误码，如果为null，说明没有错误
	 */
	private String code = null;
	
	/**
	 * 错误码对应的错误描述
	 */
	private String message = null;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
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


