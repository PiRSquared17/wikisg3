package pos.data;

import java.sql.Connection;

import pos.domain.CreditCard;

public interface ICreditCardDAO {
    void delete(Connection conn, String creditCardOID);
    void insert(Connection conn, String creditCardOID, CreditCard c);
    CreditCard select(Connection conn, String creditCardOID);    
}
