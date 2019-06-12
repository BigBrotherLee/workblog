package com.sunshareteam.workblog.web;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bigbrotherlee.utils.LeeConstant;
import com.bigbrotherlee.utils.LeeException;
import com.bigbrotherlee.utils.ResponseResult;
import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.Article;
import com.sunshareteam.workblog.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	/**
	 * 得到文章详情
	 * @param id 文章id
	 * @return 成功则返回 ResponseResult<Article> state：1，，message：查询成功 data：文章详情 
	 */
	@GetMapping("/get")
	public ResponseResult<Article> get(int id) {
		ResponseResult<Article> result=new ResponseResult<Article>();
		Article article=articleService.getById(id);
		if(ObjectUtils.allNotNull(article)) {
			result.setData(article);
			result.setMessage("查询成功");
			result.setState(LeeConstant.STATE_SUCCESS);
			return result;
		}
		result.setMessage("查询失败");
		result.setState(LeeConstant.STATE_FAIL);
		return result;
		
	}
	
	/**
	 * 删除文章
	 * @param id 要删除的文章id
	 * @return 成功则返回 ResponseResult<String> state：1，，message：删除成功  
	 */
	@RequiresPermissions("article:delete:*")
	@DeleteMapping("/delete")
	public ResponseResult<String> delete(int id) throws Exception{
		ResponseResult<String> result=new ResponseResult<String>();
		Integer userid=Integer.parseInt(BeanUtils.getProperty(SecurityUtils.getSubject().getPrincipal(), "userid"));
		Article realArticle=articleService.getById(id);
		boolean hasPermission=SecurityUtils.getSubject().hasRole("admin")||(realArticle.getAuthor()==userid);
		if(hasPermission) {
			try {
				articleService.delete(id);
				result.setData(Integer.toString(id));
				result.setMessage("已删除");
				result.setState(LeeConstant.STATE_SUCCESS);
			}catch (Exception e) {
				result.setMessage("删除失败");
				result.setState(LeeConstant.STATE_FAIL);
			}
			return result;
		}else {
			throw new LeeException("你没有权限");
		}
	}
	
	/**
	 * 创建文章
	 * @param article 你要创建的文章
	 * @return 成功则返回 ResponseResult<Article> state：1，，message：创建成功 data：文章详情 
	 */
	@RequiresPermissions("article:insert:*")
	@PostMapping("/add")
	public ResponseResult<Article> addArticle(Article article) throws Exception{
		ResponseResult<Article> result=new ResponseResult<Article>();
		Integer userid=Integer.parseInt(BeanUtils.getProperty(SecurityUtils.getSubject().getPrincipal(), "userid"));
		try {
			article.setAuthor(userid);
			article.setCreatedate(new Date());
			articleService.insertArticle(article);
			result.setData(article);
			result.setMessage("添加成功");
			result.setState(LeeConstant.STATE_SUCCESS);
		}catch (Exception e) {
			result.setData(article);
			result.setMessage("添加失败");
			result.setState(LeeConstant.STATE_FAIL);
		}
		return result;
	}
	
	
	/**
	 * 修改文章
	 * @param article 修改后的文章信息
	 * @return 成功则返回 ResponseResult<Article> state：1，，message：修改成功 data：文章详情 
	 */
	@RequiresPermissions("article:update:*")
	@PutMapping("/update")
	public ResponseResult<Article> updateArticle(Article article) throws Exception{
		ResponseResult<Article> result=new ResponseResult<Article>();
		Integer userid=Integer.parseInt(BeanUtils.getProperty(SecurityUtils.getSubject().getPrincipal(), "userid"));
		Article realArticle=articleService.getById(article.getArticleid());
		boolean hasPermission=SecurityUtils.getSubject().hasRole("admin")||(realArticle.getAuthor()==userid);
		if(hasPermission) {
			try {
				article.setModifyuser(userid);
				article.setModifydate(new Date());
				articleService.updateArticle(article);
				result.setData(article);
				result.setMessage("修改成功");
				result.setState(LeeConstant.STATE_SUCCESS);
			}catch (Exception e) {
				result.setMessage("修改失败");
				result.setState(LeeConstant.STATE_FAIL);
			}
			return result;
		}else {
			throw new LeeException("你没有权限");
		}
	}
	
	/**
	 * 根据关键字查询文章
	 * @param index 第几页
	 * @param length 页面长度
	 * @param key 关键字
	 * @return 成功则返回 ResponseResult<PageInfo<Article>> state：1，message：查询成功 data：文章分页信息
	 */
	@GetMapping("/getpage")
	public ResponseResult<PageInfo<ArticleVO>> getArticlePage(int index,int length,@RequestParam(defaultValue = "_",required = false) String key){
		ResponseResult<PageInfo<ArticleVO>> result =new ResponseResult<PageInfo<ArticleVO>>();
		PageInfo<ArticleVO> data=articleService.getByKey(key, index, length);
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
	 * 查询同作者文章
	 * @param index 第几页
	 * @param length 页面长度
	 * @param authorid 作者id
	 * @return 成功则返回 ResponseResult<PageInfo<Article>> state：1，message：查询成功 data：文章分页信息
	 */
	@GetMapping("/getpagebyarthor")
	public ResponseResult<PageInfo<ArticleVO>> getArticlePageByAuthor( int index, int length,Integer authorid){
		ResponseResult<PageInfo<ArticleVO>> result =new ResponseResult<PageInfo<ArticleVO>>();
		PageInfo<ArticleVO> data=articleService.getByAuthor(authorid, index, length);
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
	@GetMapping("/getmyarticle")
	public ResponseResult<PageInfo<ArticleVO>> getMyArticle(int index,int length) throws Exception{
		ResponseResult<PageInfo<ArticleVO>> result =new ResponseResult<PageInfo<ArticleVO>>();
		Integer userid=Integer.parseInt(BeanUtils.getProperty(SecurityUtils.getSubject().getPrincipal(), "userid"));
		PageInfo<ArticleVO> data=articleService.getByAuthor(userid, index, length);
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
	 * 查询同标签文章
	 * @param index 第几页
	 * @param length 页面长度
	 * @param tagid 标签id
	 * @return 成功则返回 ResponseResult<PageInfo<Article>> state：1，message：查询成功 data：文章分页信息
	 */
	@GetMapping("/getpagebytag")
	public ResponseResult<PageInfo<ArticleVO>> getArticlePageByTag(int index,int length,Integer tagid){
		ResponseResult<PageInfo<ArticleVO>> result =new ResponseResult<PageInfo<ArticleVO>>();
		PageInfo<ArticleVO> data=articleService.getByTag(tagid, index, length);
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
	 * 查询同分类文章
	 * @param index 第几页
	 * @param length 页面长度
	 * @param categoryid 分类id
	 * @return 成功则返回 ResponseResult<PageInfo<Article>> state：1，message：查询成功 data：文章分页信息
	 */
	@GetMapping("/getpagebycategory")
	public ResponseResult<PageInfo<ArticleVO>> getArticlePageByCategory(int index,int length,Integer categoryid){
		ResponseResult<PageInfo<ArticleVO>> result =new ResponseResult<PageInfo<ArticleVO>>();
		PageInfo<ArticleVO> data=articleService.getByCategoty(categoryid, index, length);
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
	 * 查询最新文章
	 * @param index 第几页
	 * @param length 页面长度
	 * @return 成功则返回 ResponseResult<PageInfo<Article>> state：1，message：查询成功 data：文章分页信息
	 */
	@GetMapping("/getnew")
	public ResponseResult<PageInfo<ArticleVO>> getNew(int index,int length){
		ResponseResult<PageInfo<ArticleVO>> result =new ResponseResult<PageInfo<ArticleVO>>();
		PageInfo<ArticleVO> info=articleService.getNew(index, length);
		if(info.getTotal()<=0) {
			result.setMessage("查询为空");
			result.setState(LeeConstant.STATE_FAIL);
			return result;
		}
		result.setData(info);
		result.setMessage("查询成功");
		result.setState(LeeConstant.STATE_SUCCESS);
		return result;
	}
	
	/**
	 * 查询最热文章
	 * @param index 第几页
	 * @param length 页面长度
	 * @return 成功则返回 ResponseResult<PageInfo<Article>> state：1，message：查询成功 data：文章分页信息
	 */
	@GetMapping("/gethot")
	public ResponseResult<PageInfo<ArticleVO>> getHot(int index,int length){
		ResponseResult<PageInfo<ArticleVO>> result =new ResponseResult<PageInfo<ArticleVO>>();
		PageInfo<ArticleVO> info=articleService.getHot(index, length);
		if(info.getTotal()<=0) {
			result.setMessage("查询为空");
			result.setState(LeeConstant.STATE_FAIL);
			return result;
		}
		result.setData(info);
		result.setMessage("查询成功");
		result.setState(LeeConstant.STATE_SUCCESS);
		return result;
	}
	
	/**
	 * 根据关键字查询文章,全部
	 * @param index 第几页
	 * @param length 页面长度
	 * @param key 关键字
	 * @return 成功则返回 ResponseResult<PageInfo<Article>> state：1，message：查询成功 data：文章分页信息
	 */
	@GetMapping("/getpageall")
	public ResponseResult<PageInfo<ArticleVO>> getArticlePageAll(int index,int length,@RequestParam(defaultValue = "_",required = false) String key){
		ResponseResult<PageInfo<ArticleVO>> result =new ResponseResult<PageInfo<ArticleVO>>();
		PageInfo<ArticleVO> data=articleService.getByKeyAll(key, index, length);
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
	 * 查询同作者文章，全部
	 * @param index 第几页
	 * @param length 页面长度
	 * @param authorid 作者id
	 * @return 成功则返回 ResponseResult<PageInfo<Article>> state：1，message：查询成功 data：文章分页信息
	 */
	@GetMapping("/getpagebyauthorall")
	public ResponseResult<PageInfo<ArticleVO>> getArticlePageByAuthorAll(int index,int length,Integer authorid){
		ResponseResult<PageInfo<ArticleVO>> result =new ResponseResult<PageInfo<ArticleVO>>();
		PageInfo<ArticleVO> data=articleService.getByAuthorAll(authorid, index, length);
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
