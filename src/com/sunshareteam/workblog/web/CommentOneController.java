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
import com.sunshareteam.workblog.entity.Categoty;
import com.sunshareteam.workblog.entity.CommentOne;
import com.sunshareteam.workblog.entity.Tag;
import com.sunshareteam.workblog.service.CommentOneService;

@RestController
@RequestMapping("/commentone")
public class CommentOneController {
	@Autowired
	private CommentOneService commentoneService;
	
	/**
	 * 查询一级评论
	 * @param index 第几页
	 * @param length 一页几条
	 * @param key 关键字
	 * @return 查询成功返回ResponseResult<PageInfo<CommentOne>>分页数据，失败抛出异常LeeException
	 */
	@RequiresPermissions("commentone:select:*")
	@GetMapping("/getcommentone/{index}/{length}")
	public ResponseResult<PageInfo<CommentOne>> getUser(@PathVariable int index,@PathVariable int length,String key) {
		ResponseResult<PageInfo<CommentOne>> result=new ResponseResult<PageInfo<CommentOne>>();
		
		return result;
	}
	/**
	 * 删除指定id的一级评论
	 * @param id 一级评论id
	 * @return 成功返回ResponseResult<String> state：1，message：删除成功,data:null
	 */
	@RequiresPermissions("commentone:delete:*")
	@DeleteMapping("/delete/{id}")
	public ResponseResult<String> DeleteCommentOne(@PathVariable String id) {
		ResponseResult<String> result=new ResponseResult<String>();
		
		return result;
	}
	
	/**
	 * 添加一级评论
	 * @param commentone 你要添加的一级评论信息
	 * @return  成功返回ResponseResult<String> state：1，message：添加成功,data:你添加的一级评论dejson
	 */
	@RequiresPermissions("commentone:insert:*")
	@PostMapping("/add")
	public ResponseResult<CommentOne> addCategoty(CommentOne commentone){
		ResponseResult<CommentOne> result =new ResponseResult<CommentOne>();
		return result;
	}
	/**
	 * 得到全部一级评论
	 * @return 成功则返回ResponseResult<List<Categoty>> state：1，message：查询成功 ，data：所有一级评论的列表json
	 */
	@GetMapping("/getall")
	public ResponseResult<List<CommentOne>> getAll(){
		ResponseResult<List<CommentOne>> result=new ResponseResult<List<CommentOne>>();
		return result;
	}
	/**
	 * 得到一级评论信息用户
	 * @param userid 用户id
	 * @return 成功则返回ResponseResult<Tag> state：1，message：查询成功，data：得到一级评论角色信息
	 */
	@GetMapping("/getbyuser/{id}")
	public ResponseResult<CommentOne> getTagByUser(@PathVariable int userid){
		ResponseResult<CommentOne> result =new ResponseResult<CommentOne>();
		
		return result;
	}
}
