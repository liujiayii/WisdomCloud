package com.yqwl.service.impl;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yqwl.dao.ModelMapper;
import com.yqwl.service.ModelService;
import com.yqwl.vo.ModelAndBannerVo;

/**
 *
 * @ClassName: ModelServiceImpl
 * @description 模版表的Service实现层
 *
 * @author dujiawei
 * @createDate 2019年6月9日
 */
@Service
@Transactional(rollbackFor = { Exception.class })
public class ModelServiceImpl implements ModelService {

	@Resource
	private ModelMapper modelMapper;
	
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
	@Override
	public Map<String, Object> listModel(Integer page, Integer limit) throws Exception {
		// TODO Auto-generated method stub
		int modelCount = modelMapper.countModel();
		int beginPageIndex = ((page - 1) * limit);
		List<ModelAndBannerVo> modelList = modelMapper.listModel(beginPageIndex, limit);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("count", modelCount);  //模版数量
		map.put("list", modelList);  //模版列表
		
		return map;
	}

	/**
	 * @Title: countModel
	 * @description 所有模版的数量
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@Override
	public int countModel() throws Exception {
		// TODO Auto-generated method stub
		return modelMapper.countModel();
	}

	/**
	 * @Title: saveModel
	 * @description (后台)增加一条模版
	 * @param @param modelAndBannerVo
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@Override
	public int saveModel(ModelAndBannerVo modelAndBannerVo) throws Exception {
		// TODO Auto-generated method stub
		/*生成随机数模版号*/
		//随机生成后两位数字
		Random random = new Random();
		int ends = random.nextInt(99);
		String twoEnds = String.format("%02d",ends);//后两位随机数，如果不足两位，前面补0
		//获取当前日期字符串
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("mmss");
		String timeNow = dateFormat.format(date).toString(); //当前日期字符串  
		String begin = "MB";
		//最终的模版号(例：MB21425611)
		String num = begin.concat(twoEnds).concat(timeNow).concat(twoEnds);
		
		modelAndBannerVo.setModelNum(num);
		return modelMapper.saveModel(modelAndBannerVo);
	}
	
	/**
	 * @Title: listModelForUpdate
	 * @description 修改模版信息时查重使用
	 * @param @param id
	 * @return List<ModelAndBannerVo>    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@Override
	public List<ModelAndBannerVo> listModelForUpdate(BigInteger id) throws Exception {
		// TODO Auto-generated method stub
		return modelMapper.listModelForUpdate(id);
	}

	/**
	 * @Title: updateModel
	 * @description (后台)修改一条模版
	 * @param @param modelAndBannerVo
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@Override
	public int updateModel(ModelAndBannerVo modelAndBannerVo) throws Exception {
		// TODO Auto-generated method stub
		List<ModelAndBannerVo> allModel = modelMapper.listModelForUpdate(modelAndBannerVo.getId());  //查询除自己的模版
		if(allModel.size() > 0) {
			for(int i = 0; i < allModel.size(); i++) {
				if(allModel.get(i).getModelName().equals(modelAndBannerVo.getModelName())){  //判断修改的模版名称是否已存在
					
					return 1;
				}
			}
			
		}
		return modelMapper.updateModel(modelAndBannerVo);
	}

	/**
	 * @Title: removeModel
	 * @description (后台)删除一条模版（上下架）
	 * @param @param modelAndBannerVo
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月10日
	 */
	@Override
	public int removeModel(ModelAndBannerVo modelAndBannerVo) throws Exception {
		// TODO Auto-generated method stub
		return modelMapper.removeModel(modelAndBannerVo);
	}

	/**
	 * @Title: getModelById
	 * @description (后台)通过id查询对应的模版
	 * @param @param modelAndBannerVo
	 * @return ModelAndBannerVo    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@Override
	public ModelAndBannerVo getModelById(ModelAndBannerVo modelAndBannerVo) throws Exception {
		// TODO Auto-generated method stub
		return modelMapper.getModelById(modelAndBannerVo);
	}

	/**
	 * @Title: listModelByOption
	 * @description 根据筛选条件查询对应的模版
	 * @param @param page
	 * @param @param limit
	 * @param @param modelAndBannerVo
	 * @param @throws Exception   
	 * @return Map<String, Object>    
	 * @author dujiawei
	 * @createDate 2019年6月11日
	 */
	@Override
	public Map<String, Object> listModelByOption(Integer page, Integer limit, ModelAndBannerVo modelAndBannerVo)
			throws Exception {
		// TODO Auto-generated method stub
		int modelCountByOption = modelMapper.countModelByOption(modelAndBannerVo);
		int beginPageIndex = ((page - 1) * limit);
		modelAndBannerVo.setPage(beginPageIndex);
		modelAndBannerVo.setLimit(limit);
		List<ModelAndBannerVo> modelListByOption =  modelMapper.listModelByOption(modelAndBannerVo);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("count", modelCountByOption);  //根据条件查询到的模版数量
		map.put("list", modelListByOption);  //根据条件查询到的模版列表
		
		return map;
	}

	/**
	 * @Title: countModelByOption
	 * @description 根据筛选条件查询对应的模版的数量
	 * @param @param modelAndBannerVo
	 * @param @return   
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@Override
	public int countModelByOption(ModelAndBannerVo modelAndBannerVo) throws Exception {
		// TODO Auto-generated method stub
		return modelMapper.countModelByOption(modelAndBannerVo);
	}

	/**
	 * @Title: showAllModel
	 * @description (前台)显示所有的模版（无分页）
	 * @return List<ModelAndBannerVo>    
	 * @author dujiawei
	 * @createDate 2019年6月9日
	 */
	@Override
	public List<ModelAndBannerVo> showAllModel() throws Exception {
		// TODO Auto-generated method stub
		return modelMapper.showAllModel();
	}


}
