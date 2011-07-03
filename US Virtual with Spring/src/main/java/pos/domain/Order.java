package pos.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4964953205365386152L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="addressId")
	private Address deliverto;
	
	@OneToOne
	@JoinColumn(name="cardId")
	private CreditCard payment;
	
	@Column(name="timeplaced")
	private Long timeplaced;
	
	@OneToMany(mappedBy = "order")
	private List<Detail> details;
	
	@Column(name="placedbycustomer")
	private String placedbyCustomer;

	public Address getDeliverto() {
		return this.deliverto;
	}
	public void setDeliverto(Address deliverto) {
		this.deliverto = deliverto;
	}
	public List<Detail> getDetails() {
		return this.details;
	}
	public void setDetails(List<Detail> details) {
		this.details = details;
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Long getTimeplaced() {
		return this.timeplaced;
	}
	public void setTimeplaced(Long timeplaced) {
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
					d.setOrder(this);
					found = true;
				}
			}
		}
		if (!found) {
			detail.setOrder(this);
			details.add(detail);
		}
	}

	public void removeDetail(Integer pid) {
		if (details != null) {
			boolean found = false;
			Iterator iter = details.iterator();
			while (iter.hasNext() && !found) {
				Detail d = (Detail) iter.next();
				if (d.getProduct().getId().equals(pid)) {
					if (d.getQuantity() > 1){
						d.setQuantity(d.getQuantity() - 1);
					}
					else{
						details.remove(d);
						d.setOrder(null);
					}
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
