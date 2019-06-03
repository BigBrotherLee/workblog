package com.sunshareteam.workblog.web;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigbrotherlee.utils.ResponseResult;
import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.Link;
import com.sunshareteam.workblog.service.LinkService;

@RestController
@RequestMapping("/link")
public class LinkController {
	@Autowired
	private LinkService linkService;
	/**
	 * 查询友链
	 * @param index 第几页
	 * @param length 一页几条
	 * @return 查询成功返回ResponseResult<PageInfo<CommentOne>>分页数据，失败抛出异常LeeException
	 */
	@RequiresPermissions("link:select:*")
	@GetMapping("/getlink/{index}/{length}")
	public ResponseResult<PageInfo<Link>> getUser(@PathVariable int index,@PathVariable int length) {
		ResponseResult<PageInfo<Link>> result=new ResponseResult<PageInfo<Link>>();
		
		return result;
	}
	
	/**
	 * 删除指定id的友链
	 * @param id 友链id
	 * @return 成功返回ResponseResult<String> state：1，message：删除成功,data:null
	 */
	@RequiresPermissions("link:delete:*")
	@DeleteMapping("/delete/{id}")
	public ResponseResult<String> DeleteLink(@PathVariable String id) {
		ResponseResult<String> result=new ResponseResult<String>();
		
		return result;
	}
	
	/**
	 * 添加友链
	 * @param link 你要添加的友链信息
	 * @return  成功返回ResponseResult<String> state：1，message：添加成功,data:你添加的友链的json
	 */
	@RequiresPermissions("link:insert:*")
	@PostMapping("/add")
	public ResponseResult<Link> addTag(Link link){
		ResponseResult<Link> result =new ResponseResult<Link>();
		return result;
	}
	/**
	 * 更新友链信息
	 * @param link 你更改后的友链信息
	 * @return 成功则返回ResponseResult<Link> state：1，message：更新成功，data：你改后的友链信息
	 */
	@RequiresPermissions("link:update:*")
	@PutMapping("/update")
	public ResponseResult<Link> updateLink(Link link){
		ResponseResult<Link> result =new ResponseResult<Link>();
		return result;
	}
	/**
	 * 得到全部友链
	 * @return 成功则返回ResponseResult<List<link>> state：1，message：查询成功 ，data：所有友链的列表json
	 */
	@GetMapping("/getall")
	public ResponseResult<List<Link>> getAll(){
		ResponseResult<List<Link>> result=new ResponseResult<List<Link>>();
		return result;
	}
}
