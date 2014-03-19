<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<%
	String env = System.getenv("DWENV");
	session.setAttribute("env", env);
%>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">LJZZZ后台</a>
		</div>
		
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li <c:if test="${param.select == ''}"> class="active"</c:if>><a href="/manager/template/index">Home</a></li>
				<li <c:if test="${param.select == 'template'}"> class="active"</c:if>><a href="/manager/template/toManager">定制活动</a></li>
				<li <c:if test="${param.select == 'iface'}"> class="active"</c:if>><a href="/manager/template/toIface">定制接口</a></li>
				<li  class="<c:if test="${param.select == 'lottery' }">active</c:if> dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">抽奖 <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">平台抽奖</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">其它抽奖类型</li>
						<li><a href="#">消费抽奖</a></li>
						<li><a href="#">充值抽奖</a></li>
						<li><a href="#">特权抽奖</a></li>
					</ul>
				</li>
				
				<li class="<c:if test="${param.select == 'lottery' }">active</c:if>dropdown">
					<a href="#" class="dropdown-toggle"	data-toggle="dropdown">兑换 <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">可重复兑换</a></li>
						<li><a href="#">不可重复兑换</a></li>
					</ul>
				</li>
				
				<li class="<c:if test="${param.select == 'task' }">active</c:if>dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">任务 <b class="caret"></b></a>
				</li>
				
				<li class="<c:if test="${param.select == 'sign' }">active</c:if>dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">签到 <b class="caret"></b></a>
				</li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">当前系统环境： <c:choose>
							<c:when test="${sessionScope.env == 'prod'}">正式环境</c:when>
							<c:when test="${sessionScope.env == 'test'}">测试环境</c:when>
							<c:otherwise>开发环境</c:otherwise>
						</c:choose></a></li>
				<li><a href="#">通行证:<c:out
							value="${sessionScope.yyvip_admin_user}"></c:out></a></li>
				<li><a href="#">角色:管理员</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</div>
