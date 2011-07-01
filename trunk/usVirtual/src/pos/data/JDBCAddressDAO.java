package pos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pos.domain.Address;

public class JDBCAddressDAO implements IAddressDAO {

    public void delete(Connection conn, String addressOID) {
        String sql = "DELETE FROM Address WHERE (OID = ?) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, addressOID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Message: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("ErrorCode: " + e.getErrorCode());
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
            }
        }
    }

    public void insert(Connection conn, String addressOID, Address a) {
        String sql = "INSERT INTO Address ( OID, name, street, city, zipcode, email, phone, fax) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, addressOID);
            stmt.setString(2, a.getName());
            stmt.setString(3, a.getStreet());
            stmt.setString(4, a.getCity());
            stmt.setInt(5, a.getZipcode());
            stmt.setString(6, a.getEmail());
            stmt.setString(7, a.getPhone());
            stmt.setString(8, a.getFax());

            stmt.executeUpdate();

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

    public Address select(Connection conn, String addressOID) {
        String sql = "SELECT * FROM Address WHERE (OID = ? ) ";
        PreparedStatement stmt = null;
        ResultSet result = null;
        Address a = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, addressOID);

            result = stmt.executeQuery();

            result.next();
            a = new Address();
            a.setName(result.getString("name"));
            a.setStreet(result.getString("street"));
            a.setCity(result.getString("city"));
            a.setZipcode(result.getInt("zipcode"));
            a.setEmail(result.getString("email"));
            a.setPhone(result.getString("phone"));
            a.setFax(result.getString("fax"));
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

        return a;
    }
}
