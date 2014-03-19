package com.yy.game.ljzzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yy.game.ljzzz.dao.PlayerDataDao;
import com.yy.game.ljzzz.enums.DataType;
import com.yy.game.ljzzz.exceptions.AssertHelper;
import com.yy.game.ljzzz.model.PlayerData;
import com.yy.game.ljzzz.service.ActConfService;
import com.yy.game.ljzzz.service.PlayerDataService;

@Service
public class PlayerDataServiceImpl implements PlayerDataService {

	@Autowired
	private ActConfService actConfService;
	@Autowired
	private PlayerDataDao playerDataDao;
	
	@Override
	public PlayerData getData(long yyuid, int actId, String gameId,
			String serverId, int type) {
		DataType dataType = DataType.getByType(type);
		AssertHelper.chekcParam(dataType, "积分类型不存在");
		
		String refer = actConfService.getConfRefer(actId, gameId, serverId);
		PlayerData playerData = playerDataDao.get(yyuid, actId, refer, dataType);
		return playerData;
	}
}
