package pos.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Detail")
public class Detail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6141988985020582697L;

	@Column(name="id")
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "note")
	private String note;

	@Column(name="quantity")
	private int quantity;

	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;
	
	@ManyToOne()
	@JoinColumn(name="orderId")
	private Order order;

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getTotal(){
		return product.getPrice() * quantity;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

}
