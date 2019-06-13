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
import com.sunshareteam.workblog.entity.ArticleTag;
import com.sunshareteam.workblog.entity.Tag;
import com.sunshareteam.workblog.web.ArticleVO;

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
	public PageInfo<ArticleVO> getByKey(String key, int start, int size) {
		PageHelper.startPage(start, size);
		List<ArticleVO> list=articleMapper.findByKey("%"+key+"%");
		return new PageInfo<ArticleVO>(list);
	}

	@Override
	public PageInfo<ArticleVO> getHot(int start, int size) {
		PageHelper.startPage(start, size);
		List<ArticleVO> list=articleMapper.findHot();
		return new PageInfo<ArticleVO>(list);
	}

	@Override
	public PageInfo<ArticleVO> getNew(int start, int size) {
		PageHelper.startPage(start, size);
		List<ArticleVO> list=articleMapper.findNew();
		return new PageInfo<ArticleVO>(list);
	}

	@Override
	public PageInfo<ArticleVO> getByCategoty(Integer categotyid, int start, int size) {
		PageHelper.startPage(start, size);
		List<ArticleVO> list=articleMapper.findByCategoty(categotyid);
		return new PageInfo<ArticleVO>(list);
	}

	@Override
	public PageInfo<ArticleVO> getByAuthor(Integer userid, int start, int size) {
		PageHelper.startPage(start, size);
		List<ArticleVO> list=articleMapper.findByAuthor(userid);
		return new PageInfo<ArticleVO>(list);
	}

	@Override
	public PageInfo<ArticleVO> getByTag(Integer tagid, int start, int size) {
		PageHelper.startPage(start, size);
		List<ArticleVO> list=articleMapper.findByTag(tagid);
		return new PageInfo<ArticleVO>(list);
	}

	@Override
	public PageInfo<ArticleVO> getByKeyAll(String key, int start, int size) {
		PageHelper.startPage(start, size);
		List<ArticleVO> list=articleMapper.findByKeyAll("%"+key+"%");
		return new PageInfo<ArticleVO>(list);
	}

	@Override
	public PageInfo<ArticleVO> getByAuthorAll(Integer userid, int start, int size) {
		PageHelper.startPage(start, size);
		List<ArticleVO> list=articleMapper.findByAuthor(userid);
		return new PageInfo<ArticleVO>(list);
	}

	@Override
	@Transactional
	public void addTags(Integer articleid, String[] tags) {
		ArticleTag articleTag=new ArticleTag();
		articleTag.setArticleid(articleid);
		for(String tagname:tags) {
			Tag tag=articleMapper.findTagByName(tagname);
			if(tag==null) {
				tag=new Tag();
				tag.setCreatedate(new Date());
				tag.setTagtitle(tagname);
				articleMapper.insertTag(tag);
			}
			articleTag.setTagid(tag.getTagid());
			articleMapper.insertArticleTag(articleTag);
		}
	}

	@Override
	@Transactional
	public void removeTag(Integer articleid, Integer tagid) {
		ArticleTag articleTag=new ArticleTag();
		articleTag.setArticleid(articleid);
		articleTag.setTagid(tagid);
		articleMapper.deleteArtilceTag(articleTag);
	}
	
}
