package com.yqwl.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @ClassName: ModelAndBannerVo
 * @description 模版表联合查询用实体类
 *
 * @author dujiawei
 * @createDate 2019年6月11日
 */
public class ModelAndBannerVo implements Serializable {

	/** UID  */
	private static final long serialVersionUID = 1L;
	
	//模版表内容
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
	
	//价格筛选使用
	/** 搜索的模版最低价格 */
	private BigDecimal modelLowPrice;
	/** 搜索的模版最高价格 */
	private BigDecimal modelHighPrice;
	
	
	//轮播图片表内容
	/** 模版轮播图id */
	private BigInteger bannerImageId;
	/** 轮播图片 */
	private String images;
	/** 排序优先级（数字越大级别越低） */
	private BigInteger priority;
	
	//色系表内容
	/** 色系名称 */
	private String colorName;
	
	//行业表内容
	/** 行业名称 */
	private String tradeName;
	
	//类型表内容
	/** 类型名称 */
	private String typeName;
	
	private Integer page;
	private Integer limit;
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
	 * @return the modelLowPrice
	 */
	public BigDecimal getModelLowPrice() {
		return modelLowPrice;
	}
	/**
	 * @param modelLowPrice the modelLowPrice to set
	 */
	public void setModelLowPrice(BigDecimal modelLowPrice) {
		this.modelLowPrice = modelLowPrice;
	}
	/**
	 * @return the modelHighPrice
	 */
	public BigDecimal getModelHighPrice() {
		return modelHighPrice;
	}
	/**
	 * @param modelHighPrice the modelHighPrice to set
	 */
	public void setModelHighPrice(BigDecimal modelHighPrice) {
		this.modelHighPrice = modelHighPrice;
	}
	/**
	 * @return the bannerImageId
	 */
	public BigInteger getBannerImageId() {
		return bannerImageId;
	}
	/**
	 * @param bannerImageId the bannerImageId to set
	 */
	public void setBannerImageId(BigInteger bannerImageId) {
		this.bannerImageId = bannerImageId;
	}
	/**
	 * @return the images
	 */
	public String getImages() {
		return images;
	}
	/**
	 * @param images the images to set
	 */
	public void setImages(String images) {
		this.images = images;
	}
	/**
	 * @return the priority
	 */
	public BigInteger getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(BigInteger priority) {
		this.priority = priority;
	}
	/**
	 * @return the colorName
	 */
	public String getColorName() {
		return colorName;
	}
	/**
	 * @param colorName the colorName to set
	 */
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	/**
	 * @return the tradeName
	 */
	public String getTradeName() {
		return tradeName;
	}
	/**
	 * @param tradeName the tradeName to set
	 */
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}
	/**
	 * @return the limit
	 */
	public Integer getLimit() {
		return limit;
	}
	/**
	 * @param limit the limit to set
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
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
		result = prime * result + ((bannerImageId == null) ? 0 : bannerImageId.hashCode());
		result = prime * result + ((colorId == null) ? 0 : colorId.hashCode());
		result = prime * result + ((colorName == null) ? 0 : colorName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + ((limit == null) ? 0 : limit.hashCode());
		result = prime * result + ((modelHighPrice == null) ? 0 : modelHighPrice.hashCode());
		result = prime * result + ((modelLowPrice == null) ? 0 : modelLowPrice.hashCode());
		result = prime * result + ((modelName == null) ? 0 : modelName.hashCode());
		result = prime * result + ((modelNum == null) ? 0 : modelNum.hashCode());
		result = prime * result + ((modelPrice == null) ? 0 : modelPrice.hashCode());
		result = prime * result + ((page == null) ? 0 : page.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((tradeId == null) ? 0 : tradeId.hashCode());
		result = prime * result + ((tradeName == null) ? 0 : tradeName.hashCode());
		result = prime * result + ((typeId == null) ? 0 : typeId.hashCode());
		result = prime * result + ((typeName == null) ? 0 : typeName.hashCode());
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
		ModelAndBannerVo other = (ModelAndBannerVo) obj;
		if (bannerImageId == null) {
			if (other.bannerImageId != null)
				return false;
		} else if (!bannerImageId.equals(other.bannerImageId))
			return false;
		if (colorId == null) {
			if (other.colorId != null)
				return false;
		} else if (!colorId.equals(other.colorId))
			return false;
		if (colorName == null) {
			if (other.colorName != null)
				return false;
		} else if (!colorName.equals(other.colorName))
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
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (limit == null) {
			if (other.limit != null)
				return false;
		} else if (!limit.equals(other.limit))
			return false;
		if (modelHighPrice == null) {
			if (other.modelHighPrice != null)
				return false;
		} else if (!modelHighPrice.equals(other.modelHighPrice))
			return false;
		if (modelLowPrice == null) {
			if (other.modelLowPrice != null)
				return false;
		} else if (!modelLowPrice.equals(other.modelLowPrice))
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
		if (page == null) {
			if (other.page != null)
				return false;
		} else if (!page.equals(other.page))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
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
		if (tradeName == null) {
			if (other.tradeName != null)
				return false;
		} else if (!tradeName.equals(other.tradeName))
			return false;
		if (typeId == null) {
			if (other.typeId != null)
				return false;
		} else if (!typeId.equals(other.typeId))
			return false;
		if (typeName == null) {
			if (other.typeName != null)
				return false;
		} else if (!typeName.equals(other.typeName))
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
		return "ModelAndBannerVo [id=" + id + ", modelNum=" + modelNum + ", modelName=" + modelName + ", modelPrice="
				+ modelPrice + ", colorId=" + colorId + ", tradeId=" + tradeId + ", typeId=" + typeId + ", version="
				+ version + ", image=" + image + ", state=" + state + ", modelLowPrice=" + modelLowPrice
				+ ", modelHighPrice=" + modelHighPrice + ", bannerImageId=" + bannerImageId + ", images=" + images
				+ ", priority=" + priority + ", colorName=" + colorName + ", tradeName=" + tradeName + ", typeName="
				+ typeName + ", page=" + page + ", limit=" + limit + "]";
	}

	
	
}
