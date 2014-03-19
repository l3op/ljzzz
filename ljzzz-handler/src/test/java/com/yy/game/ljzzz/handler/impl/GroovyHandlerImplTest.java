package com.yy.game.ljzzz.handler.impl;

import org.junit.Test;

import com.yy.game.ljzzz.handler.impl.GroovyHandlerImpl;
import com.yy.game.ljzzz.vo.WebParamVO;



public class GroovyHandlerImplTest {
	private GroovyHandlerImpl handlerImpl = new GroovyHandlerImpl();

	@Test
	public void mockSource() throws Exception {
		
	}

	@Test
	public void doByScript() throws Exception {
		WebParamVO param = new WebParamVO();
		handlerImpl.doByGroovy("test.gv", "", param);
	}

	public static void main(String[] args) {
		GroovyHandlerImpl handlerImpl = new GroovyHandlerImpl();
		WebParamVO param = new WebParamVO();
		for(int i = 0; i < 1000; i++) {
			handlerImpl.doByGroovy("test.gv", "", param);
		}
	}
}
