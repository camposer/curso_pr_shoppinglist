package es.indra.formacion.pr.shoppinglist.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SHOPPING_ITEM database table.
 * 
 */
@Entity
@Table(name="SHOPPING_ITEM")
@NamedQuery(name="ShoppingItem.findAll", query="SELECT s FROM ShoppingItem s")
public class ShoppingItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=100)
	private String name;

	@Column(nullable=false)
	private Integer status;

	//bi-directional many-to-one association to ShoppingUser
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SHOPPING_USER_ID", nullable=false)
	private ShoppingUser shoppingUser;

	public ShoppingItem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public ShoppingUser getShoppingUser() {
		return this.shoppingUser;
	}

	public void setShoppingUser(ShoppingUser shoppingUser) {
		this.shoppingUser = shoppingUser;
	}

	@Override
	public String toString() {
		return "ShoppingItem [id=" + id + ", name=" + name + ", status="
				+ status + ", shoppingUser=" + shoppingUser + "]";
	}
	
	

}