package com.yqwl.pojo;

import java.io.Serializable;
import java.util.Date;

public class Img implements Serializable {
   
    private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private String imgUrl;
	
	private String imgPlace;
	
	private Integer imageNumber;

    /**
     * 
     */
    public Img() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param id
     * @param name
     * @param imgUrl
     * @param imgPlace
     * @param imageNumber
     */
    public Img(Long id, String name, String imgUrl, String imgPlace, Integer imageNumber) {
        super();
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.imgPlace = imgPlace;
        this.imageNumber = imageNumber;
    }

    @Override
    public String toString() {
        return "Img [id=" + id + ", name=" + name + ", imgUrl=" + imgUrl + ", imgPlace=" + imgPlace + ", imageNumber="
                + imageNumber + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((imageNumber == null) ? 0 : imageNumber.hashCode());
        result = prime * result + ((imgPlace == null) ? 0 : imgPlace.hashCode());
        result = prime * result + ((imgUrl == null) ? 0 : imgUrl.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Img other = (Img) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (imageNumber == null) {
            if (other.imageNumber != null)
                return false;
        } else if (!imageNumber.equals(other.imageNumber))
            return false;
        if (imgPlace == null) {
            if (other.imgPlace != null)
                return false;
        } else if (!imgPlace.equals(other.imgPlace))
            return false;
        if (imgUrl == null) {
            if (other.imgUrl != null)
                return false;
        } else if (!imgUrl.equals(other.imgUrl))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgPlace() {
        return imgPlace;
    }

    public void setImgPlace(String imgPlace) {
        this.imgPlace = imgPlace;
    }

    public Integer getImageNumber() {
        return imageNumber;
    }

    public void setImageNumber(Integer imageNumber) {
        this.imageNumber = imageNumber;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
	
	
}