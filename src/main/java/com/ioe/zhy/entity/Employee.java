/**
 * 
 */
package com.ioe.zhy.entity;

/**
 * @author hq
 *
 */
public class Employee {
	private String accountId; // 平台账号
	private String address; // 地址
	private String birthday;  //出生日期
	private String cellphone;  //手机号码,11位十进制数字，前两位包含：13,15,17,18
	private String contactType;   //联系人类型,1 用电联系人、2 帐务联系人
	private String customerId;   //客户编号
	private String 	departmentId;   //部门编号
	private String 	email;         //电子邮箱
	private String id;              // 唯一标识
	private String 	name;           //姓名
	private String 	position;        //岗位,举例：总经理，用电主管，运维电工
	private String remark;          //备注
	private long 	serialVersionUID ;   
	private String 	sex;                //性别,01 男、02 女
	private String 	telphone;          //电话号码
	private String 	weChat;       //微信号
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getContactType() {
		return contactType;
	}
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public long getSerialVersionUID() {
		return serialVersionUID;
	}
	public void setSerialVersionUID(long serialVersionUID) {
		this.serialVersionUID = serialVersionUID;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getWeChat() {
		return weChat;
	}
	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}
	@Override
	public String toString() {
		return "Employee [accountId=" + accountId + ", address=" + address + ", birthday=" + birthday + ", cellphone="
				+ cellphone + ", contactType=" + contactType + ", customerId=" + customerId + ", departmentId="
				+ departmentId + ", email=" + email + ", id=" + id + ", name=" + name + ", position=" + position
				+ ", remark=" + remark + ", serialVersionUID=" + serialVersionUID + ", sex=" + sex + ", telphone="
				+ telphone + ", weChat=" + weChat + "]";
	}

}
