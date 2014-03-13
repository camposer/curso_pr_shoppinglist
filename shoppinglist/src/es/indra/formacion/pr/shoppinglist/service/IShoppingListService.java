package es.indra.formacion.pr.shoppinglist.service;

import java.util.List;

import es.indra.formacion.pr.shoppinglist.model.ShoppingItem;

public interface IShoppingListService {
	public void agregarElemento(ShoppingItem item);
	public void modificarElemento(ShoppingItem item);
	public List<ShoppingItem> obtenerElementos(Integer userId);
	public void cambiarEstado(Integer itemId);
	public void eliminarElemento(Integer itemId);
}
