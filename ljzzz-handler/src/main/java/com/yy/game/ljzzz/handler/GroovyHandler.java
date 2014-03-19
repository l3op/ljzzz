package com.yy.game.ljzzz.handler;

import java.util.Map;

import com.yy.game.ljzzz.vo.WebParamVO;

public interface GroovyHandler {

	Map<String, Object> doByGroovy(String ifaceName, String methodName, WebParamVO param);
}
