package isg3.data;

import isg3.article.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class JDBCCategoryDAO implements ICategoryDAO {

	private Connection conn;
	
	private IArticleDAO art_dao;
	
	public JDBCCategoryDAO(){
		conn = ConnectionManager.getInstance().checkOut();
		this.art_dao = new JDBCArticleDAO();
	}
	
	@Override
	public Category selectByName(String name) {
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
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (cat != null){
			Collection aux = this.art_dao.getAllArticles(cat_oid);
			cat.setArticles(aux);
		}
		
		return cat;
	}
	
	private String getOidFromCat(String name){
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
		
		
		return s;
	}
	
	@Override
	public Category selectByOID(String oid){
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
