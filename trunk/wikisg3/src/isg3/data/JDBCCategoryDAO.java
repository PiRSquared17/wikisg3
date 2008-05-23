package isg3.data;

import isg3.article.Category;

import java.sql.Connection;
import java.util.Collection;

public class JDBCCategoryDAO implements ICategoryDAO {

	private Connection conn;
	
	private IArticleDAO art_dao;
	
	@Override
	public Category select(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection selectAllArticles(String catName) {
		// TODO Auto-generated method stub
		return null;
	}

}
