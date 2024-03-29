package isg3.data;

import isg3.article.Rate;
import isg3.user.User;
import isg3.utils.UIDGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class JDBCRateDAO implements IRateDAO {

	private Connection con;
	
	private IArticleDAO art_dao;
	
	private IUserDAO user_dao;
	
	public JDBCRateDAO(){
		con = ConnectionManager.getInstance().checkOut();
		this.user_dao = new JDBCUserDAO(con);
	}
	
	public JDBCRateDAO(Connection c){
		con = c;
		this.user_dao = new JDBCUserDAO(con);
	}
	
	public void finalize(){
		ConnectionManager.getInstance().checkIn(con);
	}
	
	@Override
	public boolean insert(Rate r, String article) {
		// TODO Auto-generated method stub
		boolean b = false;
		
		String oid = UIDGenerator.getInstance().getKey();
		String art_oid = this.getOidOfArticle(article);
		String user_oid = this.getOidOfUser(r.getUser().getNick());
		PreparedStatement stmt = null;
		String query = "INSERT INTO Rate(oid, articleOID, userOID, rate, reason) VALUES(?, ?, ?, ?, ?)";
		try {
			stmt = this.con.prepareStatement(query);
			stmt.setString(1, oid);
			stmt.setString(2, art_oid);
			stmt.setString(3, user_oid);
			stmt.setInt(4, r.getRate());
			stmt.setString(5, r.getReason());
			int aux = stmt.executeUpdate();
			b = (aux == 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}

	private String getOidOfUser(String nick) {
		// TODO Auto-generated method stub
		String s = null;
		
		ResultSet results = null;
		PreparedStatement stmt = null;
		String query = "SELECT oid FROM User WHERE (nick = ?)";
		try {
			stmt = this.con.prepareStatement(query);
			stmt.setString(1, nick);
			results = stmt.executeQuery();
			if (results.next()){
				s = results.getString("oid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
            try {
                if (results != null) {
                    results.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            	}
            	catch (SQLException e) {
            	}
        }
		
		return s;
	}

	private String getOidOfArticle(String title){
		String s = null;
		
		ResultSet results = null;
		PreparedStatement stmt = null;
		String query = "SELECT oid FROM Article WHERE (title = ?)";
		try {
			stmt = this.con.prepareStatement(query);
			stmt.setString(1, title);
			results = stmt.executeQuery();
			if (results.next()){
				s = results.getString("oid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
            try {
                if (results != null) {
                    results.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            	}
            	catch (SQLException e) {
            	}
        }
		
		return s;
	}

	@Override
	public Rate select(String article, String user) {
		// TODO Auto-generated method stub
		Rate r = null;
		
		ResultSet res = null;
		String art_oid = this.getOidOfArticle(article);
		String user_oid = this.getOidOfUser(user);
		PreparedStatement stmt = null;
		String query = "SELECT rate,reason FROM Rate WHERE(articleOID = ? AND userOID = ? )";
		try {
			stmt = this.con.prepareStatement(query);
			stmt.setString(1, art_oid);
			stmt.setString(2, user_oid);
			res = stmt.executeQuery();
			if (res.next()){
				String reason = res.getString("reason");
				int rate = res.getInt("rate");
				User u = this.user_dao.select(user);
				r = new Rate();
				r.setRate(rate);
				r.setReason(reason);
				r.setUser(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}

	@Override
	public Collection selectAll(String article) {
		// TODO Auto-generated method stub
		Collection c = null;
		
		ResultSet res = null;
		String art_oid = this.getOidOfArticle(article);
		//String user_oid = this.getOidOfUser(user);
		PreparedStatement stmt = null;
		String query = "SELECT * FROM Rate WHERE(articleOID = ? )";
		try {
			stmt = this.con.prepareStatement(query);
			stmt.setString(1, art_oid);
			//stmt.setString(2, user_oid);
			res = stmt.executeQuery();
			c = new LinkedList();
			while (res.next()){
				String reason = res.getString("reason");
				int rate = res.getInt("rate");
				User u = this.user_dao.selectByOID(res.getString("userOID"));
				Rate r = new Rate();
				r.setRate(rate);
				r.setReason(reason);
				r.setUser(u);
				c.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	public Collection selectAllByOID(String articleOID){
		// TODO Auto-generated method stub
		Collection c = null;
		
		ResultSet res = null;
		//String art_oid = this.getOidOfArticle(article);
		//String user_oid = this.getOidOfUser(user);
		PreparedStatement stmt = null;
		String query = "SELECT * FROM Rate WHERE(articleOID = ? )";
		try {
			stmt = this.con.prepareStatement(query);
			stmt.setString(1, articleOID);
			//stmt.setString(2, user_oid);
			res = stmt.executeQuery();
			c = new LinkedList();
			while (res.next()){
				String reason = res.getString("reason");
				int rate = res.getInt("rate");
				User u = this.user_dao.selectByOID(res.getString("userOID"));
				Rate r = new Rate();
				r.setRate(rate);
				r.setReason(reason);
				r.setUser(u);
				c.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	@Override
	public boolean update(Rate r, String article) {
		// TODO Auto-generated method stub
		boolean b = false;
		
		String u_oid = this.getOidOfUser(r.getUser().getNick());
		String a_oid = this.getOidOfArticle(article);
		PreparedStatement stmt = null;
		String query = "UPDATE Rate SET reason = ?, rate = ? WHERE (articleOID = ? AND userOID = ?)";
		try {
			stmt = this.con.prepareStatement(query);
			stmt.setString(1, r.getReason());
			stmt.setInt(2, r.getRate());
			stmt.setString(3, a_oid);
			stmt.setString(4, u_oid);
			int aux = stmt.executeUpdate();
			b = (aux == 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public boolean removeAll(String article) {
		// TODO Auto-generated method stub
		return false;
	}

}
