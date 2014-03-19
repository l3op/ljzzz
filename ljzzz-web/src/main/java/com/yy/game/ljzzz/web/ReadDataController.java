package com.yy.game.ljzzz.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yy.game.ljzzz.handler.ReadData;
import com.yy.game.ljzzz.vo.WebParamVO;

/**
 * 所有向系统中读取配置的接口
 * 硬编码实现
 * 核心接口,访问量或者性能要求较高的
 */
@Controller
@RequestMapping("/activity")
public class ReadDataController implements InitializingBean {
	@Autowired
	private List<ReadData> readDatas;
	private Map<String, ReadData> readDataMap = new HashMap<String, ReadData>();
	
	private static final String PAGE = "message";

	/**
	 * 读取数据,不需要登录
	 * 活动配置,动态,排行等
	 * @param param
	 * @param model
	 * @return
	 */
	@RequestMapping("/readData/do{ifaceName}")
	public String readData(@PathVariable String ifaceName, WebParamVO param, ModelMap model) {
		ReadData xxxReadData = readDataMap.get(ifaceName);
		Map<String, Object> data = xxxReadData.readData(param);
		model.put("data", data);

		return PAGE;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		readDataMap.clear();
		
		for(ReadData readData : readDatas) {
			readDataMap.put(readData.flag(), readData);
		}
	}
}
