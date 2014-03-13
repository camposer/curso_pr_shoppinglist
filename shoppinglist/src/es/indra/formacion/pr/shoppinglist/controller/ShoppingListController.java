package es.indra.formacion.pr.shoppinglist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import es.indra.formacion.pr.shoppinglist.service.IShoppingListService;
import es.indra.formacion.pr.shoppinglist.service.IShoppingUserService;

@Controller
@RequestMapping("/")
public class ShoppingListController {
	@Autowired
	private IShoppingListService shoppingListService;
	@Autowired
	private IShoppingUserService shoppingUserService;
	
	
}
