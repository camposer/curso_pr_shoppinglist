package es.indra.formacion.pr.shoppinglist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.indra.formacion.pr.shoppinglist.dao.IShoppingItemDao;
import es.indra.formacion.pr.shoppinglist.dao.IShoppingUserDao;
import es.indra.formacion.pr.shoppinglist.model.ShoppingItem;
import es.indra.formacion.pr.shoppinglist.model.ShoppingItemStatus;
import es.indra.formacion.pr.shoppinglist.model.ShoppingUser;

@Transactional
public class ShoppingListService implements IShoppingListService {
	@Autowired
	private IShoppingItemDao itemDao;
	@Autowired
	private IShoppingUserDao userDao;

	@Override
	public void agregarElemento(ShoppingItem item) {
		// Buscando usuario para que sea persistente
		Integer userId = item.getShoppingUser().getId();
		ShoppingUser user = userDao.obtener(userId);
		item.setShoppingUser(user);

		itemDao.agregar(item);
	}

	@Override
	public void modificarElemento(ShoppingItem item) {
		// Buscando usuario para que sea persistente
		Integer userId = item.getShoppingUser().getId();
		ShoppingUser user = userDao.obtener(userId);
		item.setShoppingUser(user);
		
		itemDao.modificar(item);
	}

	@Override
	public List<ShoppingItem> obtenerElementos(Integer userId) {
		return itemDao.obtenerTodos();
	}

	@Override
	public void cambiarEstado(Integer itemId) {
		ShoppingItem item = itemDao.obtener(itemId);
		
		if (item.getStatus().equals(ShoppingItemStatus.ACTIVO.ordinal())) {
			item.setStatus(ShoppingItemStatus.INACTIVO.ordinal());
		} else {
			item.setStatus(ShoppingItemStatus.ACTIVO.ordinal());			
		}
		
		itemDao.modificar(item);
	}

	@Override
	public void eliminarElemento(Integer itemId) {
		itemDao.eliminar(itemId);	
	}

}
