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
import com.sunshareteam.workblog.entity.CommentOne;
import com.sunshareteam.workblog.entity.CommentTwo;
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
	public ResponseResult<PageInfo<CommentTwo>> getUser(@PathVariable int index,@PathVariable int length,String key) {
		ResponseResult<PageInfo<CommentTwo>> result=new ResponseResult<PageInfo<CommentTwo>>();
		
		return result;
	}	
	/**
	 * 删除指定id的二级评论
	 * @param id 二级评论id
	 * @return 成功返回ResponseResult<String> state：1，message：删除成功,data:null
	 */
	@RequiresPermissions("commentone:delete:*")
	@DeleteMapping("/delete/{id}")
	public ResponseResult<String> DeleteCommentTwo(@PathVariable String id) {
		ResponseResult<String> result=new ResponseResult<String>();
		
		return result;
	}
	/**
	 * 添加二级评论
	 * @param categoty 你要添加的二级评论信息
	 * @return  成功返回ResponseResult<String> state：1，message：添加成功,data:你添加的二级评论dejson
	 */
	@RequiresPermissions("commenttwo:insert:*")
	@PostMapping("/add")
	public ResponseResult<CommentTwo> addCategoty(CommentTwo commenttwo){
		ResponseResult<CommentTwo> result =new ResponseResult<CommentTwo>();
		return result;
	}	
	/**
	 * 得到全部二级评论
	 * @return 成功则返回ResponseResult<List<CommentTwo>> state：1，message：查询成功 ，data：所有一级评论的列表json
	 */
	@GetMapping("/getall")
	public ResponseResult<List<CommentTwo>> getAll(){
		ResponseResult<List<CommentTwo>> result=new ResponseResult<List<CommentTwo>>();
		return result;
	}
	/**
	 * 得到二级评论用户
	 * @param user户
	 * @return 成功则返回ResponseResult<CommentTwo> state：1，message：查询成功，data：得到二级评论角色信息
	 */
	@GetMapping("/getbyUser/{id}")
	public ResponseResult<CommentTwo> getTagByUser(@PathVariable int userid){
		ResponseResult<CommentTwo> result =new ResponseResult<CommentTwo>();
		
		return result;
	}
	/**
	 * 得到个人的全部二级评论
	 * @return 成功则返回ResponseResult<List<CommentTwo>> state：1，message：查询成功 ，data：所有二级评论的列表json
	 */
	@GetMapping("/getpersonalall")
	public ResponseResult<List<CommentTwo>> getPersonalAll(){
		ResponseResult<List<CommentTwo>> result=new ResponseResult<List<CommentTwo>>();
		return result;
	}
}
