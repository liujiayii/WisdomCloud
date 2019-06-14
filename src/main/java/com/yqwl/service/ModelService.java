package com.yqwl.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.yqwl.vo.ModelAndBannerVo;


/**
 *
 * @ClassName: ModelService
 * @description 模版表的方法
 *
 * @author dujiawei
 * @createDate 2019年6月9日
 */
public interface ModelService {
	
	/**
	 * @Title: listModel
	 * @description (后台)分页查询所有的模版
	 * @param @param page
	 * @param @param limit
	 * @param @throws Exception   
	 * @return Map<String,Object>    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	Map<String, Object> listModel(Integer page ,Integer limit) throws Exception;
    
	/**
	 * @Title: countModel
	 * @description 所有模版的数量
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public int countModel() throws Exception;
	
	/**
	 * @Title: saveModel
	 * @description (后台)增加一条模版
	 * @param @param modelAndBannerVo
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public int saveModel(ModelAndBannerVo modelAndBannerVo) throws Exception;
	
	
	/**
	 * @Title: listModelForUpdate
	 * @description 修改模版信息时查重使用
	 * @param @param id
	 * @return List<ModelAndBannerVo>    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	List<ModelAndBannerVo> listModelForUpdate(@Param("id") BigInteger id) throws Exception;
	
	/**
	 * @Title: updateModel
	 * @description (后台)修改一条模版
	 * @param @param modelAndBannerVo
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public int updateModel(ModelAndBannerVo modelAndBannerVo) throws Exception;
	
	/**
	 * @Title: removeModel
	 * @description (后台)删除一条模版（上下架）
	 * @param @param modelAndBannerVo
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月10日
	 */
	public int removeModel(ModelAndBannerVo modelAndBannerVo) throws Exception;
	
	/**
	 * @Title: getModelById
	 * @description (后台)通过id查询对应的模版
	 * @param @param modelAndBannerVo
	 * @return ModelAndBannerVo    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public ModelAndBannerVo getModelById(ModelAndBannerVo modelAndBannerVo) throws Exception;
	
	/**
	 * @Title: listModelByOption
	 * @description 根据筛选条件查询对应的模版
	 * @param @param page
	 * @param @param limit
	 * @param @param modelAndBannerVo
	 * @param @throws Exception   
	 * @return Map<String, Object>    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	Map<String, Object> listModelByOption(Integer page ,Integer limit, ModelAndBannerVo modelAndBannerVo) throws Exception;
	
	/**
	 * @Title: countModelByOption
	 * @description 根据筛选条件查询对应的模版的数量
	 * @param @param modelAndBannerVo
	 * @param @return   
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public int countModelByOption(ModelAndBannerVo modelAndBannerVo) throws Exception;
	
	/**
	 * @Title: showAllModel
	 * @description (前台)显示所有的模版（无分页）
	 * @return List<ModelAndBannerVo>    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	public List<ModelAndBannerVo> showAllModel() throws Exception;

}
