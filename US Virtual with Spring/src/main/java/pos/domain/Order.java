package pos.domain;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Order {
	private String orderID;
	private Address deliverto;
	private CreditCard payment;
	private Date timeplaced;
	private List details;
	private String placedbyCustomer;

	public Address getDeliverto() {
		return this.deliverto;
	}
	public void setDeliverto(Address deliverto) {
		this.deliverto = deliverto;
	}
	public List getDetails() {
		return this.details;
	}
	public void setDetails(List details) {
		this.details = details;
	}
	public String getOrderID() {
		return this.orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public CreditCard getPayment() {
		return this.payment;
	}
	public void setPayment(CreditCard payment) {
		this.payment = payment;
	}
	public String getPlacedbyCustomer() {
		return this.placedbyCustomer;
	}
	public void setPlacedbyCustomer(String placedbyCustomer) {
		this.placedbyCustomer = placedbyCustomer;
	}
	public Date getTimeplaced() {
		return this.timeplaced;
	}
	public void setTimeplaced(Date timeplaced) {
		this.timeplaced = timeplaced;
	}
	public void addDetail(Detail detail) {
		boolean found = false;

		if (details == null) {
			details = new LinkedList();
		} else {
			for (Iterator iter = details.iterator(); iter.hasNext();) {
				Detail d = (Detail) iter.next();
				if (d.getProduct().getId().equals(
						detail.getProduct().getId())) {
					d.setQuantity(d.getQuantity() + detail.getQuantity());
					d.setNote(d.getNote() + detail.getNote());
					found = true;
				}
			}
		}
		if (!found) {
			details.add(detail);
		}
	}

	public void removeDetail(String pid) {
		if (details != null) {
			boolean found = false;
			Iterator iter = details.iterator();
			while (iter.hasNext() && !found) {
				Detail d = (Detail) iter.next();
				if (d.getProduct().getId().equals(pid)) {
					details.remove(d);
					found = true;
				}
			}
		}
	}
	
	public int getTotal(){
		int res = 0;
		for (Detail d:(List<Detail>)details){
			res += d.getTotal();
		}
		return res;
	}
}
