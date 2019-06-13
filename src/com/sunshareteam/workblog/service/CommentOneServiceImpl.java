package com.sunshareteam.workblog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.dao.ArticleMapper;
import com.sunshareteam.workblog.dao.CommentOneMapper;
import com.sunshareteam.workblog.entity.Article;
import com.sunshareteam.workblog.entity.CommentOne;
import com.sunshareteam.workblog.entity.Commentnum;
import com.sunshareteam.workblog.entity.CommentnumAll;
import com.sunshareteam.workblog.web.CommentOneVO;

@Service("commentoneService")
public class CommentOneServiceImpl implements CommentOneService{
	@Autowired
	private CommentOneMapper commentoneMapper;
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public CommentOne getById(Integer id) {
		return commentoneMapper.findById(id);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		CommentOne commentone=commentoneMapper.findById(id);
		CommentnumAll commentnumall=commentoneMapper.findCount(id);
		Commentnum commentnum=commentoneMapper.findArticle(commentone.getArticleid());
    	Article article=new Article();
		article.setArticleid(commentone.getArticleid());
		article.setCommentnum(commentnum.getCommentnum()-(commentnumall.getCommentnumall()+1));
		articleMapper.updateArticle(article);
		commentoneMapper.delete(id);
		commentoneMapper.deleteCommentTwo(id);	//删除一级评论下的二级评论
	}

	@Override
	@Transactional
	public void insertCommentOne(CommentOne commentone) {
		commentone.setCreatedate(new Date());
		commentoneMapper.insertCommentOne(commentone);	
		Commentnum commentnum=commentoneMapper.findArticle(commentone.getArticleid());
		Article article=new Article();
		article.setArticleid(commentone.getArticleid());
		article.setCommentnum(commentnum.getCommentnum()+1);
		articleMapper.updateArticle(article);
	}
	
	@Override
	public PageInfo<CommentOneVO> getAll(int start, int size) {
		PageHelper.startPage(start, size);
		List<CommentOneVO> list=commentoneMapper.findAll();
		return new PageInfo<CommentOneVO>(list);
	}

	@Override
	public PageInfo<CommentOne> getByKey(String key, int start, int size) {
		PageHelper.startPage(start, size);
		List<CommentOne> list=commentoneMapper.findByKey("%"+key+"%");
		return new PageInfo<CommentOne>(list);
	}

	@Override
	public PageInfo<CommentOne> getByUser(Integer id, int start, int size){
		PageHelper.startPage(start, size);
		List<CommentOne> list=commentoneMapper.findByUser(id);
		return new PageInfo<CommentOne>(list);
	}

	@Override
	public PageInfo<CommentOneVO> getByArticleAll(Integer articleid, int start, int size) {
		PageHelper.startPage(start, size);
		List<CommentOneVO> list=commentoneMapper.findByArticleAll(articleid);
		return new PageInfo<CommentOneVO>(list);
	}

	@Override
	public PageInfo<CommentOne> getByUserAll(Integer userid, int start, int size) {
		PageHelper.startPage(start, size);
		List<CommentOne> list=commentoneMapper.findByUserAll(userid);
		return new PageInfo<CommentOne>(list);
	}
}
