package com.sunshareteam.workblog.global;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bigbrotherlee.utils.LeeException;
import com.sunshareteam.workblog.entity.Log;
import com.sunshareteam.workblog.service.LogService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class LeeExceptionHandler {
	@Autowired
	private LogService logService;
	/**
	 * 拦截自定义异常
	 */
	 @ExceptionHandler(value = LeeException.class)
    public Map<String, Object> myErrorHandler(HttpServletRequest req, LeeException ex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 500);
        map.put("message", ex.getMessage());
        map.put("url", req.getRequestURL());
        map.put("params", req.getParameterMap());
        log.error("抛出自定义异常：---------",ex.getMessage(),ex);
        Log l=new Log();
        l.setCreatedate(new Date());
        l.setLogcontent(StringUtils.join(map, ","));
        logService.addLog(l);
        return map;
    }
	 
	/**
	 * 拦截全部其他异常
	 */
	@ExceptionHandler(value = Exception.class)
    public Map<String, Object> errorHandler(HttpServletRequest req,Exception ex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 100);
        map.put("message", ex.getMessage());
        map.put("url", req.getRequestURL());
        map.put("params", req.getParameterMap());
        log.error("发生未处理的异常={}",ex.getMessage(),ex);
        return map;
    }
 
}
