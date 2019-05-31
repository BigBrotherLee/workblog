package com.sunshareteam.workblog.web;

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
	@GetMapping("/get/{id}")
	public ResponseResult<Article> get(@PathVariable int id) {
		ResponseResult<Article> result=new ResponseResult<Article>();
		return result;
	}
	
	/**
	 * 删除文章
	 * @param id 要删除的文章id
	 * @return 成功则返回 ResponseResult<String> state：1，，message：删除成功  
	 */
	@RequiresPermissions("article:delete:*")
	@DeleteMapping("/delete/{id}")
	public ResponseResult<String> delete(@PathVariable int id) {
		ResponseResult<String> result=new ResponseResult<String>();
		SecurityUtils.getSubject().checkPermission("artilce:dalete:"+id);//作者删除
		return result;
	}
	
	/**
	 * 创建文章
	 * @param article 你要创建的文章
	 * @return 成功则返回 ResponseResult<Article> state：1，，message：创建成功 data：文章详情 
	 */
	@RequiresPermissions("article:insert:*")
	@PostMapping("/add")
	public ResponseResult<Article> addArticle(Article article){
		ResponseResult<Article> result=new ResponseResult<Article>();
		return result;
	}
	
	
	/**
	 * 修改文章
	 * @param article 修改后的文章信息
	 * @return 成功则返回 ResponseResult<Article> state：1，，message：修改成功 data：文章详情 
	 */
	@RequiresPermissions("article:upadte:*")
	@PutMapping("/update")
	public ResponseResult<Article> updateArticle(Article article){
		ResponseResult<Article> result=new ResponseResult<Article>();
		SecurityUtils.getSubject().checkPermission("artilce:update:"+article.getArticleid());//作者修改
		
		return result;
	}
	
	/**
	 * 根据关键字查询文章
	 * @param index 第几页
	 * @param length 页面长度
	 * @param key 关键字
	 * @return 成功则返回 ResponseResult<PageInfo<Article>> state：1，message：查询成功 data：文章分页信息
	 */
	@GetMapping("/getpage/{index}/{length}")
	public ResponseResult<PageInfo<Article>> getArticlePage(@PathVariable int index,@PathVariable int length,String key){
		ResponseResult<PageInfo<Article>> result =new ResponseResult<PageInfo<Article>>();
		
		return result;
	}
	
	/**
	 * 查询同作者文章
	 * @param index 第几页
	 * @param length 页面长度
	 * @param authorid 作者id
	 * @return 成功则返回 ResponseResult<PageInfo<Article>> state：1，message：查询成功 data：文章分页信息
	 */
	@GetMapping("/getpagebyarthor/{index}/{length}")
	public ResponseResult<PageInfo<Article>> getArticlePageByAuthor(@PathVariable int index,@PathVariable int length,Integer authorid){
		ResponseResult<PageInfo<Article>> result =new ResponseResult<PageInfo<Article>>();
		
		return result;
	}
	
	/**
	 * 查询同标签文章
	 * @param index 第几页
	 * @param length 页面长度
	 * @param tagid 标签id
	 * @return 成功则返回 ResponseResult<PageInfo<Article>> state：1，message：查询成功 data：文章分页信息
	 */
	@GetMapping("/getpagebytag/{index}/{length}")
	public ResponseResult<PageInfo<Article>> getArticlePageByTag(@PathVariable int index,@PathVariable int length,Integer tagid){
		ResponseResult<PageInfo<Article>> result =new ResponseResult<PageInfo<Article>>();
		
		return result;
	}
	
	/**
	 * 查询同分类文章
	 * @param index 第几页
	 * @param length 页面长度
	 * @param categoryid 分类id
	 * @return 成功则返回 ResponseResult<PageInfo<Article>> state：1，message：查询成功 data：文章分页信息
	 */
	@GetMapping("/getpagebycategory/{index}/{length}")
	public ResponseResult<PageInfo<Article>> getArticlePageByCategory(@PathVariable int index,@PathVariable int length,Integer categoryid){
		ResponseResult<PageInfo<Article>> result =new ResponseResult<PageInfo<Article>>();
		
		return result;
	}
	
	/**
	 * 查询最新文章
	 * @param index 第几页
	 * @param length 页面长度
	 * @return 成功则返回 ResponseResult<PageInfo<Article>> state：1，message：查询成功 data：文章分页信息
	 */
	@GetMapping("/getnew/{index}/{length}")
	public ResponseResult<PageInfo<Article>> getNew(@PathVariable int index,@PathVariable int length){
		ResponseResult<PageInfo<Article>> result =new ResponseResult<PageInfo<Article>>();
		
		return result;
	}
	
	/**
	 * 查询最热文章
	 * @param index 第几页
	 * @param length 页面长度
	 * @return 成功则返回 ResponseResult<PageInfo<Article>> state：1，message：查询成功 data：文章分页信息
	 */
	@GetMapping("/gethot/{index}/{length}")
	public ResponseResult<PageInfo<Article>> getHot(@PathVariable int index,@PathVariable int length){
		ResponseResult<PageInfo<Article>> result =new ResponseResult<PageInfo<Article>>();
		
		return result;
	}
	
	
}
