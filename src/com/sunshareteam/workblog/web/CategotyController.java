package com.sunshareteam.workblog.web;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bigbrotherlee.utils.LeeConstant;
import com.bigbrotherlee.utils.ResponseResult;
import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.Categoty;
import com.sunshareteam.workblog.entity.User;
import com.sunshareteam.workblog.service.CategotyService;

@RestController
@RequestMapping("/categoty")
public class CategotyController {
	@Autowired
	private CategotyService categotyService;
	
	
	/**
	 * 得到指定id的分类
	 * @param id 分类id
	 * @return 成功返回ResponseResult<Categoty> state：1，message：查询成功,data:Categoty的json
	 */
	@GetMapping("/get/{id}")
	public ResponseResult<Categoty> getById(@PathVariable Integer id) {
		ResponseResult<Categoty> result=new ResponseResult<Categoty>();
		Categoty categoty=categotyService.getById(id);
		if(ObjectUtils.allNotNull(categoty)) {
			result.setData(categoty);
			result.setMessage("查询成功");
			result.setState(LeeConstant.STATE_SUCCESS);
			return result;
		}
		result.setMessage("查询为空");
		result.setState(LeeConstant.STATE_FAIL);
		return result;
	}
	
	/**
	 * 删除指定id的分类
	 * @param id 分类id
	 * @return 成功返回ResponseResult<String> state：1，message：删除成功,data:null
	 */
	@RequiresPermissions("categoty:delete:*")
	@DeleteMapping("/delete/{id}")
	public ResponseResult<String> DeleteCategoty(@PathVariable Integer id) {
		ResponseResult<String> result=new ResponseResult<String>();
		try {
			categotyService.deleteCategoty(id);
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
	 * 添加分类
	 * @param categoty 你要添加的分类信息
	 * @return  成功返回ResponseResult<String> state：1，message：添加成功,data:你添加的分类dejson
	 */
	@RequiresPermissions("categoty:insert:*")
	@PostMapping("/add")
	public ResponseResult<Categoty> addCategoty(Categoty categoty){
		ResponseResult<Categoty> result =new ResponseResult<Categoty>();
		User user =(User) SecurityUtils.getSubject().getPrincipal();
		categoty.setModifyuser(user.getUserid());
		try {
			categotyService.insertCategoty(categoty);
			result.setData(categoty);
			result.setMessage("添加成功");
			result.setState(LeeConstant.STATE_SUCCESS);
		} catch (Exception e) {
			result.setData(categoty);
			result.setMessage("添加失败");
			result.setState(LeeConstant.STATE_FAIL);
		}
		return result;
	}
	
	/**
	 * 更新分类信息
	 * @param categoty 你更改后的分类信息
	 * @return 成功则返回ResponseResult<Categoty> state：1，message：更新成功，data：你改后的分类信息
	 */
	@RequiresPermissions("categoty:update:*")
	@PutMapping("/update")
	public ResponseResult<Categoty> updateCategoty(Categoty categoty){
		ResponseResult<Categoty> result =new ResponseResult<Categoty>();
		User user =(User) SecurityUtils.getSubject().getPrincipal();
		categoty.setModifyuser(user.getUserid());
		try {
			categotyService.updateGategoty(categoty);
			result.setData(categoty);
			result.setMessage("更新成功");
			result.setState(LeeConstant.STATE_SUCCESS);
		}catch (Exception e) {
			result.setData(categoty);
			result.setMessage("更新失败");
			result.setState(LeeConstant.STATE_FAIL);
		}
		return result;
	}
	
	
	/**
	 * 得到文章所属分类
	 * @param articleid 文章id
	 * @return 成功则返回ResponseResult<Categoty> state：1，message：查询成功，data：该文章所属分类信息
	 */
	@GetMapping("/getbyarticle/{articleid}")
	public ResponseResult<Categoty> getCategotyByArticle(@PathVariable Integer articleid){
		ResponseResult<Categoty> result =new ResponseResult<Categoty>();
		Categoty categoty=categotyService.getByArticle(articleid);
		if(ObjectUtils.allNotNull(categoty)) {
			result.setData(categoty);
			result.setMessage("查询成功");
			result.setState(LeeConstant.STATE_SUCCESS);
			return result;
		}
		result.setMessage("查询为空");
		result.setState(LeeConstant.STATE_SUCCESS);
		return result;
	}
	
	/**
	 * 得到全部分类
	 * @return 成功则返回ResponseResult<List<Categoty>> state：1，message：查询成功 ，data：所有分类的列表json
	 */
	@GetMapping("/getall")
	public ResponseResult<List<Categoty>> getAll(){
		ResponseResult<List<Categoty>> result=new ResponseResult<List<Categoty>>();
		PageInfo<Categoty> info=categotyService.getAll(0, 1000);
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
	 * 得到分类分页
	 * @param index 第几页
	 * @param length 每页几条
	 * @param key 搜索关键字
	 * @return 成功则返回ResponseResultPageInfo<Categoty>> state：1，message：查询成功 ，data：分页分类的列表json
	 */
	@GetMapping("/getpage/{index}/{length}")
	public ResponseResult<PageInfo<Categoty>> getPage(@PathVariable int index,@PathVariable int length,@RequestParam(defaultValue = "_",required = false) String key){
		ResponseResult<PageInfo<Categoty>> result=new ResponseResult<>();
		PageInfo<Categoty> data=categotyService.getByKey(key, index, length);
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
	 * 更改文章所属分类
	 * @param categotyid 分类id
	 * @param articleid 文章id
	 * @return ResponseResult<String> state：1，message：更改成功，失败抛出异常
	 */
	@RequiresRoles("user")
	@PutMapping("/updatetoarticle")
	public ResponseResult<String> updateCategotyToArticle(int categotyid,int articleid){
		ResponseResult<String> result=new ResponseResult<String>();
		try {
			categotyService.changeCategoty(categotyid, articleid);
			result.setData(categotyid+"#"+articleid);
			result.setMessage("设置成功");
			result.setState(LeeConstant.STATE_SUCCESS);;
		} catch (Exception e) {
			result.setMessage("设置失败");
			result.setState(LeeConstant.STATE_FAIL);
		}
		return result;
	}
}
