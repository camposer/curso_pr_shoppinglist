package es.indra.formacion.pr.shoppinglist.dao;

import java.util.List;

import javax.persistence.Query;

import es.indra.formacion.pr.shoppinglist.model.ShoppingUser;

public class ShoppingUserDao extends BaseDao<ShoppingUser, Integer> implements
		IShoppingUserDao {

	@SuppressWarnings("unchecked")
	@Override
	public ShoppingUser obtener(String usuario, String clave) {
		ShoppingUser result = null;
		
		Query q = em.createQuery("SELECT u FROM ShoppingUser u WHERE u.login = :usuario AND u.password = :clave");
		q.setParameter("usuario", usuario);
		q.setParameter("clave", clave);
		
		List<ShoppingUser> shoppingUsers =  q.getResultList();
		if (shoppingUsers != null && 
				shoppingUsers.size() > 0)
			result = shoppingUsers.get(0);
		
		return result;
	}

}
