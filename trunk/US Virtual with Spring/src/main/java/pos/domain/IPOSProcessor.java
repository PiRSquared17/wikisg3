package pos.domain;

import java.util.List;

public interface IPOSProcessor {
	boolean cancelOrder(String orderId);

	List listOrders();

	boolean placeOrder(Order o);

	Order retrieveOrder();
}
