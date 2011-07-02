package pos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import pos.domain.Order;
import pos.utils.UIDGenerator;

public class JDBCOrderDAO implements IOrderDAO {
    private Connection conn;

    ICreditCardDAO cdao;

    IDetailDAO ddao;

    IAddressDAO adao;

    public JDBCOrderDAO() {
        conn = ConnectionManager.getInstance().checkOut();
        cdao = new JDBCCreditCardDAO();
        ddao = new JDBCDetailDAO();
        adao = new JDBCAddressDAO();
    }

    protected void finalize() {
        ConnectionManager.getInstance().checkIn(conn);
    }

    public void delete(String OrderID) {

        String sql = "DELETE FROM Orders WHERE (orderid = ?) ";
        PreparedStatement stmt = null;

        String OrderOID = selectOIDOfOrder(OrderID);

        if (OrderOID!=null) {
        
        String AddressOID = selectOIDOfAddress(OrderOID);
        String CreditCardOID = selectOIDOfCreditCard(OrderOID);

        cdao.delete(conn, CreditCardOID);
        adao.delete(conn, AddressOID);
        ddao.delete(conn, OrderOID);

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, OrderID);
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
    }

    private String selectOIDOfCreditCard(String orderOID) {
        PreparedStatement stmt = null;
        ResultSet result = null;
        String oidCreditCard = null;
        String sql = "SELECT * FROM Orders WHERE (OID = ? ) ";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, orderOID);

            result = stmt.executeQuery();

            result.next();
            oidCreditCard = result.getString("creditcardOID");
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

        return oidCreditCard;
    }

    private String selectOIDOfAddress(String orderOID) {
        PreparedStatement stmt = null;
        ResultSet result = null;
        String oidAddress = null;
        String sql = "SELECT * FROM Orders WHERE (OID = ? ) ";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, orderOID);

            result = stmt.executeQuery();
            result.next();
            oidAddress = result.getString("ADDRESSOID");
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

        return oidAddress;
    }

    private String selectOIDOfOrder(String orderID) {
        PreparedStatement stmt = null;
        ResultSet result = null;
        String oid = null;
        String sql = "SELECT * FROM Orders WHERE (orderid = ?) ";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, orderID);
            result = stmt.executeQuery();

            if (result.next()) {
                oid = result.getString("OID");
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
        return oid;
    }

    public List selectAllOrders() {
        PreparedStatement stmt = null;
        ResultSet result = null;
        List lo = new LinkedList();
        String sql = "SELECT * FROM Orders";

        try {
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();

            while (result.next()) {
                Order o = new Order();
                String orderOid = result.getString("OID");
                o.setOrderID(result.getString("orderid"));
                o.setTimeplaced(new Date(result.getLong("timeplaced")));
                o.setPlacedbyCustomer(result.getString("placedbycustomer"));

                String oidc = result.getString("creditcardOID");
                String oida = result.getString("addressOID");

                //get CreditCard
                o.setPayment(cdao.select(conn, oidc));

                //get Address
                o.setDeliverto(adao.select(conn, oida));

                //get Details
                o.setDetails(ddao.select(conn, orderOid));

                lo.add(o);
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

        return lo;
    }

    public void insertOrder(Order o) {
        //insert credit card
        String oidc = UIDGenerator.getInstance().getKey();
        cdao.insert(conn, oidc, o.getPayment());

        //insert address
        String oida = UIDGenerator.getInstance().getKey();
        adao.insert(conn, oida, o.getDeliverto());

        //insert order
        String oido = UIDGenerator.getInstance().getKey();
        PreparedStatement stmt = null;
        String sql = "INSERT INTO Orders ( OID, addressOID, creditcardOID, orderid, timeplaced, placedbycustomer) VALUES (?, ?, ?, ?, ?, ?) ";
        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, oido);
            stmt.setString(2, oida);
            stmt.setString(3, oidc);
            stmt.setString(4, o.getOrderID());
            stmt.setLong(5, o.getTimeplaced().getTime());
            stmt.setString(6, o.getPlacedbyCustomer());

            stmt.executeUpdate();

            //insert details
            ddao.insert(conn, o.getDetails(), oido);

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

    public Order selectOldOrder() {
        String orderOid = null;
        Order o = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        String sql = "SELECT * FROM orders ORDER BY timeplaced ASC;";

        try {
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();

            if (result.next()) {
                orderOid = result.getString("OID");
                //get older order info
                o = new Order();
                String oidc = result.getString("creditcardOID");
                String oida = result.getString("addressOID");
                o.setOrderID(result.getString("orderid"));
                o.setTimeplaced(new Date(result.getLong("timeplaced")));
                o.setPlacedbyCustomer(result.getString("placedbycustomer"));

                //get CreditCard
                o.setPayment(cdao.select(conn, oidc));

                //get Address
                o.setDeliverto(adao.select(conn, oida));

                //get Details
                o.setDetails(ddao.select(conn, orderOid));

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

        return o;
    }
}
