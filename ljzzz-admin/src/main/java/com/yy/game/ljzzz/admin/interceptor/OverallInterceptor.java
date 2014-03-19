//package com.yy.game.ljzzz.admin.interceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import com.duowan.udb.UDBClient;
//import com.duowan.udb.UDBDefinition;
//import com.yy.game.ljzzz.constants.AdminConstant;
//
///**
// * 全局拦截器,初始化数据和权限检查
// */
//public class OverallInterceptor extends HandlerInterceptorAdapter implements InitializingBean {
//
//	private static final Logger ILOG = LoggerFactory.getLogger(OverallInterceptor.class);
//	
//	@Autowired
//	private UDBDefinition udbDefinition;
//	
//	public void setUdbDefinition(UDBDefinition udbDefinition) {
//		this.udbDefinition = udbDefinition;
//	}
//
//	// 全局拦截功能
//	@Override
//	public boolean preHandle(HttpServletRequest request,
//			HttpServletResponse response, Object handler) throws Exception {
//		ILOG.debug("进入全局截器");
//		//过滤不需要处理的URL
//		boolean isExclude = this.excludeCheckUrl(request);
//		if(isExclude){
//			return true;
//		}
//		
//		//验证用户是否已登陆
//		boolean isLogin = this.checkLogin(request);
//		if(!isLogin){
//			response.sendRedirect(UDBClient.getIndexUrl(udbDefinition));
//			return false;
//		}
//		
//		return true;
//	}
//	
//
//	/**
//	 * 过滤不需要经过过滤器的URL
//	 * 
//	 * @param request
//	 * @return
//	 */
//	private boolean excludeCheckUrl(HttpServletRequest request){
//		boolean isExcludeUrl = false;
//		
//		String uri = request.getRequestURI();		
//		if ("/admin/login.do".indexOf(uri) >= 0) {
//			isExcludeUrl = true;
//		}
//        
//		return isExcludeUrl;
//	}
//	
//	/**
//	 * 
//	 * 检查用户是否已登陆或都不需要登陆
//	 * 
//	 * @param session
//	 * @return
//	 */
//	private boolean checkLogin(HttpServletRequest request){
//		boolean isLogin  = false;
//
//		//检查用户是否已登陆
//		HttpSession session = request.getSession();
//		String userName = (String)session.getAttribute(AdminConstant.ADMIN_UDB_USER_IN_SESSION);
//		if(StringUtils.isNotBlank(userName)){
//			isLogin = true;
//		}
//		
//		return isLogin;
//		
//	}
//
//	// 会在每个请求的最后执行
//	@Override
//	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//	}
//
//	@Override
//	public void afterPropertiesSet() throws Exception {
//	}
//}
