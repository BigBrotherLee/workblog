package com.sunshareteam.workblog.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.dao.ArticleMapper;
import com.sunshareteam.workblog.dao.CommentTwoMapper;
import com.sunshareteam.workblog.entity.Article;
import com.sunshareteam.workblog.entity.CommentOne;
import com.sunshareteam.workblog.entity.CommentTwo;
import com.sunshareteam.workblog.entity.Commentnum;
import com.sunshareteam.workblog.web.CommentTwoVO;

@Service("commenttwoService")
public class CommentTwoServiceImpl implements CommentTwoService {
	@Autowired
	private CommentTwoMapper commenttwoMapper;
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public CommentTwo getById(Integer id) {
		// TODO Auto-generated method stub
		return commenttwoMapper.findById(id);
	}
	
	@Override
	@Transactional
	public void deleteCommentTwo(Integer id) {
		CommentTwo commenttwo=commenttwoMapper.findById(id);
		commenttwoMapper.deleteCommentTwo(id);	
		CommentOne commentone=commenttwoMapper.findArticleId(commenttwo.getOneid());
		Commentnum commentnum=commenttwoMapper.findArticle(commentone.getArticleid());
		Article article=new Article();
		article.setArticleid(commentone.getArticleid());
		article.setCommentnum(commentnum.getCommentnum()-1);
		articleMapper.updateArticle(article);
	}

	@Override
	@Transactional
	public void insertCommentTwo(CommentTwo commenttwo) {
		// TODO Auto-generated method stub
		commenttwo.setCreatedate(new Date());
		CommentOne commentone=commenttwoMapper.findArticleId(commenttwo.getOneid());
		Commentnum commentnum=commenttwoMapper.findArticle(commentone.getArticleid());
		commenttwoMapper.insertCommentTwo(commenttwo);
		Article article=new Article();
		article.setArticleid(commentone.getArticleid());
		article.setCommentnum(commentnum.getCommentnum()+1);
		articleMapper.updateArticle(article);
	}

	@Override
	public PageInfo<CommentTwoVO> getAll(int start, int size) {
		PageHelper.startPage(start, size);
		List<CommentTwoVO> list=commenttwoMapper.findAll();
		return new PageInfo<CommentTwoVO>(list);
	}

	@Override
	public PageInfo<CommentTwo> getByKey(String key, int start, int size) {
		PageHelper.startPage(start, size);
		List<CommentTwo> list=commenttwoMapper.findByKey("%"+key+"%");
		return new PageInfo<CommentTwo>(list);
	}

	@Override
	public PageInfo<CommentTwo> getByUser(Integer id,int start,int size) {
		PageHelper.startPage(start, size);
		List<CommentTwo> list=commenttwoMapper.findByUser(id);
		return new PageInfo<CommentTwo>(list);
	}

	@Override
	public PageInfo<CommentTwoVO> getByOneAll(Integer oneid, int start, int size) {
		PageHelper.startPage(start, size);
		List<CommentTwoVO> list=commenttwoMapper.findByOneAll(oneid);
		return new PageInfo<CommentTwoVO>(list);
	}
}
