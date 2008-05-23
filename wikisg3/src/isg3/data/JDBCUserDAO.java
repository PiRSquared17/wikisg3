package isg3.data;

import isg3.user.User;

import java.sql.Connection;
import java.util.Collection;

public class JDBCUserDAO implements IUserDAO {
	
	private Connection con;
	
	private IArticleDAO art_dao;
	
	private IMessageDAO ms_dao;
	
	@Override
	public boolean delete(String nick) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User select(String nick) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection selectAllArticles(String nick) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

}
