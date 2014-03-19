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

import com.yy.game.ljzzz.exceptions.AssertHelper;
import com.yy.game.ljzzz.handler.WriteUserData;
import com.yy.game.ljzzz.vo.WebParamVO;

/**
 * 所有向系统中写数据的接口
 * 硬编码实现
 * 核心接口,访问量或者性能要求较高的
 */
@Controller
@RequestMapping("/activity")
public class WriteDataController implements InitializingBean {
	@Autowired
	private List<WriteUserData> writeUserDatas;
	private Map<String, WriteUserData> writeUserDataMap = new HashMap<String, WriteUserData>();
	
	private static final String PAGE = "message";

	/**
	 * 各种玩法,会写入数据
	 * @param yyuid
	 * @param param
	 * @param model
	 * @return
	 */
	@RequestMapping("/writeUserData/do{ifaceName}")
	public String writeUserData(@PathVariable String ifaceName, long yyuid, WebParamVO param, ModelMap model) {
		param.setYyuid(yyuid);
		WriteUserData xxxWriteUserData = writeUserDataMap.get(ifaceName);
		AssertHelper.isTrue(xxxWriteUserData != null, "接口[" + ifaceName + "]未实现");
		
		Map<String, Object> data = xxxWriteUserData.zippo(param);
		model.put("data", data);
		
		return PAGE;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		writeUserDataMap.clear();
		
		for(WriteUserData writeUserData : writeUserDatas) {
			writeUserDataMap.put(writeUserData.flag(), writeUserData);
		}
	}
}
