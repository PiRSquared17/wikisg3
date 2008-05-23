package isg3.data;

import isg3.article.Rate;

import java.sql.Connection;
import java.util.Collection;

public class JDBCRateDAO implements IRateDAO {

	private Connection con;
	
	private IArticleDAO art_dao;
	
	private IUserDAO user_dao;
	
	public JDBCRateDAO(){
		con = ConnectionManager.getInstance().checkOut();
		this.art_dao = new JDBCArticleDAO();
		this.user_dao = new JDBCUserDAO();
	}
	
	@Override
	public boolean insert(Rate r, String articleOID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Rate select(String articleOID, String userOID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection selectAll(String articleOID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Rate r, String articleOID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(String articleOID) {
		// TODO Auto-generated method stub
		return false;
	}

}
