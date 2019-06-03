package com.sunshareteam.workblog.service;

import com.github.pagehelper.PageInfo;
import com.sunshareteam.workblog.entity.Categoty;

public interface CategotyService {
	Categoty getById(Integer id);
	void deleteCategoty(Integer id);
	void insertCategoty(Categoty categoty);
	void updateGategoty(Categoty categoty);
	PageInfo<Categoty> getAll(int start,int size);
	PageInfo<Categoty> getByKey(String key,int start,int size);
	Categoty getByArticle(Integer articleid);
	void changeCategoty(Integer categotyid,Integer articleid);
}
