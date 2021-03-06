package com.yqwl.pojo;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_message.id
	 * @mbggenerated
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_message.type
	 * @mbggenerated
	 */
	private String type;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_message.introduction
	 * @mbggenerated
	 */
	private String introduction;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_message.phone
	 * @mbggenerated
	 */
	private String phone;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_message.name
	 * @mbggenerated
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_message.remark
	 * @mbggenerated
	 */
	private String remark;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_message.status
	 * @mbggenerated
	 */
	private Integer status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_message.time
	 * @mbggenerated
	 */
	private Date time;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_message
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_message.id
	 * @return  the value of t_message.id
	 * @mbggenerated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_message.id
	 * @param id  the value for t_message.id
	 * @mbggenerated
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_message.type
	 * @return  the value of t_message.type
	 * @mbggenerated
	 */
	public String getType() {
		return type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_message.type
	 * @param type  the value for t_message.type
	 * @mbggenerated
	 */
	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_message.introduction
	 * @return  the value of t_message.introduction
	 * @mbggenerated
	 */
	public String getIntroduction() {
		return introduction;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_message.introduction
	 * @param introduction  the value for t_message.introduction
	 * @mbggenerated
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction == null ? null : introduction.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_message.phone
	 * @return  the value of t_message.phone
	 * @mbggenerated
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_message.phone
	 * @param phone  the value for t_message.phone
	 * @mbggenerated
	 */
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_message.name
	 * @return  the value of t_message.name
	 * @mbggenerated
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_message.name
	 * @param name  the value for t_message.name
	 * @mbggenerated
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_message.remark
	 * @return  the value of t_message.remark
	 * @mbggenerated
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_message.remark
	 * @param remark  the value for t_message.remark
	 * @mbggenerated
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_message.status
	 * @return  the value of t_message.status
	 * @mbggenerated
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_message.status
	 * @param status  the value for t_message.status
	 * @mbggenerated
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_message.time
	 * @return  the value of t_message.time
	 * @mbggenerated
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_message.time
	 * @param time  the value for t_message.time
	 * @mbggenerated
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_message
	 * @mbggenerated
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		Message other = (Message) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
				&& (this.getIntroduction() == null ? other.getIntroduction() == null
						: this.getIntroduction().equals(other.getIntroduction()))
				&& (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
				&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
				&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
				&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
				&& (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()));
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_message
	 * @mbggenerated
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getIntroduction() == null) ? 0 : getIntroduction().hashCode());
		result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
		return result;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_message
	 * @mbggenerated
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", type=").append(type);
		sb.append(", introduction=").append(introduction);
		sb.append(", phone=").append(phone);
		sb.append(", name=").append(name);
		sb.append(", remark=").append(remark);
		sb.append(", status=").append(status);
		sb.append(", time=").append(time);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}