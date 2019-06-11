package com.sunshareteam.workblog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.dao.TagMapper;
import com.sunshareteam.workblog.entity.ArticleTag;
import com.sunshareteam.workblog.entity.Tag;

@Service("tagService")
public class TagServiceImpl implements TagService {
	@Autowired
	private TagMapper tagMapper;

	@Override
	public Tag getById(Integer id) {
		// TODO Auto-generated method stub
		return tagMapper.findById(id);
	}
	
	@Override
	@Transactional
	public void insertTag(Tag tag) {
		// TODO Auto-generated method stub
		tag.setCreatedate(new Date());
		tagMapper.insertTag(tag);
	}

	@Override
	@Transactional	
	public void insertArticleTag(ArticleTag articletag) {
		// TODO Auto-generated method stub
		tagMapper.insertArticleTag(articletag);	
	}
	
	@Override
	@Transactional
	public void updateTag(Tag tag) {
		// TODO Auto-generated method stub
		tag.setModifydate(new Date());
		tagMapper.updateTag(tag);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		tagMapper.deleteTag(id);
		tagMapper.deleteArticleTag(id);
	}

	@Override
	public PageInfo<Tag> getAll(int start, int size) {
		PageHelper.startPage(start, size);
		List<Tag> list=tagMapper.findAll();
		return new PageInfo<Tag>(list);
	}

	@Override
	public PageInfo<Tag> getByKey(String key, int start, int size) {
		PageHelper.startPage(start, size);
		List<Tag> list=tagMapper.findByKey("%"+key+"%");
		return new PageInfo<Tag>(list);
	}

	@Override
	public PageInfo<Tag> getByArticle(Integer articleid,int start,int size) {
		PageHelper.startPage(start, size);
		List<Tag> list=tagMapper.findByArticle(articleid);
		return new PageInfo<Tag>(list);
	}
}
