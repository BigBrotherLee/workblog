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

@RestController
@RequestMapping("/commentone")
public class CommentOneController {
//	@Autowired
//	private CommentOneService commentoneService;
	
	/**
	 * 查询一级评论
	 * @param index 第几页
	 * @param length 一页几条
	 * @param key 关键字
	 * @return 查询成功返回ResponseResult<PageInfo<User>>分页数据，失败抛出异常LeeException
	 */
	@RequiresPermissions("commentone:select:*")
	@GetMapping("/getcommentone/{index}/{length}")
	public ResponseResult<PageInfo<CommentOne>> getAdmin(@PathVariable int index,@PathVariable int length,String key) {
		ResponseResult<PageInfo<CommentOne>> result=new ResponseResult<PageInfo<CommentOne>>();
		
		return result;
	}
	/**
	 * 得到指定id的一级评论
	 * @param commentoneid 一级评论id
	 * @return 成功返回ResponseResult<CommentOne> state：1，message：查询成功,data:Categoty的json
	 */
	@GetMapping("/get/{comment_one_id}")
	public ResponseResult<CommentOne> getByCommentOneId(@PathVariable Integer commentoneid) {
		ResponseResult<CommentOne> result=new ResponseResult<CommentOne>();
		return result;
	}
	
	/**
	 * 删除指定id的一级评论
	 * @param commentoneid 一级评论id
	 * @return 成功返回ResponseResult<String> state：1，message：删除成功,data:null
	 */
	@RequiresPermissions("commentone:delete:*")
	@DeleteMapping("/delete/{comment_one_id}")
	public ResponseResult<String> DeleteCommentOne(@PathVariable String commentoneid) {
		ResponseResult<String> result=new ResponseResult<String>();
		
		return result;
	}
	/**
	 * 一级评论内容
	 * @param commentone 你要一级评论的内容
	 * @return  成功返回ResponseResult<String> state：1，message：评论成功,data:你添加的评论的json
	 */
	@RequiresPermissions("commentone:insert:*")
	@PostMapping
	public ResponseResult<CommentOne> addCommentOne(CommentOne commentone){
		ResponseResult<CommentOne> result =new ResponseResult<CommentOne>();
		return result;
	}
	
	/**
	 * 更新一级评论信息
	 * @param commentone 你更改后的一级评论信息
	 * @return 成功则返回ResponseResult<CommentOne> state：1，message：更新成功，data：你改后的二级评论信息
	 */
	@RequiresPermissions("commentone:update:*")
	@PutMapping("/update")
	public ResponseResult<CommentOne> updateCommentOne(CommentOne commentone){
		ResponseResult<CommentOne> result =new ResponseResult<CommentOne>();
		return result;
	}
	/**
	 * 得到一级评论的用户id
	 * @param articleid 一级评论的用户id
	 * @return 成功则返回ResponseResult<CommentOne> state：1，message：查询成功，data：一级评论的用户信息
	 */
	@GetMapping("/getbyarticle/{id}")
	public ResponseResult<CommentOne> getCommentOneByArticle(@PathVariable int articleid){
		ResponseResult<CommentOne> result =new ResponseResult<CommentOne>();
		
		return result;
	}
	
	/**
	 * 得到全部一级评论
	 * @return 成功则返回ResponseResult<List<CommentOne>> state：1，message：查询成功 ，data：所有一级评论的列表json
	 */
	@GetMapping("/getall")
	public ResponseResult<List<CommentOne>> getAll(){
		ResponseResult<List<CommentOne>> result=new ResponseResult<List<CommentOne>>();
		return result;
	}
	

}
