/**
 * 
 */
package com.ioe.zhy.util;

import java.util.List;

/**
 * @author hq
 *
 */
public class ListResult<T> extends Result {
	/**
	 * 记录集合
	 */
	private List<T> dataList;

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
}
