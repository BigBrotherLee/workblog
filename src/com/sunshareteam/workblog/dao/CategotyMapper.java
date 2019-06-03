package com.sunshareteam.workblog.dao;

import java.util.List;

import com.sunshareteam.workblog.entity.Article;
import com.sunshareteam.workblog.entity.Categoty;

public interface CategotyMapper {
	
	 Categoty findById(Integer id);
	 
	 void delete(Integer id);
	 
	 void insertCategoty(Categoty categoty);
	 
	 void updateCategoty(Categoty categoty);
	 
	 List<Categoty> findAll();
	 
	 List<Categoty> findCategotyByKey(String key);
	 
	 Categoty getCategotyByArticle(Integer articleId);
	 
	 void updateArticleCategity(Article article);
	 
	 void deleteArticleByCategoty(Integer categotyid);
}
