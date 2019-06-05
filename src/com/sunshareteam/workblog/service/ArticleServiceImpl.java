package com.sunshareteam.workblog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.dao.ArticleMapper;
import com.sunshareteam.workblog.entity.Article;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public Article getById(Integer id) {
		return articleMapper.findById(id);
	}

	@Override
	@Transactional
	public void updateArticle(Article article) {
		article.setModifydate(new Date());
		articleMapper.updateArticle(article);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		articleMapper.deleteCommentTwo(id);
		articleMapper.deleteCommentOne(id);
		articleMapper.deleteTag(id);
		articleMapper.deleteArticle(id);
	}

	@Override
	@Transactional
	public void insertArticle(Article article) {
		article.setCreatedate(new Date());
		article.setState(false);
		article.setCommentnum(0);
		articleMapper.insertArticle(article);
	}

	@Override
	public PageInfo<Article> getByKey(String key, int start, int size) {
		PageHelper.startPage(start, size);
		List<Article> list=articleMapper.findByKey("%"+key+"%");
		return new PageInfo<Article>(list);
	}

	@Override
	public PageInfo<Article> getHot(int start, int size) {
		PageHelper.startPage(start, size);
		List<Article> list=articleMapper.findHot();
		return new PageInfo<Article>(list);
	}

	@Override
	public PageInfo<Article> getNew(int start, int size) {
		PageHelper.startPage(start, size);
		List<Article> list=articleMapper.findNew();
		return new PageInfo<Article>(list);
	}

	@Override
	public PageInfo<Article> getByCategoty(Integer categotyid, int start, int size) {
		PageHelper.startPage(start, size);
		List<Article> list=articleMapper.findByCategoty(categotyid);
		return new PageInfo<Article>(list);
	}

	@Override
	public PageInfo<Article> getByAuthor(Integer userid, int start, int size) {
		PageHelper.startPage(start, size);
		List<Article> list=articleMapper.findByAuthor(userid);
		return new PageInfo<Article>(list);
	}

	@Override
	public PageInfo<Article> getByTag(Integer tagid, int start, int size) {
		PageHelper.startPage(start, size);
		List<Article> list=articleMapper.findByTag(tagid);
		return new PageInfo<Article>(list);
	}

	@Override
	public PageInfo<Article> getByKeyAll(String key, int start, int size) {
		PageHelper.startPage(start, size);
		List<Article> list=articleMapper.findByKeyAll("%"+key+"%");
		return new PageInfo<Article>(list);
	}

	@Override
	public PageInfo<Article> getByAuthorAll(Integer userid, int start, int size) {
		PageHelper.startPage(start, size);
		List<Article> list=articleMapper.findByAuthor(userid);
		return new PageInfo<Article>(list);
	}
	
}
