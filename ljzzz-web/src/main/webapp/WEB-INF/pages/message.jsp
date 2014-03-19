<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page errorPage="../exception.jsp" %>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.yy.game.ljzzz.common.JsonUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%
	String callback = request.getParameter("callback");
	if(StringUtils.isBlank(callback)) {
		callback = request.getParameter("jsonpcallback");
	}
	
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("status", 200);
	result.put("message", "");
	result.put("data", request.getAttribute("data"));
	
	if(StringUtils.isNotBlank(callback)) {
		out.println(callback + "("+ JsonUtil.toJson(result) + ")");
	} else {
		out.println(JsonUtil.toJson(result));
	}
	out.flush();
%>
