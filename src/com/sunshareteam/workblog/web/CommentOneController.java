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
import com.sunshareteam.workblog.entity.CommentOne;
import com.sunshareteam.workblog.entity.User;
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
	public ResponseResult<PageInfo<CommentOne>> getUser(@PathVariable int index,@PathVariable int length,@RequestParam(defaultValue = "_",required = false) String key) {
		ResponseResult<PageInfo<CommentOne>> result=new ResponseResult<PageInfo<CommentOne>>();
		PageInfo<CommentOne> data=commentoneService.getByKey(key, index, length);
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
	 * 查询一级评论管理的内容
	 * @param index 第几页
	 * @param length 一页几条
	 * @return 查询成功返回ResponseResult<PageInfo<CommentOneVO>>分页数据，失败抛出异常LeeException
	 */
	@RequiresPermissions("commentone:select:*")
	@GetMapping("/getbyarticleanduser/{index}/{length}")
	public ResponseResult<PageInfo<CommentOneVO>> ByArticleAndUser(@PathVariable int index,@PathVariable int length){
		ResponseResult<PageInfo<CommentOneVO>> result=new ResponseResult<PageInfo<CommentOneVO>>();
		PageInfo<CommentOneVO> data=commentoneService.getByArticleAndUser(index, length);
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
	 * 得到指定id的一级评论
	 * @param id 一级评论id
	 * @return 成功返回ResponseResult<CommentOne> state：1，message：查询成功,data:CommentOne的json
	 */
	@GetMapping("/get/{id}")
	public ResponseResult<CommentOne> getById(@PathVariable Integer id) {
		ResponseResult<CommentOne> result=new ResponseResult<CommentOne>();
		CommentOne commentone=commentoneService.getById(id);
		if(ObjectUtils.allNotNull(commentone)) {
			result.setData(commentone);
			result.setMessage("查询成功");
			result.setState(LeeConstant.STATE_SUCCESS);
			return result;
		}
		result.setMessage("查询为空");
		result.setState(LeeConstant.STATE_FAIL);
		return result;
	}
	/**
	 * 删除指定id的一级评论
	 * @param id 一级评论id
	 * @return 成功返回ResponseResult<String> state：1，message：删除成功,data:null
	 */
	@RequiresPermissions("commentone:delete:*")
	@DeleteMapping("/delete/{id}")
	public ResponseResult<String> DeleteCommentOne(@PathVariable Integer id) {
		ResponseResult<String> result=new ResponseResult<String>();
		try {
			commentoneService.delete(id);
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
	 * 添加一级评论
	 * @param commentone 你要添加的一级评论信息
	 * @return  成功返回ResponseResult<String> state：1，message：添加成功,data:你添加的一级评论dejson
	 */
	@RequiresPermissions("commentone:insert:*")
	@PostMapping("/add")
	public ResponseResult<CommentOne> addCategoty(CommentOne commentone){
		ResponseResult<CommentOne> result =new ResponseResult<CommentOne>();
		User user =(User) SecurityUtils.getSubject().getPrincipal();
		commentone.setModifyuser(user.getUserid());
		try {
			commentoneService.insertCommentOne(commentone);
			result.setData(commentone);
			result.setMessage("添加成功");
			result.setState(LeeConstant.STATE_SUCCESS);
		} catch (Exception e) {
			result.setData(commentone);
			result.setMessage("添加失败");
			result.setState(LeeConstant.STATE_FAIL);
		}
		return result;
	}	
	/**
	 * 得到全部一级评论
	 * @return 成功则返回ResponseResult<List<Categoty>> state：1，message：查询成功 ，data：所有一级评论的列表json
	 */
	@GetMapping("/getall")
	public ResponseResult<List<CommentOne>> getAll(){
		ResponseResult<List<CommentOne>> result=new ResponseResult<List<CommentOne>>();
		PageInfo<CommentOne> info=commentoneService.getAll(0, 1000);
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
	 * 得到一级评论用户信息
	 * @param userid 用户id
	 * @return 成功则返回ResponseResult<Tag> state：1，message：查询成功，data：得到一级评论用户信息
	 */
	@GetMapping("/getbyuser/{id}")
	public ResponseResult<List<CommentOne>> getCommentOneByUser(@PathVariable int userid){
		ResponseResult<List<CommentOne>> result =new ResponseResult<List<CommentOne>>();
		PageInfo<CommentOne> info=commentoneService.getByUser(userid, 0, 1000);
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
	 * 查询同文章评论，全部
	 * @param index 第几页
	 * @param length 页面长度
	 * @param articleid 文章id
	 * @return 成功则返回 ResponseResult<PageInfo<CommentOne>> state：1，message：查询成功 data：评论分页信息
	 */
	@GetMapping("/getbyarticleall/{index}/{length}")
	public ResponseResult<PageInfo<CommentOne>> getCommentOneByArticleAll(Integer articleid,@PathVariable int index,@PathVariable int length){
		ResponseResult<PageInfo<CommentOne>> result =new ResponseResult<PageInfo<CommentOne>>();
		PageInfo<CommentOne> data=commentoneService.getByArticleAll(articleid, index, length);
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
	 * 查询同用户评论，全部
	 * @param index 第几页
	 * @param length 页面长度
	 * @param userid 用户id
	 * @return 成功则返回 ResponseResult<PageInfo<CommentOne>> state：1，message：查询成功 data：评论分页信息
	 */
	@GetMapping("/getbyuserall/{index}/{length}")
	public ResponseResult<PageInfo<CommentOne>> getByUserAll(@PathVariable int index,@PathVariable int length,Integer userid){
		ResponseResult<PageInfo<CommentOne>> result =new ResponseResult<PageInfo<CommentOne>>();
		PageInfo<CommentOne> data=commentoneService.getByUserAll(userid, index, length);
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
