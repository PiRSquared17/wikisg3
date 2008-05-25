package isg3.data;

import isg3.article.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class JDBCCategoryDAO implements ICategoryDAO {

	private Connection conn;
	
	private IArticleDAO art_dao;
	
	public JDBCCategoryDAO(Connection c){
		this.conn = c;
		this.art_dao = new JDBCArticleDAO(c);
	}
	
	public JDBCCategoryDAO(){
		conn = ConnectionManager.getInstance().checkOut();
		this.art_dao = new JDBCArticleDAO(conn);
	}
	
	public void finalize(){
		ConnectionManager.getInstance().checkIn(conn);
	}
	
	@Override
	public Category selectByName(String name) {
		//conn = ConnectionManager.getInstance().checkOut();
		// TODO Auto-generated method stub
		Category cat = null;
		String cat_oid = this.getOidFromCat(name);
		
		ResultSet s1 = null;
		PreparedStatement stmt = null;
		String query = "SELECT * FROM Category WHERE (name = ?)";
		try {
			stmt = this.conn.prepareStatement(query);
			stmt.setString(1, name);
			s1 = stmt.executeQuery();
			if (s1.next()){
				cat = new Category();
				cat.setName(s1.getString("name"));
				cat.setDescription(s1.getString("description"));
				Collection articles = this.art_dao.selectAllArticles(cat);
				cat.setArticles(articles);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//ConnectionManager.getInstance().checkIn(conn);
		}
		
		if (cat != null){
			//Collection aux = this.art_dao.getAllArticles(cat_oid);
			//cat.setArticles(aux);
		}
		
		return cat;
	}
	
	private String getOidFromCat(String name){
		//conn = ConnectionManager.getInstance().checkOut();
		String s = null;
		
		ResultSet s1 = null;
		PreparedStatement stmt = null;
		String query = "SELECT oid FROM Category WHERE (name = ?)";
		try {
			stmt = this.conn.prepareStatement(query);
			stmt.setString(1, name);
			s1 = stmt.executeQuery();
			if (s1.next()){
				s = s1.getString("oid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//ConnectionManager.getInstance().checkIn(conn);
		}
		return s;
	}
	
	@Override
	public Category selectByOID(String oid){
		//conn = ConnectionManager.getInstance().checkOut();
		Category cat = null;
		
		ResultSet res = null;
		PreparedStatement stmt = null;
		String query = "SELECT * FROM Category WHERE (oid = ?)";
		try {
			stmt = this.conn.prepareStatement(query);
			stmt.setString(1, oid);
			res = stmt.executeQuery();
			if (res.next()){
				cat = new Category();
				cat.setName(res.getString("name"));
				cat.setDescription(res.getString("description"));
				Collection articles = this.art_dao.selectAllArticles(cat);
				cat.setArticles(articles);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//ConnectionManager.getInstance().checkIn(conn);
		}
		return cat;
	}

	@Override
	public Collection selectAll() {
		// TODO Auto-generated method stub
		//conn = ConnectionManager.getInstance().checkOut();
		Collection c = null;
		
		ResultSet result = null;
		PreparedStatement stmt = null;
		String query = "SELECT * FROM Category";
		try {
			stmt = this.conn.prepareStatement(query);
			result = stmt.executeQuery();
			c = new LinkedList();
			while (result.next()){
				Category cat = this.selectByOID(result.getString("oid"));
				c.add(cat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//ConnectionManager.getInstance().checkIn(conn);
		}
		
		
		return c;
	}

	

}
