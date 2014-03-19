package com.yy.game.ljzzz.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yy.game.ljzzz.handler.GroovyHandler;
import com.yy.game.ljzzz.vo.WebParamVO;

/**
 * 活动的所有的前端接口
 * 用脚本实现的, 可能只用到一次的接口
 * 用于应急, 快速出原型, 如果接口可能变成常用或有性能问题转移至ActivityController, 用Java编码实现
 */
@Controller
@RequestMapping("/script")
public class ScriptController {
	private static final Logger ILOG = LoggerFactory.getLogger(ScriptController.class);
	private static final String PAGE = "message";
	
	@Autowired
	private GroovyHandler groovyHandler;
	
	/**
	 * 各种玩法,会写入数据
	 * @param ifaceName
	 * @param yyuid
	 * @param param
	 * @param model
	 * @return
	 */
	@RequestMapping("/writeUserData/do{ifaceName}")
	public String writeUserData(@PathVariable String ifaceName, long yyuid, WebParamVO param, ModelMap model) {
		try {
			param.setYyuid(yyuid);
			Map<String, Object> data = groovyHandler.doByGroovy(ifaceName, "writeUserData", param);
			model.put("data", data);
		} catch (Exception e) {
			ILOG.error("脚本实现执行异常, ifaceName[" + ifaceName + "], yyuid[" + yyuid + "], param[" + param + "]", e);
		}
		
		return PAGE;
	}
	
	/**
	 * 读取数据,与用户相关的数据,需要登录
	 * @param ifaceName
	 * @param yyuid
	 * @param param
	 * @param model
	 * @return
	 */
	@RequestMapping("/readUserData/do{ifaceName}")
	public String readUserData(@PathVariable String ifaceName, long yyuid, WebParamVO param, ModelMap model) {
		try {
			param.setYyuid(yyuid);
			Map<String, Object> data = groovyHandler.doByGroovy(ifaceName, "readUserData", param);
			model.put("data", data);
		} catch (Exception e) {
			ILOG.error("脚本实现执行异常, ifaceName[" + ifaceName + "], yyuid[" + yyuid + "], param[" + param + "]", e);
		}

		return PAGE;
	}
	
	/**
	 * 读取数据,不需要登录
	 * 活动配置,动态,排行等
	 * @param ifaceName
	 * @param param
	 * @param model
	 * @return
	 */
	@RequestMapping("/readData/do{ifaceName}")
	public String readData(@PathVariable String ifaceName, WebParamVO param, ModelMap model) {
		try {
			Map<String, Object> data = groovyHandler.doByGroovy(ifaceName, "readData", param);
			model.put("data", data);
		} catch (Exception e) {
			ILOG.error("脚本实现执行异常, ifaceName[" + ifaceName + "], param[" + param + "]", e);
		}

		return PAGE;
	}
}
