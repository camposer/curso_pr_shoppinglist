package es.indra.formacion.pr.shoppinglist.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SHOPPING_LIST database table.
 * 
 */
@Entity
@Table(name="SHOPPING_LIST")
@NamedQuery(name="ShoppingList.findAll", query="SELECT s FROM ShoppingList s")
public class ShoppingList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String item;

	private Integer status;

	//bi-directional many-to-one association to ShoppingUser
	@ManyToOne
	@JoinColumn(name="SHOPPING_USER_ID")
	private ShoppingUser shoppingUser;

	public ShoppingList() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
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

}