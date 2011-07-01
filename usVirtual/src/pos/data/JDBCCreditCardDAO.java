package pos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pos.domain.CreditCard;

public class JDBCCreditCardDAO implements ICreditCardDAO {

    public void delete(Connection conn, String creditCardOID) {
        String sql = "DELETE FROM CreditCard WHERE (OID = ?) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, creditCardOID);
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

    public void insert(Connection conn, String creditCardOID, CreditCard c) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO CreditCard ( OID, holder, number, month, year) VALUES (?, ?, ?, ?, ?) ";

        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, creditCardOID);
            stmt.setString(2, c.getHolder());
            stmt.setString(3, c.getNumber());
            stmt.setInt(4, c.getMonth());
            stmt.setInt(5, c.getYear());

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

    public CreditCard select(Connection conn, String creditCardOID) {
        String sql = "SELECT * FROM CreditCard WHERE (OID = ? ) ";
        PreparedStatement stmt = null;
        ResultSet result = null;
        CreditCard c = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, creditCardOID);

            result = stmt.executeQuery();

            result.next();
            c = new CreditCard();
            c.setHolder(result.getString("holder"));
            c.setNumber(result.getString("number"));
            c.setMonth(result.getInt("month"));
            c.setYear(result.getInt("year"));

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
        return c;
    }

}

