package com.sunshareteam.workblog.web;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bigbrotherlee.utils.LeeConstant;
import com.bigbrotherlee.utils.ResponseResult;
import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.CommentTwo;
import com.sunshareteam.workblog.entity.User;
import com.sunshareteam.workblog.service.CommentTwoService;


@RestController
@RequestMapping("/commentwo")
public class CommentTwoController {
	@Autowired
	private CommentTwoService commenttwoService;

	/**
	 * 查询二级评论
	 * @param index 第几页
	 * @param length 一页几条
	 * @param key 关键字
	 * @return 查询成功返回ResponseResult<PageInfo<CommentTwo>>分页数据，失败抛出异常LeeException
	 */
	@RequiresPermissions("commenttwo:select:*")
	@GetMapping("/getcommenttwo/{index}/{length}")
	public ResponseResult<PageInfo<CommentTwo>> getUser(@PathVariable int index,@PathVariable int length,@RequestParam(defaultValue = "_",required = false) String key) {
		ResponseResult<PageInfo<CommentTwo>> result=new ResponseResult<PageInfo<CommentTwo>>();
		PageInfo<CommentTwo> data=commenttwoService.getByKey(key, index, length);
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
	 * 得到指定id的二级评论
	 * @param id 二级评论id
	 * @return 成功返回ResponseResult<CommentTwo> state：1，message：查询成功,data:CommentTwo的json
	 */
	@GetMapping("/get/{id}")
	public ResponseResult<CommentTwo> getById(@PathVariable Integer id) {
		ResponseResult<CommentTwo> result=new ResponseResult<CommentTwo>();
		CommentTwo commenttwo=commenttwoService.getById(id);
		if(ObjectUtils.allNotNull(commenttwo)) {
			result.setData(commenttwo);
			result.setMessage("查询成功");
			result.setState(LeeConstant.STATE_SUCCESS);
			return result;
		}
		result.setMessage("查询为空");
		result.setState(LeeConstant.STATE_FAIL);
		return result;
	}
	/**
	 * 删除指定id的二级评论
	 * @param id 二级评论id
	 * @return 成功返回ResponseResult<String> state：1，message：删除成功,data:null
	 */
	@RequiresPermissions("commentone:delete:*")
	@DeleteMapping("/delete/{id}")
	public ResponseResult<String> DeleteCommentTwo(@PathVariable Integer id) {
		ResponseResult<String> result=new ResponseResult<String>();
		try {
			commenttwoService.deleteCommentTwo(id);
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
	 * 添加二级评论
	 * @param commenttwo 你要添加的二级评论信息
	 * @return  成功返回ResponseResult<String> state：1，message：添加成功,data:你添加的二级评论dejson
	 */
	@RequiresPermissions("commenttwo:insert:*")
	@PostMapping("/add")
	public ResponseResult<CommentTwo> addCategoty(CommentTwo commenttwo){
		ResponseResult<CommentTwo> result =new ResponseResult<CommentTwo>();
		User user =(User) SecurityUtils.getSubject().getPrincipal();
		commenttwo.setModifyuser(user.getUserid());
		try {
			commenttwoService.insertCommentTwo(commenttwo);
			result.setData(commenttwo);
			result.setMessage("添加成功");
			result.setState(LeeConstant.STATE_SUCCESS);
		} catch (Exception e) {
			result.setData(commenttwo);
			result.setMessage("添加失败");
			result.setState(LeeConstant.STATE_FAIL);
		}
		return result;
	}	
	/**
	 * 得到全部二级评论
	 * @return 成功则返回ResponseResult<List<CommentTwo>> state：1，message：查询成功 ，data：所有一级评论的列表json
	 */
	@GetMapping("/getall")
	public ResponseResult<List<CommentTwo>> getAll(){
		ResponseResult<List<CommentTwo>> result=new ResponseResult<List<CommentTwo>>();
		PageInfo<CommentTwo> info=commenttwoService.getAll(0, 1000);
		if(info.getTotal()<=0) {
			result.setMessage("查询为空");
			result.setState(LeeConstant.STATE_FAIL);
			return result;
		}
		result.setData(info.getList());
		result.setMessage("查询成功");
		result.setState(LeeConstant.STATE_SUCCESS);
		return result;
	}
	/**
	 * 得到二级评论用户信息
	 * @param userid 用户id
	 * @return 成功则返回ResponseResult<CommentTwo> state：1，message：查询成功，data：得到二级评论角色信息
	 */
	@GetMapping("/getbyUser/{id}")
	public ResponseResult<PageInfo<CommentTwo>> getCommentTwoByUser(@PathVariable int userid,@PathVariable int index,@PathVariable int length){
		ResponseResult<PageInfo<CommentTwo>> result =new ResponseResult<PageInfo<CommentTwo>>();
		PageInfo<CommentTwo> commenttwo=commenttwoService.getByUser(userid, 0, 1000);
		if(ObjectUtils.allNotNull(commenttwo)) {
			result.setMessage("查询成功");
			result.setState(LeeConstant.STATE_SUCCESS);
			return result;
		}
		result.setMessage("查询为空");
		result.setState(LeeConstant.STATE_SUCCESS);
		return result;
	}
	/**
	 * 查询同一级评论的二级评论，全部
	 * @param oneid 一级评论id
	 * @return 成功则返回 ResponseResult<PageInfo<CommentTwo>> state：1，message：查询成功 data：评论分页信息
	 */
	@GetMapping("/getcommenttwobyoneall/{index}/{length}")
	public ResponseResult<List<CommentTwo>> getCommentTwoByOneAll(@PathVariable Integer oneid){
		ResponseResult<List<CommentTwo>> result =new ResponseResult<List<CommentTwo>>();
		PageInfo<CommentTwo> info=commenttwoService.getByOneAll(oneid,0,1000);
		if(info.getTotal()<=0) {
			result.setMessage("查询为空");
			result.setState(LeeConstant.STATE_FAIL);
			return result;
		}
		result.setData(info.getList());
		result.setMessage("查询成功");
		result.setState(LeeConstant.STATE_SUCCESS);
		return result;
	}
}
