package isg3.data;

import isg3.user.*;
import isg3.utils.UIDGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class JDBCUserDAO implements IUserDAO {
	
	private Connection con;
	
	private IArticleDAO art_dao;
	
	private IMessageDAO ms_dao;
	
	public JDBCUserDAO(){
		con = ConnectionManager.getInstance().checkOut();
		//this.art_dao = new JDBCArticleDAO();
		//this.ms_dao = new JDBCMessageDAO();
	}
	
	@Override
	public boolean delete(String nick) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(User u) {
		// TODO Auto-generated method stub
		boolean b = false;
		
		String oid = UIDGenerator.getInstance().getKey();
		PreparedStatement stmt = null;
		String query = "INSERT INTO User(oid,nick,pass,mail,registeredDate) VALUES(?,?,?,?,NOW())";
		try {
			stmt = this.con.prepareStatement(query);
			stmt.setString(1, oid);
			stmt.setString(2, u.getNick());
			stmt.setString(3, u.getPass());
			stmt.setString(4, u.getProfile().getMail());
			int aux = stmt.executeUpdate();
			b = (aux == 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return b;
	}

	@Override
	public User select(String nick) {
		// TODO Auto-generated method stub
		User u = null;
		
		ResultSet res = null;
		PreparedStatement stmt = null;
		String query = "SELECT * FROM User WHERE (nick = ?)";
		try {
			stmt = this.con.prepareStatement(query);
			stmt.setString(1, nick);
			res = stmt.executeQuery();
			if (res.next()){
				u = new User();
				UserProfile up = new UserProfile();
				u.setNick(nick);
				u.setPass(res.getString("pass"));
				up.setMail(res.getString("mail"));
				u.setProfile(up);
				//FALTA LA FECHA
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
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

	@Override
	public Collection selectAllEditors(String art_oid) {
		// TODO Auto-generated method stub
		return null;
	}

}
