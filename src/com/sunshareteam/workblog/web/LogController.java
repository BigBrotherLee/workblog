package com.sunshareteam.workblog.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigbrotherlee.utils.ResponseResult;
import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.Log;
import com.sunshareteam.workblog.service.LogService;

@RestController
@RequestMapping("/log")
public class LogController {
	
	@Autowired
	private LogService logService;
	/**
	 * 查看日志分页数据
	 * @param index 第几页
	 * @param length 一页几条
	 * @return ResponseResult<PageInfo<Log>> 分页数
	 */
	@RequiresPermissions("log:select:*")
	@GetMapping("/getpage/{index}/{length}")
	public ResponseResult<PageInfo<Log>> getPage(@PathVariable int index,@PathVariable int length) {
		ResponseResult<PageInfo<Log>> result=new ResponseResult<PageInfo<Log>>();
		
		return result;
	}
	
	/**
	 * 查看日志
	 * @param id 日志id
	 * @return Log详情
	 */
	@RequiresPermissions("log:select:*")
	@GetMapping("/get/{id}")
	public ResponseResult<Log> get(@PathVariable int id){
		ResponseResult<Log> result=new ResponseResult<Log>();
		return result;
	}
}
