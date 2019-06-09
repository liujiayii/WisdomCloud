package com.yqwl.pojo;

import java.io.Serializable;
import java.math.BigInteger;

public class Information implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigInteger id;
	/** 顶部logo*/
	private String topLogo;
	/** 公司icon*/
	private String icon;
	/** 公司名称*/
	private String companyName;
	/** 公司电话*/
	private String companyPhone;
	/** 公司地址*/
	private String companyAddress;
	/** 公司qq*/
	private String qq;
	/** 公司邮编*/
	private String postcode;
	/** 公司邮箱*/
	private String email;
	/** 备案号*/
	private String internetContentProvider;
	
	/** 关于我们信息*/
	private String aboutUs;
	/** 我们的团队信息*/
	private String ourTeam;
	
	public Information() {
		super();
	}

	public Information(BigInteger id, String topLogo, String icon, String companyName, String companyPhone,
			String companyAddress, String qq, String postcode, String email, String internetContentProvider,
			String aboutUs, String ourTeam) {
		super();
		this.id = id;
		this.topLogo = topLogo;
		this.icon = icon;
		this.companyName = companyName;
		this.companyPhone = companyPhone;
		this.companyAddress = companyAddress;
		this.qq = qq;
		this.postcode = postcode;
		this.email = email;
		this.internetContentProvider = internetContentProvider;
		this.aboutUs = aboutUs;
		this.ourTeam = ourTeam;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getTopLogo() {
		return topLogo;
	}

	public void setTopLogo(String topLogo) {
		this.topLogo = topLogo;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInternetContentProvider() {
		return internetContentProvider;
	}

	public void setInternetContentProvider(String internetContentProvider) {
		this.internetContentProvider = internetContentProvider;
	}

	public String getAboutUs() {
		return aboutUs;
	}

	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}

	public String getOurTeam() {
		return ourTeam;
	}

	public void setOurTeam(String ourTeam) {
		this.ourTeam = ourTeam;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aboutUs == null) ? 0 : aboutUs.hashCode());
		result = prime * result + ((companyAddress == null) ? 0 : companyAddress.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((companyPhone == null) ? 0 : companyPhone.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((icon == null) ? 0 : icon.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((internetContentProvider == null) ? 0 : internetContentProvider.hashCode());
		result = prime * result + ((ourTeam == null) ? 0 : ourTeam.hashCode());
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((qq == null) ? 0 : qq.hashCode());
		result = prime * result + ((topLogo == null) ? 0 : topLogo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Information other = (Information) obj;
		if (aboutUs == null) {
			if (other.aboutUs != null)
				return false;
		} else if (!aboutUs.equals(other.aboutUs))
			return false;
		if (companyAddress == null) {
			if (other.companyAddress != null)
				return false;
		} else if (!companyAddress.equals(other.companyAddress))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (companyPhone == null) {
			if (other.companyPhone != null)
				return false;
		} else if (!companyPhone.equals(other.companyPhone))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (icon == null) {
			if (other.icon != null)
				return false;
		} else if (!icon.equals(other.icon))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (internetContentProvider == null) {
			if (other.internetContentProvider != null)
				return false;
		} else if (!internetContentProvider.equals(other.internetContentProvider))
			return false;
		if (ourTeam == null) {
			if (other.ourTeam != null)
				return false;
		} else if (!ourTeam.equals(other.ourTeam))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (qq == null) {
			if (other.qq != null)
				return false;
		} else if (!qq.equals(other.qq))
			return false;
		if (topLogo == null) {
			if (other.topLogo != null)
				return false;
		} else if (!topLogo.equals(other.topLogo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Information [id=" + id + ", topLogo=" + topLogo + ", icon=" + icon + ", companyName=" + companyName
				+ ", companyPhone=" + companyPhone + ", companyAddress=" + companyAddress + ", qq=" + qq + ", postcode="
				+ postcode + ", email=" + email + ", internetContentProvider=" + internetContentProvider + ", aboutUs="
				+ aboutUs + ", ourTeam=" + ourTeam + "]";
	}

	

	
	
}
