package com.yy.game.ljzzz.admin.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * 
 * @author chenming@yy.com
 */
public class DateWebBindingInitializer implements WebBindingInitializer {

	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		CustomDateEditor dateEditor = new CustomDateEditor(df, true);  
		binder.registerCustomEditor(Date.class, dateEditor);    
	}

}
