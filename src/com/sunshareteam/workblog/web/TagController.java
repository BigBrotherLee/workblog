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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bigbrotherlee.utils.LeeConstant;
import com.bigbrotherlee.utils.ResponseResult;
import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.Tag;
import com.sunshareteam.workblog.entity.User;
import com.sunshareteam.workblog.service.TagService;

@RestController
@RequestMapping("/tag")
public class TagController {
	@Autowired
	private TagService tagService;
	
	/**
	 * 得到指定id的标签
	 * @param id 标签id
	 * @return 成功返回ResponseResult<Tag> state：1，message：查询成功,data:Categoty的json
	 */
	@GetMapping("/get/{id}")
	public ResponseResult<Tag> getById(@PathVariable Integer id) {
		ResponseResult<Tag> result=new ResponseResult<Tag>();
		Tag tag=tagService.getById(id);
		if(ObjectUtils.allNotNull(tag)) {
			result.setData(tag);
			result.setMessage("查询成功");
			result.setState(LeeConstant.STATE_SUCCESS);
			return result;
		}
		result.setMessage("查询为空");
		result.setState(LeeConstant.STATE_FAIL);
		return result;
	}
	
	/**
	 * 删除指定id的标签
	 * @param id 标签id
	 * @return 成功返回ResponseResult<String> state：1，message：删除成功,data:null
	 */
	@RequiresPermissions("tag:delete:*")
	@DeleteMapping("/delete/{id}")
	public ResponseResult<String> DeleteTag(@PathVariable Integer id) {
		ResponseResult<String> result=new ResponseResult<String>();
		try {
			tagService.deleteTag(id);
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
	 * 添加标签
	 * @param tag 你要添加的标签信息
	 * @return  成功返回ResponseResult<String> state：1，message：添加成功,data:你添加的标签的json
	 */
	@RequiresPermissions("tag:insert:*")
	@PostMapping("/add")
	public ResponseResult<Tag> addTag(Tag tag){
		ResponseResult<Tag> result =new ResponseResult<Tag>();
		User user =(User) SecurityUtils.getSubject().getPrincipal();
		tag.setCreateuser(user.getUserid());
		try {
			tagService.insertTag(tag);
			result.setData(tag);
			result.setMessage("添加成功");
			result.setState(LeeConstant.STATE_SUCCESS);
		} catch (Exception e) {
			result.setData(tag);
			result.setMessage("添加失败");
			result.setState(LeeConstant.STATE_FAIL);
		}
		return result;
	}
    /**
	 * 添加已有标签
	 * @param articleid tagid 文章id 标签id
	 * @return 成功则返回ResponseResult<Tag> state：1，message：查询成功，data：该文章所属标签信息
	 */
	@RequiresPermissions("tag:insert:*")
	@GetMapping("/add/{articleid}/{tagid}")
	public ResponseResult<String> addTagArticled(Integer articleid,Integer tagid){
		ResponseResult<String> result =new ResponseResult<String>();
		try {
			tagService.insertArticleTag(articleid, tagid);
			result.setMessage("添加成功");
			result.setState(LeeConstant.STATE_SUCCESS);
		} catch (Exception e) {
			result.setMessage("添加失败");
			result.setState(LeeConstant.STATE_FAIL);
		}
		return result;
	}
	/**
	 * 更新标签信息
	 * @param tag 你更改后的标签信息
	 * @return 成功则返回ResponseResult<Tag> state：1，message：更新成功，data：你改后的标签信息
	 */
	@RequiresPermissions("tag:update:*")
	@PutMapping("/update")
	public ResponseResult<Tag> updateTag(Tag tag){
		ResponseResult<Tag> result =new ResponseResult<Tag>();
		User user =(User) SecurityUtils.getSubject().getPrincipal();
		tag.setModifyuser(user.getUserid());
		try {
			tagService.updateTag(tag);
			result.setData(tag);
			result.setMessage("更新成功");
			result.setState(LeeConstant.STATE_SUCCESS);
		}catch (Exception e) {
			result.setData(tag);
			result.setMessage("更新失败");
			result.setState(LeeConstant.STATE_FAIL);
		}
		return result;
	}
	/**
	 * 得到文章所有标签
	 * @param articleid 文章id
	 * @return 成功则返回ResponseResult<Tag> state：1，message：查询成功，data：该文章所属标签信息
	 */
	@GetMapping("/getTagbyarticle/{id}")
	public ResponseResult<List<Tag>> getTagByArticle(@PathVariable int articleid){
		ResponseResult<List<Tag>> result =new ResponseResult<List<Tag>>();
		Tag tag=tagService.getByArticle(articleid);
		if(ObjectUtils.allNotNull(tag)) {
			result.setMessage("查询成功");
			result.setState(LeeConstant.STATE_SUCCESS);
			return result;
		}
		result.setMessage("查询为空");
		result.setState(LeeConstant.STATE_SUCCESS);
		return result;
	}
	
	/**
	 * 得到全部标签
	 * @return 成功则返回ResponseResult<List<Tag>> state：1，message：查询成功 ，data：所有标签的列表json
	 */
	@GetMapping("/getall")
	public ResponseResult<List<Tag>> getAll(){
		ResponseResult<List<Tag>> result=new ResponseResult<List<Tag>>();
		PageInfo<Tag> info=tagService.getAll(0, 1000);
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
	 * 得到标签分页
	 * @param index 第几页
	 * @param length 每页几条
	 * @param key 搜索关键字
	 * @return 成功则返回ResponseResultPageInfo<Tag>> state：1，message：查询成功 ，data：分页标签的列表json
	 */
	@GetMapping("/getpage/{index}/{length}")
	public ResponseResult<PageInfo<Tag>> getPage(@PathVariable int index,@PathVariable int length,String key){
		ResponseResult<PageInfo<Tag>> result=new ResponseResult<PageInfo<Tag>>();
		PageInfo<Tag> data=tagService.getByKey(key, index, length);
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
