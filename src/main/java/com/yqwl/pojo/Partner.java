package com.yqwl.pojo;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

public class Partner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigInteger id;
	private String partnerName;
	private String image;
	private String url;
	private Timestamp sortTime;
	
	
	public Partner() {
		super();
	}


	public Partner(BigInteger id, String partnerName, String image, String url, Timestamp sortTime) {
		super();
		this.id = id;
		this.partnerName = partnerName;
		this.image = image;
		this.url = url;
		this.sortTime = sortTime;
	}


	public BigInteger getId() {
		return id;
	}


	public void setId(BigInteger id) {
		this.id = id;
	}


	public String getPartnerName() {
		return partnerName;
	}


	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public Timestamp getSortTime() {
		return sortTime;
	}


	public void setSortTime(Timestamp sortTime) {
		this.sortTime = sortTime;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((partnerName == null) ? 0 : partnerName.hashCode());
		result = prime * result + ((sortTime == null) ? 0 : sortTime.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Partner other = (Partner) obj;
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
		if (partnerName == null) {
			if (other.partnerName != null)
				return false;
		} else if (!partnerName.equals(other.partnerName))
			return false;
		if (sortTime == null) {
			if (other.sortTime != null)
				return false;
		} else if (!sortTime.equals(other.sortTime))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Partner [id=" + id + ", partnerName=" + partnerName + ", image=" + image + ", url=" + url
				+ ", sortTime=" + sortTime + "]";
	}
	
	

}
