package com.sunshareteam.workblog.web;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bigbrotherlee.utils.LeeConstant;
import com.bigbrotherlee.utils.ResponseResult;
import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.Link;
import com.sunshareteam.workblog.entity.User;
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
	 * @param key 搜索关键字
	 * @return 查询成功返回ResponseResult<PageInfo<CommentOne>>分页数据，失败抛出异常LeeException
	 */
	@RequiresPermissions("link:select:*")
	@GetMapping("/getlink")
	public ResponseResult<PageInfo<Link>> getUser(int index,int length,@RequestParam(defaultValue = "_",required = false) String key) {
		ResponseResult<PageInfo<Link>> result=new ResponseResult<PageInfo<Link>>();
		PageInfo<Link> data=linkService.getByKey(key, index, length);
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
	 * 得到指定id的友链
	 * @param id 友链id
	 * @return 成功返回ResponseResult<Link> state：1，message：查询成功,data:Categoty的json
	 */
	@GetMapping("/get")
	public ResponseResult<Link> getById(Integer id) {
		ResponseResult<Link> result=new ResponseResult<Link>();
		Link link=linkService.getById(id);
		if(ObjectUtils.allNotNull(link)) {
			result.setData(link);
			result.setMessage("查询成功");
			result.setState(LeeConstant.STATE_SUCCESS);
			return result;
		}
		result.setMessage("查询为空");
		result.setState(LeeConstant.STATE_FAIL);
		return result;
	}
	
	/**
	 * 删除指定id的友链
	 * @param id 友链id
	 * @return 成功返回ResponseResult<String> state：1，message：删除成功,data:null
	 */
	@RequiresPermissions("link:delete:*")
	@DeleteMapping("/delete")
	public ResponseResult<String> DeleteLink(Integer id) {
		ResponseResult<String> result=new ResponseResult<String>();
		try {
			linkService.deleteLink(id);
			result.setData(id.toString());
			result.setMessage("删除成功");
			result.setState(LeeConstant.STATE_SUCCESS);
		}catch (Exception e) {
			result.setData(id.toString());
			result.setMessage("删除失败");
			result.setState(LeeConstant.STATE_FAIL);
		}
		return result;
	}
	
	/**
	 * 添加友链
	 * @param link 你要添加的友链信息
	 * @return  成功返回ResponseResult<String> state：1，message：添加成功,data:你添加的友链的json
	 */
	@RequiresPermissions("link:insert:*")
	@PostMapping("/add")
	public ResponseResult<Link> addTag(@RequestBody Link link){
		ResponseResult<Link> result =new ResponseResult<Link>();
		try {
		    linkService.insertLink(link);
			result.setData(link);
			result.setMessage("添加成功");
			result.setState(LeeConstant.STATE_SUCCESS);
		}catch (Exception e) {
			result.setData(link);
			result.setMessage("添加失败");
			result.setState(LeeConstant.STATE_FAIL);
		}
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
		User user =(User) SecurityUtils.getSubject().getPrincipal();
		link.setModifyuser(user.getUserid());
		try {
			linkService.updateLink(link);
			result.setData(link);
			result.setMessage("更新成功");
			result.setState(LeeConstant.STATE_SUCCESS);
		}catch (Exception e) {
			result.setData(link);
			result.setMessage("更新失败");
			result.setState(LeeConstant.STATE_FAIL);
		}
		return result;
	}
	/**
	 * 查询全部友链
	 * @param index 第几页
	 * @param length 页面长度
	 * @return 成功则返回 ResponseResult<PageInfo<Link>> state：1，message：查询成功 data：友链分页信息
	 */
	@GetMapping("/getall")
	public ResponseResult<PageInfo<Link>> getAll(int index,int length){
		ResponseResult<PageInfo<Link>> result =new ResponseResult<PageInfo<Link>>();
		PageInfo<Link> data=linkService.getAll(index, length);
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
}
