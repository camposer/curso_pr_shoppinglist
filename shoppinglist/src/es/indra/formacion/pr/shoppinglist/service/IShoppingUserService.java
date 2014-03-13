package es.indra.formacion.pr.shoppinglist.service;

import es.indra.formacion.pr.shoppinglist.model.ShoppingUser;

public interface IShoppingUserService {
	public ShoppingUser autenticar(String usuario, String clave);
}
