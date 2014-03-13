package es.indra.formacion.pr.shoppinglist.front.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.indra.formacion.pr.shoppinglist.front.form.UsuarioForm;

public class UsarioFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UsuarioForm.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errores) {
		UsuarioForm usuarioForm = (UsuarioForm)obj;
		
		if (usuarioForm.getUsuario() == null ||
				usuarioForm.getUsuario().trim().equals(""))
			errores.reject("usuario", "Usuario inválido");
		if (usuarioForm.getClave() == null ||
				usuarioForm.getClave().trim().equals(""))
			errores.reject("clave", "Clave inválida");
	}

}
