package com.yy.game.ljzzz.service.impl;

import java.util.Calendar;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yy.game.ljzzz.common.DateTime;
import com.yy.game.ljzzz.constants.KeyConstant;
import com.yy.game.ljzzz.dao.ActConfDao;
import com.yy.game.ljzzz.enums.DataLevel;
import com.yy.game.ljzzz.exceptions.AssertHelper;
import com.yy.game.ljzzz.model.conf.ActConf;
import com.yy.game.ljzzz.service.ActConfService;

@Service
public class ActConfServiceImpl implements ActConfService {
	@Autowired
	private ActConfDao activityConfDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getDiyValue(int actId, String key) {
		Map<String, Object> diyConfs = activityConfDao.getDiyConfs(actId);
		AssertHelper.isTrue(diyConfs.containsKey(key), "配置错误,没有此key");
		
		Object value = diyConfs.get(key);
		return (T) value;
	}

	@Override
	public ActConf getConf(int actId) {
		return activityConfDao.get(actId);
	}

	@Override
	public String getConfRefer(int actId, String gameId, String serverId) {
		ActConf actConf = getConf(actId);
		DataLevel level = actConf.getDataLevel();
		String prefix = prefix(level, gameId, serverId);
		
		boolean isReset = getDiyValue(actId, KeyConstant.isReset);
		if(isReset) {
			 String suffix = suffix(actId);
			 return prefix + "_" + suffix;
		} else {
			return prefix;
		}
	}

	/**
	 * 前缀
	 * @param level
	 * @param gameId
	 * @param serverId
	 * @return
	 */
	String prefix(DataLevel level, String gameId, String serverId) {
		String prefix = "";
		switch (level) {
		case PLATFORM:
			prefix = "";
			break;
		case GAME:
			prefix = gameId;
			break;
		case SERVER:
			prefix = gameId + "_" + serverId;
			break;
		default:
			throw new RuntimeException("未实现的数据级别");
		}
		
		return prefix;
	}
	
	/**
	 * 后缀
	 * @param actId
	 * @return
	 */
	String suffix(int actId) {
		/*
		 * 目前的重置时间只支持整点格式
		 * 如果需要有变动,需要精确到分钟,修改此处解析格式即可
		 */
		int resetHour = getDiyValue(actId, KeyConstant.resetTime);
		Calendar cal = Calendar.getInstance();
		if(cal.get(Calendar.HOUR_OF_DAY) < resetHour) {
			// 还没到重置时间,就取昨天的日期
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		return DateTime.toString(cal.getTime(), "yyMMddHH");
	}
}
