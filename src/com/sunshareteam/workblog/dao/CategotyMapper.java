package com.sunshareteam.workblog.dao;

import com.sunshareteam.workblog.entity.Categoty;

public interface CategotyMapper {
	   Categoty findCategotyId(int categoty); //根据ID查询
	   void addCategoty(Categoty categoty);
	   void updateCategoty(Categoty categoty);
	   void deleteCategoty(int id);
}
