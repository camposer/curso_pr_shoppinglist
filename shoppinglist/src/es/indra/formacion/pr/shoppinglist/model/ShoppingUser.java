package es.indra.formacion.pr.shoppinglist.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SHOPPING_USER database table.
 * 
 */
@Entity
@Table(name="SHOPPING_USER")
@NamedQuery(name="ShoppingUser.findAll", query="SELECT s FROM ShoppingUser s")
public class ShoppingUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=20)
	private String login;

	@Column(nullable=false, length=8)
	private String password;

	//bi-directional many-to-one association to ShoppingItem
	@OneToMany(mappedBy="shoppingUser")
	private List<ShoppingItem> shoppingItems;

	public ShoppingUser() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ShoppingItem> getShoppingItems() {
		return this.shoppingItems;
	}

	public void setShoppingItems(List<ShoppingItem> shoppingItems) {
		this.shoppingItems = shoppingItems;
	}

	public ShoppingItem addShoppingItem(ShoppingItem shoppingItem) {
		getShoppingItems().add(shoppingItem);
		shoppingItem.setShoppingUser(this);

		return shoppingItem;
	}

	public ShoppingItem removeShoppingItem(ShoppingItem shoppingItem) {
		getShoppingItems().remove(shoppingItem);
		shoppingItem.setShoppingUser(null);

		return shoppingItem;
	}

}