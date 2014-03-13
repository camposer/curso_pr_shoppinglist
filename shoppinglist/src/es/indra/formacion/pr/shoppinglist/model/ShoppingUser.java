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
	private Integer id;

	private String login;

	private String password;

	//bi-directional many-to-one association to ShoppingList
	@OneToMany(mappedBy="shoppingUser")
	private List<ShoppingList> shoppingLists;

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

	public List<ShoppingList> getShoppingLists() {
		return this.shoppingLists;
	}

	public void setShoppingLists(List<ShoppingList> shoppingLists) {
		this.shoppingLists = shoppingLists;
	}

	public ShoppingList addShoppingList(ShoppingList shoppingList) {
		getShoppingLists().add(shoppingList);
		shoppingList.setShoppingUser(this);

		return shoppingList;
	}

	public ShoppingList removeShoppingList(ShoppingList shoppingList) {
		getShoppingLists().remove(shoppingList);
		shoppingList.setShoppingUser(null);

		return shoppingList;
	}

}