package es.indra.formacion.pr.shoppinglist.front.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.indra.formacion.pr.shoppinglist.front.form.UsuarioForm;
import es.indra.formacion.pr.shoppinglist.front.validator.UsarioFormValidator;
import es.indra.formacion.pr.shoppinglist.model.ShoppingItem;
import es.indra.formacion.pr.shoppinglist.model.ShoppingUser;
import es.indra.formacion.pr.shoppinglist.service.IShoppingListService;
import es.indra.formacion.pr.shoppinglist.service.IShoppingUserService;

@Controller
@RequestMapping("/*")
public class ShoppingListController {
	@Autowired
	private IShoppingListService shoppingListService;
	@Autowired
	private IShoppingUserService shoppingUserService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new UsarioFormValidator());
	}
	
	@ModelAttribute("usuarioForm")
	public UsuarioForm usuarioForm() {
		return new UsuarioForm();
	}
	
	@RequestMapping("inicio")
	public String inicio() {
		return "/jsp/inicio.jsp";
	}
	
	@RequestMapping("autenticar")
	public String autenticar(
			HttpSession sesion,
			@Valid @ModelAttribute("usuarioForm") UsuarioForm usuarioForm,
			BindingResult binding) {
		
		ShoppingUser user = null;
		if (!binding.hasErrors()) {
			user = shoppingUserService.autenticar(
				usuarioForm.getUsuario(), 
				usuarioForm.getClave());
		}
		
		if (user == null) {
			ObjectError error = new ObjectError("usuario", "Usuario o contraseña inválidos");
			binding.addError(error);

			return "/jsp/inicio.jsp";
		} else {
			sesion.setAttribute("usuario", user);

			return "redirect:shoppinglist.sl";
		}
	}
	
	@RequestMapping("shoppinglist")
	public String shoppinglist(
				HttpSession sesion,
				Model model
			) {
		// TODO: Validar que otro usuario no ve lo que no le corresponde (sin Spring Security)
		
		ShoppingUser usuario = (ShoppingUser)sesion.getAttribute("usuario");
		
		List<ShoppingItem> items = shoppingListService.obtenerElementos(usuario.getId());
		model.addAttribute("items", items);
		
		return "/jsp/shoppinglist.jsp";
	}
	
	@RequestMapping(value="cambiarEstado", 
			method={RequestMethod.POST}) 
	public @ResponseBody String cambiarEstado(@RequestParam Integer id) {
		
		shoppingListService.cambiarEstado(id);
		
		return "";
	}
	
}
