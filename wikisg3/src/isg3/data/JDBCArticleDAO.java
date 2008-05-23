package isg3.data;

import isg3.article.*;
import isg3.user.*;
import isg3.utils.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;



public class JDBCArticleDAO implements IArticleDAO {

	private Connection con;
	
	private ICategoryDAO cat_dao;
	
	private IUserDAO user_dao;
	
	private IRateDAO rate_dao;
	
	public JDBCArticleDAO(){
		con = ConnectionManager.getInstance().checkOut();
		this.cat_dao = new JDBCCategoryDAO();
		this.user_dao = new JDBCUserDAO();
		this.rate_dao = new JDBCRateDAO();
	}
	
	@Override
	public boolean insert(Article a) {
		boolean b = false;
		
		String cat_oid = this.getOidOfCategory(a.getCat().getName());
		String art_oid = UIDGenerator.getInstance().getKey();
		PreparedStatement stmt = null;
		String query = "INSERT INTO Article(oid, title, content, lastRevision, visits, categoryOID) VALUES(?, ?, ?, ?, ?, ?)";
		try {
			stmt = this.con.prepareStatement(query);
			stmt.setString(1, art_oid);
			stmt.setString(2, a.getTitle());
			stmt.setString(3, a.getContent());
			stmt.setString(4, "NOW()");//funcion de mysql para la fecha actual
			stmt.setInt(5, 0);
			stmt.setString(6, cat_oid);
			int aux = stmt.executeUpdate();
			b = (aux == 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } 
            catch (SQLException e) {
            }
        }
		
		return b;
	}

	private String getOidOfCategory(String name){
		String s = null;
		
		ResultSet results = null;
		PreparedStatement stmt = null;
		String query = "SELECT oid FROM Category WHERE (name = ?)";
		try {
			stmt = this.con.prepareStatement(query);
			stmt.setString(1, name);
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
	public boolean remove(String title) {
		boolean b = false;
		
		PreparedStatement stmt = null;
		String query = "DELETE FROM Articulo WHERE (title = ?)";
		try {
			stmt = this.con.prepareStatement(query);
			stmt.setString(1,title);
			int aux = stmt.executeUpdate();
			b = (aux >= 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } 
            catch (SQLException e) {
            }
        }
		String art_oid = this.getOidOfArticle(title);
		this.rate_dao.removeAll(art_oid);
		
		return b;
	}

	
	@Override
	public Article select(String title) {
		Article art = null;
		String cat_oid = null;
		String art_oid = null;
		
		ResultSet s1 = null;
		PreparedStatement stmt = null;
		String query = "SELECT * FROM Article WHERE (title = ?)";
		try {
			stmt = this.con.prepareStatement(query);
			stmt.setString(1, title);
			s1 = stmt.executeQuery();
			if (s1.next()){
				art = new Article();
				art_oid = s1.getString("oid");
				art.setTitle(s1.getString("title"));
				art.setContent(s1.getString("content"));
				art.setVisits(s1.getInt("visits"));
				art.setLastRevision(s1.getDate("lastRevision"));
				cat_oid = s1.getString("categoryOID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Category cat = this.cat_dao.selectByOID(cat_oid);
		Collection editors = this.user_dao.selectAllEditors(art_oid);
		Collection c1 = this.rate_dao.selectAll(art_oid);
		RatesCollection rates = new RatesCollection();
		rates.setRates(c1);
		
		art.setCat(cat);
		art.setUSersEditors(editors);
		art.setRatesCollection(rates);
		
		return art;
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
