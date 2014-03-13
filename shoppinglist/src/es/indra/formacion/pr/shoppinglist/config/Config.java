package es.indra.formacion.pr.shoppinglist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.indra.formacion.pr.shoppinglist.dao.IShoppingItemDao;
import es.indra.formacion.pr.shoppinglist.dao.IShoppingUserDao;
import es.indra.formacion.pr.shoppinglist.dao.ShoppingItemDao;
import es.indra.formacion.pr.shoppinglist.dao.ShoppingUserDao;
import es.indra.formacion.pr.shoppinglist.service.IShoppingListService;
import es.indra.formacion.pr.shoppinglist.service.IShoppingUserService;
import es.indra.formacion.pr.shoppinglist.service.ShoppingListService;
import es.indra.formacion.pr.shoppinglist.service.ShoppingUserService;

@Configuration
public class Config {
	@Bean
	public IShoppingUserDao shoppingUserDao() {
		return new ShoppingUserDao();
	}

	@Bean
	public IShoppingItemDao shoppingListDao() {
		return new ShoppingItemDao();
	}

	@Bean
	public IShoppingListService shoppingListService() {
		return new ShoppingListService();
	}

	@Bean
	public IShoppingUserService shoppingUserService() {
		return new ShoppingUserService();
	}
}
