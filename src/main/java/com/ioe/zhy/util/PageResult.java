/**
 * 
 */
package com.ioe.zhy.util;

import java.util.List;

/**
 * @author hq
 *
 */
public class PageResult<T> extends Result{
	/**
	 * 总的记录条数
	 */
	private Integer totalCount;
	
	/**
	 * 当前位置
	 */
	private Integer start;
	
	/**
	 * 分页长度
	 */
	private Integer length;
	
	/**
	 * 记录集合
	 */
	private List<T> dataList;

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
}
