/**
 *
 * @Title: Text.java
 * @Package com.yqwl.pojo
 * @Description: TODO)
 * @author zhoujiaxin
 * @date 2019年3月28日
 */

package com.yqwl.pojo;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 
 * @Description 
 *    
 * @author zhoujiaxin  
 * @createDate 2019年3月28日  
 */
public class Text implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private BigInteger id ;
    /** 文字编号 */
    private Integer textNumber;
    /** 文字名字 */
    private String name;
    /** 文字内容 */
    private String textInfo;
    /** 文字位置 */
    private String textPlace;

    /**
     * 
     */
    public Text() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param id
     * @param textNumber
     * @param name
     * @param textInfo
     * @param textPlace
     */
    public Text(BigInteger id, Integer textNumber, String name, String textInfo, String textPlace) {
        super();
        this.id = id;
        this.textNumber = textNumber;
        this.name = name;
        this.textInfo = textInfo;
        this.textPlace = textPlace;
    }

    @Override
    public String toString() {
        return "Text [id=" + id + ", textNumber=" + textNumber + ", name=" + name + ", textInfo=" + textInfo
                + ", textPlace=" + textPlace + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((textInfo == null) ? 0 : textInfo.hashCode());
        result = prime * result + ((textNumber == null) ? 0 : textNumber.hashCode());
        result = prime * result + ((textPlace == null) ? 0 : textPlace.hashCode());
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
        Text other = (Text) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (textInfo == null) {
            if (other.textInfo != null)
                return false;
        } else if (!textInfo.equals(other.textInfo))
            return false;
        if (textNumber == null) {
            if (other.textNumber != null)
                return false;
        } else if (!textNumber.equals(other.textNumber))
            return false;
        if (textPlace == null) {
            if (other.textPlace != null)
                return false;
        } else if (!textPlace.equals(other.textPlace))
            return false;
        return true;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Integer getTextNumber() {
        return textNumber;
    }

    public void setTextNumber(Integer textNumber) {
        this.textNumber = textNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextInfo() {
        return textInfo;
    }

    public void setTextInfo(String textInfo) {
        this.textInfo = textInfo;
    }

    public String getTextPlace() {
        return textPlace;
    }

    public void setTextPlace(String textPlace) {
        this.textPlace = textPlace;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
    
    
}
