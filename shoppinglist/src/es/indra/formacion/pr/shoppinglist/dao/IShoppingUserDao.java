package es.indra.formacion.pr.shoppinglist.dao;

import es.indra.formacion.pr.shoppinglist.model.ShoppingUser;

public interface IShoppingUserDao extends IDao<ShoppingUser, Integer> {
	public ShoppingUser obtener(String usuario, String clave);
}
