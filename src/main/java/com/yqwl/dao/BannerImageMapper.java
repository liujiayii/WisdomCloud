package com.yqwl.dao;

import java.math.BigInteger;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.yqwl.pojo.BannerImage;

/**
 *
 * @ClassName: BannerImageMapper
 * @description 模版轮播图的增删改查的方法
 *
 * @author dujiawei
 * @createDate 2019年6月9日
 */
public interface BannerImageMapper {
	
	/**
	 * @Title: listBannerImage
	 * @description (后台)分页查询所有的轮播图
	 * @param @param beginPageIndex
	 * @param @param limit
	 * @return List<BannerImage>    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	List<BannerImage> listBannerImage(@Param("beginPageIndex")Integer beginPageIndex,@Param("limit")Integer limit);
    
	/**
	 * @Title: countBannerImage
	 * @description 所有轮播图的数量
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public int countBannerImage();
	
	/**
	 * @Title: saveBannerImage
	 * @description (后台)增加一条轮播图
	 * @param @param bannerImage
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public int saveBannerImage(BannerImage bannerImage);
	
	/**
	 * @Title: updateBannerImage
	 * @description (后台)修改一条轮播图
	 * @param @param bannerImage
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public int updateBannerImage(BannerImage bannerImage);
	
	/**
	 * @Title: removeBannerImage
	 * @description (后台)删除一条轮播图
	 * @param @param id
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public int removeBannerImage(@Param("id") BigInteger id);
	
	/**
	 * @Title: getBannerImageById
	 * @description (后台)通过id查询对应的轮播图
	 * @param @param bannerImage
	 * @return BannerImage    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public BannerImage getBannerImageById(BannerImage bannerImage);
	
	/**
	 * @Title: showAllBannerImage
	 * @description (前台)显示所有的轮播图
	 * @return List<BannerImage>    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public List<BannerImage> showAllBannerImage();
	
	/**
	 * @Title: listBannerImageByModelId
	 * @description 根据模版id查询对应的轮播图片
	 * @param @param bannerImage
	 * @return List<BannerImage>    
	 * @author dujiawei
	 * @createDate 2019年6月10日
	 */
	public List<BannerImage> listBannerImageByModelId(BannerImage bannerImage);

}
