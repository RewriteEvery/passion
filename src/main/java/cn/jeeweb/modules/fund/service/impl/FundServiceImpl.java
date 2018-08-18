package cn.jeeweb.modules.fund.service.impl;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.modules.fund.entity.Fund;
import cn.jeeweb.modules.fund.service.IFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.jeeweb.core.utils.MyBeanUtils;
import cn.jeeweb.core.utils.ServletUtils;
import cn.jeeweb.core.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringEscapeUtils;

/**   
 * @Title: 基金列表
 * @Description: 基金列表
 * @author key
 * @date 2018-05-13 12:47:02
 * @version V1.0   
 *
 */
@Transactional
@Service("fundService")
public class FundServiceImpl  extends CommonServiceImpl<Fund> implements  IFundService {
	
	@Override
	public void save(Fund fund) {
		// 保存主表
		super.save(fund);
	}
	
	@Override
	public void update(Fund fund) {
		try {
			// 更新主表
			super.update(fund);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	
}