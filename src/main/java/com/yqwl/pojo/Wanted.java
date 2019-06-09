package com.yqwl.pojo;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 
 *
 * @ClassName: Wanted
 * @description 招聘信息表实体类
 *
 * @author dujiawei
 * @createDate 2019年3月29日
 */
public class Wanted implements Serializable {

	/**  UID */
	private static final long serialVersionUID = 1L;
	/** 招聘id */
	private BigInteger id;
	/** 招聘职位 */
	private String job;
	/** 招聘人数 */
	private Integer wantNumber;
	/** 学历 */
	private String education;
	/** 专业 */
	private String major;
	/** 工作地点 */
	private String workplace;
	/** 工作详情 */
	private String remark;
	/** 招聘状态(0上架，1下架) */
	private Integer state;
	
	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}
	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}
	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * @return the wantNumber
	 */
	public Integer getWantNumber() {
		return wantNumber;
	}
	/**
	 * @param wantNumber the wantNumber to set
	 */
	public void setWantNumber(Integer wantNumber) {
		this.wantNumber = wantNumber;
	}
	/**
	 * @return the education
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	/**
	 * @return the workplace
	 */
	public String getWorkplace() {
		return workplace;
	}
	/**
	 * @param workplace the workplace to set
	 */
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((wantNumber == null) ? 0 : wantNumber.hashCode());
		result = prime * result + ((workplace == null) ? 0 : workplace.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wanted other = (Wanted) obj;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (wantNumber == null) {
			if (other.wantNumber != null)
				return false;
		} else if (!wantNumber.equals(other.wantNumber))
			return false;
		if (workplace == null) {
			if (other.workplace != null)
				return false;
		} else if (!workplace.equals(other.workplace))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Wanted [id=" + id + ", job=" + job + ", wantNumber=" + wantNumber + ", education=" + education
				+ ", major=" + major + ", workplace=" + workplace + ", remark=" + remark + ", state=" + state + "]";
	}

}
