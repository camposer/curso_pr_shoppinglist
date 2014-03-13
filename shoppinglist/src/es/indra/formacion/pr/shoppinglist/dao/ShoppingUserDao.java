package es.indra.formacion.pr.shoppinglist.dao;

import javax.persistence.Query;

import es.indra.formacion.pr.shoppinglist.model.ShoppingUser;

public class ShoppingUserDao extends BaseDao<ShoppingUser, Integer> implements
		IShoppingUserDao {

	@Override
	public ShoppingUser obtener(String usuario, String clave) {
		Query q = em.createQuery("SELECT u FROM user = :usuario AND password = :clave");
		q.setParameter("usuario", usuario);
		q.setParameter("clave", clave);
		
		return (ShoppingUser)q.getSingleResult();
	}

}
