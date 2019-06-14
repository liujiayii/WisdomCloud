package com.yqwl.service.impl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yqwl.dao.BannerImageMapper;
import com.yqwl.pojo.BannerImage;
import com.yqwl.service.BannerImageService;

/**
 *
 * @ClassName: BannerImageServiceImpl
 * @description 轮播图表的Service实现层
 *
 * @author dujiawei
 * @createDate 2019年6月9日
 */
@Service
@Transactional(rollbackFor = { Exception.class })
public class BannerImageServiceImpl implements BannerImageService {
	
	@Resource
	private BannerImageMapper bannerImageMapper;

	/**
	 * @Title: listBannerImage
	 * @description (后台)分页查询所有的轮播图
	 * @param @param page
	 * @param @param limit
	 * @param @throws Exception   
	 * @return Map<String,Object>    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@Override
	public Map<String, Object> listBannerImage(Integer page, Integer limit) throws Exception {
		// TODO Auto-generated method stub
		int bannerImageCount = bannerImageMapper.countBannerImage();
		int beginPageIndex = ((page - 1) * limit);
		List<BannerImage> bannerImageList = bannerImageMapper.listBannerImage(beginPageIndex, limit);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("count", bannerImageCount);  //轮播图数量
		map.put("list", bannerImageList);  //轮播图列表
		
		return map;
	}

	/**
	 * @Title: countBannerImage
	 * @description 所有轮播图的数量
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@Override
	public int countBannerImage() throws Exception {
		// TODO Auto-generated method stub
		return bannerImageMapper.countBannerImage();
	}

	/**
	 * @Title: saveBannerImage
	 * @description (后台)增加一条轮播图
	 * @param @param bannerImage
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@Override
	public int saveBannerImage(BannerImage bannerImage) throws Exception {
		// TODO Auto-generated method stub
		return bannerImageMapper.saveBannerImage(bannerImage);
	}

	/**
	 * @Title: updateBannerImage
	 * @description (后台)修改一条轮播图
	 * @param @param bannerImage
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@Override
	public int updateBannerImage(BannerImage bannerImage) throws Exception {
		// TODO Auto-generated method stub
		return bannerImageMapper.updateBannerImage(bannerImage);
	}

	/**
	 * @Title: removeBannerImage
	 * @description (后台)删除一条轮播图
	 * @param @param id
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@Override
	public int removeBannerImage(BigInteger id) throws Exception {
		// TODO Auto-generated method stub
		return bannerImageMapper.removeBannerImage(id);
	}

	/**
	 * @Title: getBannerImageById
	 * @description (后台)通过id查询对应的轮播图
	 * @param @param bannerImage
	 * @return BannerImage    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@Override
	public BannerImage getBannerImageById(BannerImage bannerImage) throws Exception {
		// TODO Auto-generated method stub
		return bannerImageMapper.getBannerImageById(bannerImage);
	}

	/**
	 * @Title: showAllBannerImage
	 * @description (前台)显示所有的轮播图
	 * @return List<BannerImage>    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@Override
	public List<BannerImage> showAllBannerImage() throws Exception {
		// TODO Auto-generated method stub
		return bannerImageMapper.showAllBannerImage();
	}

	/**
	 * @Title: listBannerImageByModelId
	 * @description 根据模版id查询对应的轮播图片
	 * @param @param bannerImage
	 * @return Map<String, Object>   
	 * @author dujiawei
	 * @createDate 2019年6月10日
	 */
	@Override
	public Map<String, Object> listBannerImageByModelId(BannerImage bannerImage) {
		// TODO Auto-generated method stub
		List<BannerImage> bannerImageList =  bannerImageMapper.listBannerImageByModelId(bannerImage);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("list", bannerImageList);  //轮播图列表
		
		return map;
	}

}
