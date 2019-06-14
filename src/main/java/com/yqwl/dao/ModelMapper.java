package com.yqwl.dao;

import java.math.BigInteger;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.yqwl.vo.ModelAndBannerVo;

/**
 *
 * @ClassName: ModelMapper
 * @description 模版表的方法
 *
 * @author dujiawei
 * @createDate 2019年6月9日
 */
public interface ModelMapper {
	
	/**
	 * @Title: listModel
	 * @description (后台)分页查询所有的模版
	 * @param @param beginPageIndex
	 * @param @param limit
	 * @return List<ModelAndBannerVo>    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	List<ModelAndBannerVo> listModel(@Param("beginPageIndex")Integer beginPageIndex,@Param("limit")Integer limit);
    
	/**
	 * @Title: countModel
	 * @description 所有模版的数量
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public int countModel();
	
	/**
	 * @Title: saveModel
	 * @description (后台)增加一条模版
	 * @param @param modelAndBannerVo
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public int saveModel(ModelAndBannerVo modelAndBannerVo);
	
	/**
	 * @Title: listModelForUpdate
	 * @description 修改模版信息时查重使用
	 * @param @param id
	 * @return List<ModelAndBannerVo>    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	List<ModelAndBannerVo> listModelForUpdate(@Param("id") BigInteger id);
	
	/**
	 * @Title: updateModel
	 * @description (后台)修改一条模版
	 * @param @param modelAndBannerVo
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public int updateModel(ModelAndBannerVo modelAndBannerVo);
	
	/**
	 * @Title: removeModel
	 * @description (后台)删除一条模版（上下架）
	 * @param @param modelAndBannerVo
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月10日
	 */
	public int removeModel(ModelAndBannerVo modelAndBannerVo);
	
	/**
	 * @Title: getModelById
	 * @description (后台)通过id查询对应的模版
	 * @param @param modelAndBannerVo
	 * @return ModelAndBannerVo    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public ModelAndBannerVo getModelById(ModelAndBannerVo modelAndBannerVo);
	
	/**
	 * @Title: listModelByOption
	 * @description 根据筛选条件查询对应的模版
	 * @param @param modelAndBannerVo
	 * @return List<ModelAndBannerVo>    
	 *
	 * @author dujiawei
	 * @createDate 2019年6月11日
	 */
	List<ModelAndBannerVo> listModelByOption(ModelAndBannerVo modelAndBannerVo);
	
	/**
	 * @Title: countModelByOption
	 * @description 根据筛选条件查询对应的模版的数量
	 * @param @param modelAndBannerVo
	 * @param @return   
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public int countModelByOption(ModelAndBannerVo modelAndBannerVo);
	
	/**
	 * @Title: showAllModel
	 * @description (前台)显示所有的模版（无分页）
	 * @return List<ModelAndBannerVo>    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public List<ModelAndBannerVo> showAllModel();

}
