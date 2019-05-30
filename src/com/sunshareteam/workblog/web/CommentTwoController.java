package com.sunshareteam.workblog.web;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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


@RestController
@RequestMapping("/commentwo")
public class CommentTwoController {
//	@Autowired
//	private CommentTwoService commenttwoService;


	/**
	 * 得到指定id的二级评论
	 * @param commenttwoid 二级评论id
	 * @return 成功返回ResponseResult<CommentTwo> state：1，message：查询成功,data:Categoty的json
	 */
	@GetMapping("/get/{comment_two_id}")
	public ResponseResult<CommentTwo> getByCommentTwoId(@PathVariable Integer commenttwoid) {
		ResponseResult<CommentTwo> result=new ResponseResult<CommentTwo>();
		return result;
	}
	
	/**
	 * 删除指定id的二级评论
	 * @param commenttwoid 二级评论id
	 * @return 成功返回ResponseResult<String> state：1，message：删除成功,data:null
	 */
	@RequiresPermissions("commentone:delete:*")
	@DeleteMapping("/delete/{comment_two_id}")
	public ResponseResult<String> DeleteCommentTwo(@PathVariable String commenttwoid) {
		ResponseResult<String> result=new ResponseResult<String>();
		
		return result;
	}
	/**
	 * 二级评论内容
	 * @param commenttwo 你要二级评论的内容
	 * @return  成功返回ResponseResult<String> state：1，message：评论成功,data:你添加的评论的json
	 */
	@RequiresPermissions("commenttwo:insert:*")
	@PostMapping
	public ResponseResult<CommentTwo> addCommentTwo(CommentTwo commenttwo){
		ResponseResult<CommentTwo> result =new ResponseResult<CommentTwo>();
		return result;
	}
	
	/**
	 * 更新二级评论信息
	 * @param commenttwo 你更改后的二级评论信息
	 * @return 成功则返回ResponseResult<CommentOne> state：1，message：更新成功，data：你改后的二级评论信息
	 */
	@RequiresPermissions("commenttwo:update:*")
	@PutMapping("/update")
	public ResponseResult<CommentTwo> updateCommentTwo(CommentTwo commenttwo){
		ResponseResult<CommentTwo> result =new ResponseResult<CommentTwo>();
		return result;
	}
	/**
	 * 得到二级评论的用户id
	 * @param articleid 二级评论的用户id
	 * @return 成功则返回ResponseResult<二级评论> state：1，message：查询成功，data：二级评论的用户信息
	 */
	@GetMapping("/getbyarticle/{id}")
	public ResponseResult<CommentTwo> getCommentTwoByArticle(@PathVariable int articleid){
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
	

}
