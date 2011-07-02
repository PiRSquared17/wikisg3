package pos.domain;

import java.util.List;

import pos.data.IOrderDAO;
import pos.data.JDBCOrderDAO;

public class POSProcessor implements IPOSProcessor {
    private IOrderDAO odao = new JDBCOrderDAO();

    public boolean cancelOrder(String OrderId) {
        odao.delete(OrderId);
        return true;
    }

    public List listOrders() {
        return odao.selectAllOrders();
    }

    public boolean placeOrder(Order o) {
        odao.insertOrder(o);
        return true;
    }

    public Order retrieveOrder() {
        Order o = odao.selectOldOrder();
        if (o!= null) {
            odao.delete(o.getOrderID());
        }
	        return o;
    }
}