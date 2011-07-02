package pos.data;

import java.sql.Connection;
import java.util.List;

public interface IDetailDAO {
    void delete(Connection conn, String orderOID);
    void insert(Connection conn, List details, String orderOID);
    List select(Connection conn, String orderOID);
}
