package eu.eurogestion.ese.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eu.eurogestion.ese.domain.Personal;
import eu.eurogestion.ese.pojo.UsuarioJSP;
import eu.eurogestion.ese.pojo.UsuarioLoginJSP;
import eu.eurogestion.ese.repository.PersonalDAO;

@Controller
public class LoginController {

	@Autowired
	public PersonalDAO personalDAO;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("login") UsuarioLoginJSP usuarioLogin, Model model) {
		try {
			if (personalDAO.login(usuarioLogin.getNombre(), usuarioLogin.getPassword())) {
				model.addAttribute("userName", usuarioLogin.getNombre());
				return "welcome";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("error", "La combinación de Usuario y Contraseña no es correcta.");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("login", new UsuarioLoginJSP());
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("newUser", new UsuarioJSP());

		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Validated @ModelAttribute("newUser") UsuarioJSP newUser, BindingResult result,
			Model model) {
		boolean error = false;
		boolean todosLosDatos = true;
		if (StringUtils.isBlank(newUser.getNombre())) {
			model.addAttribute("errorNombre", "El nombre no puede estar vacio");
			todosLosDatos = false;
			error = true;
		}

		if (StringUtils.isBlank(newUser.getPassword())) {
			model.addAttribute("errorPassword", "La contraseña no puede estar vacia");
			todosLosDatos = false;
			error = true;
		}
		if (StringUtils.isBlank(newUser.getPasswordConfirm())) {
			model.addAttribute("errorPasswordConfirm", "La confirmacion de la contraseña no puede estar vacia");
			todosLosDatos = false;
			error = true;
		}
		if (todosLosDatos && !newUser.getPassword().equalsIgnoreCase(newUser.getPasswordConfirm())) {
			model.addAttribute("error", "Las contraseñas no son iguales");
			error = true;
		}

		if (error) {
			return "register";
		}

		try {
			// TODO falta implementar
			Personal personal = personalDAO.create();
			personalDAO.saveOrUpdate(personal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "register";
		}
		model.addAttribute("userName", newUser.getNombre());

		return "welcome";
	}

	@RequestMapping(value = "/cancelar", method = { RequestMethod.GET, RequestMethod.POST })
	public String cancelar() {
		return "redirect:/";
	}

}