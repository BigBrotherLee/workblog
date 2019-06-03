package com.sunshareteam.workblog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.dao.CategotyMapper;
import com.sunshareteam.workblog.entity.Article;
import com.sunshareteam.workblog.entity.Categoty;

@Service("categotyService")
public class CategotyServiceImpl implements CategotyService {
	@Autowired
	private CategotyMapper categotyMapper;

	@Override
	public Categoty getById(Integer id) {
		return categotyMapper.findById(id);
	}

	@Override
	@Transactional
	public void deleteCategoty(Integer id) {
		categotyMapper.delete(id);
		categotyMapper.deleteArticleByCategoty(id);//删除该分类下的文章
	}

	@Override
	@Transactional
	public void insertCategoty(Categoty categoty) {
		categoty.setCreatedate(new Date());
		categotyMapper.insertCategoty(categoty);
	}

	@Override
	@Transactional
	public void updateGategoty(Categoty categoty) {
		categoty.setModifydate(new Date());
		categotyMapper.updateCategoty(categoty);
	}

	@Override
	public PageInfo<Categoty> getAll(int start, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<Categoty> getByKey(String key, int start, int size) {
		PageHelper.startPage(start, size);
		List<Categoty> list=categotyMapper.findCategotyByKey("%"+key+"%");
		return new PageInfo<Categoty>(list);
	}

	@Override
	public Categoty getByArticle(Integer articleid) {
		return categotyMapper.getCategotyByArticle(articleid);
	}

	@Override
	@Transactional
	public void changeCategoty(Integer categotyid, Integer articleid) {
		Article  article=new Article();
		categotyMapper.updateArticleCategity(article);
	}
}
