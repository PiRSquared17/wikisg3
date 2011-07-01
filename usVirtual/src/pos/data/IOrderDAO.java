package pos.data;

import java.util.List;

import pos.domain.Order;

public interface IOrderDAO {
    void delete(String OrderID);
    List selectAllOrders();
    void insertOrder(Order o);
    Order selectOldOrder();
}
