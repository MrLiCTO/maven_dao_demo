package com.ny.mall.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.mchange.v2.log.log4j.Log4jMLog;
import com.mysql.jdbc.log.Log;


/**
 * 
 * @ClassName: ExceptionResolverCustom 
 * @Description: 异常处理解析器
 * @author: lishilong
 * @date: 2016年2月19日 下午3:50:45
 */

public class ExceptionResolverCustom implements HandlerExceptionResolver {
	
	private static Logger logger = Logger.getLogger(ExceptionResolverCustom.class);  

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("message",ex.getMessage());
		
		mv.setViewName("/error");
		
		logger.error(ex.getMessage(),ex);
		
		return mv;
	}



	
}
