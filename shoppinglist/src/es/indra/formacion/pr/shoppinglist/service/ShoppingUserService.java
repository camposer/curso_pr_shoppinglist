package es.indra.formacion.pr.shoppinglist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.indra.formacion.pr.shoppinglist.dao.IShoppingUserDao;
import es.indra.formacion.pr.shoppinglist.model.ShoppingUser;

@Transactional
public class ShoppingUserService implements IShoppingUserService {
	@Autowired
	private IShoppingUserDao userDao;

	@Override
	public ShoppingUser autenticar(String usuario, String clave) {
		return userDao.obtener(usuario, clave);
	}

}
