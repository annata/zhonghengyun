/**
 * 
 */
package com.ioe.zhy.dao;



import org.apache.ibatis.annotations.Param;

/**
 * @author hq
 *
 */
public interface UserPowerClientFavorDao {
	public int addFavorPowerClient(@Param("user_id")String user_id,@Param("powerClient_id")String powerClient_id);
	public int cancelFavorPowerClient(@Param("user_id")String user_id,@Param("powerClient_id")String powerClient_id);
	public int FavorPowerClientIsExist(@Param("user_id")String user_id,@Param("powerClient_id")String powerClient_id);
}
