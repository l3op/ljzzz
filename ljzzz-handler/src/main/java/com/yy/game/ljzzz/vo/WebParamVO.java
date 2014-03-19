package com.yy.game.ljzzz.vo;

public class WebParamVO {
	private int actId;
	private long yyuid;
	private String passport;
	private String gameId;
	private String serverId;
	
	/*此3个都是扩展参数*/
	private String param1;
	private String param2;
	private String param3;
	
	public int getActId() {
		return actId;
	}
	public void setActId(int actId) {
		this.actId = actId;
	}
	public long getYyuid() {
		return yyuid;
	}
	public void setYyuid(long yyuid) {
		this.yyuid = yyuid;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	public String getServerId() {
		return serverId;
	}
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
	public String getParam1() {
		return param1;
	}
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	public String getParam2() {
		return param2;
	}
	public void setParam2(String param2) {
		this.param2 = param2;
	}
	public String getParam3() {
		return param3;
	}
	public void setParam3(String param3) {
		this.param3 = param3;
	}
	
}
