/**
 * 
 */
package com.ioe.zhy.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

/**
 * @author hq
 *
 */
public interface UserPowerClientFavorDao {
	public int addFavorPowerClient(@Param("user_id")String user_id,@Param("powerClient_id")String powerClient_id,@Param("sys_hash")String sys_hash,@Param("sys_create_time")Date sys_create_time);
	public int cancelFavorPowerClient(@Param("user_id")String user_id,@Param("powerClient_id")String powerClient_id,@Param("sys_hash")String sys_hash);

}
