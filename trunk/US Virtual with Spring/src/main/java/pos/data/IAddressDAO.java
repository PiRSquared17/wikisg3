package pos.data;

import java.sql.Connection;

import pos.domain.Address;

public interface IAddressDAO {
    void delete(Connection conn, String addressOID);
    void insert(Connection conn, String addressOID, Address a);
    Address select(Connection conn, String addressOID);    
}
