/**
 * 
 */
package com.ioe.zhy.util;

/**
 * @author hq
 *
 */
public class DataResult<T> extends Result {
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
