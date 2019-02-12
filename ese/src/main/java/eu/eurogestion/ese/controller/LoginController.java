package eu.eurogestion.ese.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

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
		if (StringUtils.isBlank(newUser.getUsuario())) {
			model.addAttribute("errorUsuario", "El usuario no puede estar vacio");
			todosLosDatos = false;
			error = true;
		} else if (!usuarioCorrecto(newUser.getUsuario())) {
			model.addAttribute("errorUsuario", "El usuario ya esta registrado");
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
		if (StringUtils.isBlank(newUser.getNombre())) {
			model.addAttribute("errorNombre", "El nombre no puede estar vacio");
			error = true;
		}
		if (StringUtils.isBlank(newUser.getApellido())) {
			model.addAttribute("errorApellido", "El apellido no puede estar vacio");
			error = true;
		}
		if (StringUtils.isBlank(newUser.getDocumento())) {
			model.addAttribute("errorDocumento", "El documento no puede estar vacio");
			error = true;
		} else if (!documentoCorrecto(newUser.getDocumento())) {
			model.addAttribute("errorDocumento", "El documento es incorrecto");
			error = true;
		}

		if (StringUtils.isBlank(newUser.getFechaNacimientoDia()) || StringUtils.isBlank(newUser.getFechaNacimientoMes())
				|| StringUtils.isBlank(newUser.getFechaNacimientoAnho())) {
			model.addAttribute("errorFecha", "La fecha no puede estar vacia");
			error = true;
		} else if (!fechaCorrecta(newUser.getFechaNacimientoDia(), newUser.getFechaNacimientoMes(),
				newUser.getFechaNacimientoAnho())) {
			model.addAttribute("errorFecha", "La fecha introducida es incorrecta");
			error = true;
		}

		if (error) {
			return "register";
		}

		try {
			// TODO falta implementar
			Personal personal = personalDAO.create();
			personal.setNombre(newUser.getNombre());
			personal.setApellido1(newUser.getApellido());
			personal.setNombreUsuario(newUser.getUsuario());
			personal.setClave(newUser.getPassword());
			personal.setDocumento(newUser.getDocumento());
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

	private boolean fechaCorrecta(String dia, String mes, String anho) {
		if (anho.length() == 1 || anho.length() == 3) {
			return false;
		}
		if (dia.length() != 2) {
			dia = "0" + dia;
		}
		if (mes.length() != 2) {
			mes = "0" + mes;
		}

		try {

			String pattern = "yyyy-MM-dd";
			if (anho.length() == 2) {
				pattern = "yy-MM-dd";
			}
			SimpleDateFormat a = new SimpleDateFormat(pattern);
			a.parse(anho + "-" + mes + "-" + dia);

		} catch (ParseException e) {
			return false;
		}

		return true;

	}

	private boolean documentoCorrecto(String documento) {
		// TODO falta implementar
		return true;

	}

	private boolean usuarioCorrecto(String usuario) {
		return personalDAO.getpersonalByNameUser(usuario) != null;

	}

}