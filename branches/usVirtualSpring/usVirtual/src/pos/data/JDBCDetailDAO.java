package pos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import pos.domain.Detail;
import pos.domain.Product;
import pos.utils.UIDGenerator;

public class JDBCDetailDAO implements IDetailDAO {
    IProductDAO pdao;
    
    public JDBCDetailDAO() {
        pdao = new JDBCProductDAO();
    }

    public void delete(Connection conn, String orderOID) {
        String sql = "DELETE FROM Detail WHERE (OrderOID = ?) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, orderOID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
            }
        }
    }

    public void insert(Connection conn, List details, String orderOID) {

        String sql = "INSERT INTO Detail ( OID, orderOID, productOID, note, quantity) VALUES (?, ?, ?, ?, ?) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            
            for (Iterator it = details.iterator(); it.hasNext();) {
                Detail d = (Detail) it.next();
                stmt.clearParameters();
                stmt.setString(1, UIDGenerator.getInstance().getKey());
                stmt.setString(2, orderOID);
                String oidp = pdao.selectProductOID(conn,d.getProduct().getProductID());
                stmt.setString(3, oidp);
                stmt.setString(4, d.getNote());
                stmt.setInt(5, d.getQuantity());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    public List select(Connection conn, String orderOID) {
        List details = new LinkedList();
        String sql = "SELECT * FROM Detail WHERE (ORDEROID = ? ) ";
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, orderOID);

            result = stmt.executeQuery();

            while (result.next()) {
                Detail d = new Detail();
                d.setQuantity(result.getInt("quantity"));
                d.setNote(result.getString("note"));
                Product p = pdao.select(conn, result.getString("productOID"));
                d.setProduct(p);
                details.add(d);
            }
        } catch (SQLException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
        } finally {
            try {
                if (result != null) {
                    result.close();
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
            }
        }

        return details;
    }

    }


