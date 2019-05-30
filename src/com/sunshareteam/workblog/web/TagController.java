package com.sunshareteam.workblog.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
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
import com.sunshareteam.workblog.entity.Tag;
import com.sunshareteam.workblog.service.TagService;

@RestController
@RequestMapping("/tag")
public class TagController {
	@Autowired
	private TagService tagService;
	
	/**
	 * 查询标签
	 * @param index 第几页
	 * @param length 一页几条
	 * @param key 关键字
	 * @return 查询成功返回ResponseResult<PageInfo<User>>分页数据，失败抛出异常LeeException
	 */
	@RequiresPermissions("tag:select:*")
	@GetMapping("/gettag/{index}/{length}")
	public ResponseResult<PageInfo<Tag>> getAdmin(@PathVariable int index,@PathVariable int length,String key) {
		ResponseResult<PageInfo<Tag>> result=new ResponseResult<PageInfo<Tag>>();
		
		return result;
	}
	
	/**
	 * 得到指定id的标签
	 * @param tagid 标签id
	 * @return 成功返回ResponseResult<Tag> state：1，message：查询成功,data:tag的json
	 */
	@GetMapping("/get/{Tagid}")
	public ResponseResult<Tag> getTagId(@PathVariable Integer tagid) {
		ResponseResult<Tag> result=new ResponseResult<Tag>();
		return result;
	}
	/** 
	 * 删除指定id的标签，只有角色中管理员才可以可以调用
	 * @param tagid
	 * @return 删除成功则返回ResponseResult<String>，state:1,message禁用失败，失败抛出异常
	 */
	@RequiresRoles("admin")
	@RequiresPermissions("tag:delete:*")
	@DeleteMapping("/delete/{tagid}")
       public ResponseResult<String> deleteTag(@PathVariable Integer tagid){
    	
    	ResponseResult<String> result=new ResponseResult<String>();
    	
    	return result;
		
	}
	/**
	 * 更新标签信息
	 * @param tag 你更改后的标签信息
	 * @return 成功则返回ResponseResult<Tag> state：1，message：更新成功，data：你改后的分类信息
	 */
	@RequiresPermissions("tag:update:*")
	@PutMapping("/update")
	public ResponseResult<Tag> updateTag(Tag tag){
		ResponseResult<Tag> result =new ResponseResult<Tag>();
		return result;
	}
	  /** 
	   * 更改标签信息
	   * @param tag 更改后的标签信息
	   * @param session
	   * @return 更改成功则返回ResponseResult<Tag>,state:1,message:修改成功,date:更改后的标签信息json，失败抛出异常
	   */
	 @RequiresRoles("admin")
	 @RequiresPermissions("tag:update:*") 
	 @PutMapping("/update") 
	    public ResponseResult<Tag> updateTag(Tag tag,HttpSession session){
		   ResponseResult<Tag> result=new ResponseResult<Tag>();
		   Tag relTag=(Tag) SecurityUtils.getSubject().getPrincipals();
		   SecurityUtils.getSubject().hasRole("admin");
		   return result;
	 }
		
		/**
		 * 得到标签所属标签
		 * @param articleid 文章id
		 * @return 成功则返回ResponseResult<Tag> state：1，message：查询成功，data：该文章所属标签信息
		 */
		@GetMapping("/getbyarticle/{id}")
		public ResponseResult<Tag> getTagByArticle(@PathVariable int articleid){
			ResponseResult<Tag> result =new ResponseResult<Tag>();
			
			return result;
		}
	 /**
	  * 创建标签，创建一个全新的标签
	  * @param tag 你要创建的标签信息
	  * @return 更改成功则返回ResponseResult<Tag>,state:1,message:创建成功,date:创建后的标签信息json，失败抛出异常
	  */
	 @RequiresPermissions("tag:insert:*")
	 @PostMapping("/add") 
	    public ResponseResult<Tag> addTag(Tag tag){
		 ResponseResult<Tag> result=new ResponseResult<Tag>();
		 return result;
     }
	 /** 
	  * 查找全部标签
	 * @param tagid 你要查找的标签Id
	 * @return 查找成功则返回ResponseResult<String>，state:1,message禁用失败，失败抛出异常
	 */
		@GetMapping("/getall")
		public ResponseResult<List<Tag>> getAll(){
			ResponseResult<List<Tag>> result=new ResponseResult<List<Tag>>();
			return result;
		}
	 
	 /**
	  * 添加已有标签，添加标签id和文章id
	 * @param tag 
	 * @return 添加成功则返回ResponseResult<String>，state:1,message禁用失败，失败抛出异常
	 */
	 @RequiresPermissions("tag:insert:*")
	 @PostMapping("/establish") 
	    public ResponseResult<String> establishTag(Integer articleid,Integer tagid){
		ResponseResult<String> result=new ResponseResult<String>();
		return result;
     } 
	 
}
