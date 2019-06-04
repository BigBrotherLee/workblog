package com.sunshareteam.workblog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.dao.LinkMapper;
import com.sunshareteam.workblog.entity.Link;

public class LinkServiceImpl implements LinkService {
	@Autowired
	private LinkMapper linkMapper;
	
	@Override
	public Link getById(Integer id) {
		// TODO Auto-generated method stub
		return linkMapper.findById(id);
	}
	
	@Override
	@Transactional
	public void insertLink(Link link) {
		// TODO Auto-generated method stub
		link.setModifydate(new Date());
		linkMapper.insertLink(link);
	}

	@Override
	@Transactional
	public void updateLink(Link link) {
		// TODO Auto-generated method stub
		link.setModifydate(new Date());
		linkMapper.updateLink(link);
	}

	@Override
	@Transactional
	public void deleteLink(Integer id) {
		// TODO Auto-generated method stub
		linkMapper.deleteLink(id);
	}
	
	@Override
	public PageInfo<Link> getAll(int start, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<Link> getByKey(String key, int start, int size) {
		PageHelper.startPage(start, size);
		List<Link> list=linkMapper.findByKey("%"+key+"%");
		return new PageInfo<Link>(list);
	}



	

}
