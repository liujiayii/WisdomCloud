package com.yqwl.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @ClassName: Model
 * @description 模版表实体类
 *
 * @author dujiawei
 * @createDate 2019年6月6日
 */
public class Model implements Serializable {

	/** UID  */
	private static final long serialVersionUID = 1L;
	/** 模版id */
	private BigInteger id;
	/** 模版编号 */
	private String modelNum;
	/** 模版名称 */
	private String modelName;
	/** 模版价格 */
	private BigDecimal modelPrice;
	/** 色系id */
	private BigInteger colorId;
	/** 行业id */
	private BigInteger tradeId;
	/** 类型id */
	private BigInteger typeId;
	/** 版本 */
	private String version;
	/** 模版展示图片 */
	private String image;
	/**
	 * 状态:
	 * 0.上架，
	 * 1.下架
	 */
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
	 * @return the modelNum
	 */
	public String getModelNum() {
		return modelNum;
	}
	/**
	 * @param modelNum the modelNum to set
	 */
	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
	}
	/**
	 * @return the modelName
	 */
	public String getModelName() {
		return modelName;
	}
	/**
	 * @param modelName the modelName to set
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	/**
	 * @return the modelPrice
	 */
	public BigDecimal getModelPrice() {
		return modelPrice;
	}
	/**
	 * @param modelPrice the modelPrice to set
	 */
	public void setModelPrice(BigDecimal modelPrice) {
		this.modelPrice = modelPrice;
	}
	/**
	 * @return the colorId
	 */
	public BigInteger getColorId() {
		return colorId;
	}
	/**
	 * @param colorId the colorId to set
	 */
	public void setColorId(BigInteger colorId) {
		this.colorId = colorId;
	}
	/**
	 * @return the tradeId
	 */
	public BigInteger getTradeId() {
		return tradeId;
	}
	/**
	 * @param tradeId the tradeId to set
	 */
	public void setTradeId(BigInteger tradeId) {
		this.tradeId = tradeId;
	}
	/**
	 * @return the typeId
	 */
	public BigInteger getTypeId() {
		return typeId;
	}
	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(BigInteger typeId) {
		this.typeId = typeId;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
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
		result = prime * result + ((colorId == null) ? 0 : colorId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((modelName == null) ? 0 : modelName.hashCode());
		result = prime * result + ((modelNum == null) ? 0 : modelNum.hashCode());
		result = prime * result + ((modelPrice == null) ? 0 : modelPrice.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((tradeId == null) ? 0 : tradeId.hashCode());
		result = prime * result + ((typeId == null) ? 0 : typeId.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		Model other = (Model) obj;
		if (colorId == null) {
			if (other.colorId != null)
				return false;
		} else if (!colorId.equals(other.colorId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (modelName == null) {
			if (other.modelName != null)
				return false;
		} else if (!modelName.equals(other.modelName))
			return false;
		if (modelNum == null) {
			if (other.modelNum != null)
				return false;
		} else if (!modelNum.equals(other.modelNum))
			return false;
		if (modelPrice == null) {
			if (other.modelPrice != null)
				return false;
		} else if (!modelPrice.equals(other.modelPrice))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (tradeId == null) {
			if (other.tradeId != null)
				return false;
		} else if (!tradeId.equals(other.tradeId))
			return false;
		if (typeId == null) {
			if (other.typeId != null)
				return false;
		} else if (!typeId.equals(other.typeId))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Model [id=" + id + ", modelNum=" + modelNum + ", modelName=" + modelName + ", modelPrice=" + modelPrice
				+ ", colorId=" + colorId + ", tradeId=" + tradeId + ", typeId=" + typeId + ", version=" + version
				+ ", image=" + image + ", state=" + state + "]";
	}

}
