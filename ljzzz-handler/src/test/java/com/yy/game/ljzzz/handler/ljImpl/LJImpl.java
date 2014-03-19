package com.yy.game.ljzzz.handler.ljImpl;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yy.game.ljzzz.dao.ActConfDao;
import com.yy.game.ljzzz.model.conf.ActConf;
import com.yy.game.ljzzz.service.ActConfService;
import com.yy.game.ljzzz.vo.WebParamVO;
import com.yy.game.ljzzz.zippo.LJ;

public class LJImpl implements LJ {
	
	private ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:/ljzzz/application-handler.xml");
	
	private ActConfDao activityConfDao = ac.getBean("actConfDaoCacheImpl", ActConfDao.class);
	private ActConfService actConfService = ac.getBean("actConfServiceImpl", ActConfService.class);


}
