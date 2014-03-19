<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<%@page import="org.springframework.web.util.NestedServletException"%>
<%@page import="com.duowan.anti.exception.AntiRunException" %>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.yy.game.ljzzz.common.JsonUtil"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="org.slf4j.LoggerFactory"%>

<%!private static final Logger LOG = LoggerFactory.getLogger("exception.jsp");%>

<%
	response.setStatus(200);
	String callback = request.getParameter("jsonpcallback");
	
	int statu = 200;
	String message = "";
	if(exception instanceof NestedServletException) {
		NestedServletException nse = (NestedServletException) exception;
		Throwable thable = nse.getCause();
		if(thable instanceof AntiRunException) {
			AntiRunException anti = (AntiRunException)thable;
			statu = anti.getErrorCode().getCode();
			message = anti.getMessage();
		} else {
			LOG.warn("未知异常发生在NestedServletException", exception);
			statu = 600;
			message = "未知异常";
		}
	} else if(exception instanceof AntiRunException) {
		AntiRunException anti = (AntiRunException)exception;
		statu = anti.getErrorCode().getCode();
		message = anti.getMessage();
	} else {
		statu = 601;
		message = "未知异常";
		LOG.warn("未知异常发生", exception);
	}
	
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("status", statu);
	result.put("message", message);
	result.put("data", "");
	if(StringUtils.isNotBlank(callback)) {
		out.println(callback + "("+ JsonUtil.toJson(result) + ")");
	} else {
		out.println(JsonUtil.toJson(result));
	}
	out.flush();
%>

