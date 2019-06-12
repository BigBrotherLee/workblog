package com.sunshareteam.workblog.web;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigbrotherlee.utils.LeeConstant;
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
	@GetMapping("/getpage")
	public ResponseResult<PageInfo<Log>> getPage( int index,int length) {
		ResponseResult<PageInfo<Log>> result=new ResponseResult<PageInfo<Log>>();
		PageInfo<Log> data=logService.getAll(index, length);
		if(data.getTotal()<=0) {
			result.setMessage("查询为空");
			result.setState(LeeConstant.STATE_FAIL);
			return result;
		}
		result.setData(data);
		result.setMessage("查询成功");
		result.setState(LeeConstant.STATE_SUCCESS);
		return result;
	}
	
	/**
	 * 查看日志
	 * @param id 日志id
	 * @return Log详情
	 */
	@RequiresPermissions("log:select:*")
	@GetMapping("/get")
	public ResponseResult<Log> get(int id){
		ResponseResult<Log> result=new ResponseResult<Log>();
		Log log=logService.getById(id);
		if(ObjectUtils.allNotNull(log)) {
			result.setMessage("查询成功");
			result.setState(LeeConstant.STATE_SUCCESS);
			result.setData(log);
			return result;
		}
		result.setMessage("查询为空");
		result.setState(LeeConstant.STATE_FAIL);
		return result;
	}
}
