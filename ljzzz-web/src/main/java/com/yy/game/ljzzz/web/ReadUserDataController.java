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

import com.yy.game.ljzzz.handler.ReadUserData;
import com.yy.game.ljzzz.vo.WebParamVO;

/**
 * 所有向系统中读取用户相关的数据接口
 * 硬编码实现
 * 核心接口,访问量或者性能要求较高的
 */
@Controller
@RequestMapping("/activity")
public class ReadUserDataController implements InitializingBean {
	@Autowired
	private List<ReadUserData> readUserDatas;
	private Map<String, ReadUserData> readUserDataMap = new HashMap<String, ReadUserData>();
	
	private static final String PAGE = "message";

	/**
	 * 读取数据,与用户相关的数据,需要登录
	 * @param yyuid
	 * @param param
	 * @param model
	 * @return
	 */
	@RequestMapping("/readUserData/do{ifaceName}")
	public String readUserData(@PathVariable String ifaceName, long yyuid, WebParamVO param, ModelMap model) {
		param.setYyuid(yyuid);
		ReadUserData xxxReadUserData = readUserDataMap.get(ifaceName);
		Map<String, Object> data = xxxReadUserData.readUserData(param);
		model.put("data", data);

		return PAGE;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		readUserDataMap.clear();
		
		for(ReadUserData readUserData : readUserDatas) {
			readUserDataMap.put(readUserData.flag(), readUserData);
		}
	}
	
}
