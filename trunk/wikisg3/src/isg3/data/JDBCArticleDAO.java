package isg3.data;

import isg3.article.Article;

import java.sql.Connection;
import java.util.Collection;

public class JDBCArticleDAO implements IArticleDAO {

	private Connection con;
	
	private ICategoryDAO cat_dao;
	
	private IUserDAO user_dao;
	
	private IRateDAO rate_dao;
	
	@Override
	public boolean insert(Article a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(String title) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Article select(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection selectMostRatedArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Article a) {
		// TODO Auto-generated method stub
		return false;
	}

}