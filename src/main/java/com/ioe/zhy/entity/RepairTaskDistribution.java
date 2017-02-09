/**
 * 
 */
package com.ioe.zhy.entity;

import java.util.Date;

/**
 * @author hq
 *
 */
public class RepairTaskDistribution {
	private String distribution_id;
	private String order_id;
	private String task_id;
	private String electrician_id;
	private boolean is_primary;
	private String sign_in_location;
	private String sign_in_address;
	private String sign_in_img;
	private String distribution_status;
	private boolean sys_record_status;     //是否删除
	private Date sys_last_modified_time;    //最后一次修改时间
	private Date sys_create_time;           //添加时间
	private String sys_hash; 

}
