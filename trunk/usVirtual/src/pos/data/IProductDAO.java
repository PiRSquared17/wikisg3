package pos.data;

import java.sql.Connection;
import java.util.List;

import pos.domain.Product;

public interface IProductDAO {
    List selectAllProducts();
    Product select(Connection conn, String productOID);
    String selectProductOID(Connection conn, String productid);
}
