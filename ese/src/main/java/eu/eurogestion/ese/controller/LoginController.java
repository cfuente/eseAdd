package eu.eurogestion.ese.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import eu.eurogestion.ese.domain.Cargo;
import eu.eurogestion.ese.domain.Compania;
import eu.eurogestion.ese.domain.Personal;
import eu.eurogestion.ese.domain.TipoCompania;
import eu.eurogestion.ese.pojo.CompaniaJSP;
import eu.eurogestion.ese.pojo.UsuarioJSP;
import eu.eurogestion.ese.pojo.UsuarioLoginJSP;
import eu.eurogestion.ese.repository.CargoDAO;
import eu.eurogestion.ese.repository.CompaniaDAO;
import eu.eurogestion.ese.repository.PersonalDAO;
import eu.eurogestion.ese.repository.TipoCompaniaDAO;

@Controller
public class LoginController {

	@Autowired
	public PersonalDAO personalDAO;

	@Autowired
	public CompaniaDAO companiaDAO;

	@Autowired
	public CargoDAO cargoDAO;

	@Autowired
	public TipoCompaniaDAO tipoCompaniaDAO;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("login") UsuarioLoginJSP usuarioLogin, Model model) {
		try {
			if (personalDAO.getPersonalByNameUserPassword(usuarioLogin.getNombre(),
					usuarioLogin.getPassword()) != null) {
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
		model.addAttribute("formularioUser", new UsuarioJSP());
		try {
			model.addAttribute("companias", companiaDAO.findAllCompaniaAlta());
			model.addAttribute("cargos", cargoDAO.findAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "register";
	}

	@RequestMapping(value = "/registrousuario", method = RequestMethod.POST)
	public String register(@Validated @ModelAttribute("formularioUser") UsuarioJSP newUser, BindingResult result,
			Model model) {
		boolean error = false;
		Date fechaNac = null;

		if (!StringUtils.isBlank(newUser.getUsuario()) && !usuarioCorrecto(newUser.getUsuario())) {
			model.addAttribute("errorUsuario", "El usuario ya esta registrado");
			error = true;
		}

		if (StringUtils.isBlank(newUser.getPassword()) ^ StringUtils.isBlank(newUser.getUsuario())) {
			error = true;
		}

		if (!newUser.getPassword().equalsIgnoreCase(newUser.getPasswordConfirm())) {
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

		if (StringUtils.isBlank(newUser.getFechaNacimiento())) {
			model.addAttribute("errorFecha", "La fecha no puede estar vacia");
			error = true;
		} else {

			fechaNac = fechaCorrecta(newUser.getFechaNacimiento());
			if (fechaNac == null) {
				model.addAttribute("errorFecha", "La fecha introducida es incorrecta");
				error = true;
			}
		}

		if (!StringUtils.isBlank(newUser.getNumero()) && !esNumero(newUser.getNumero())) {
			model.addAttribute("errorNumero", "El campo numero tiene que ser numerico");
			error = true;
		}

		if (!StringUtils.isBlank(newUser.getPlanta()) && !esNumero(newUser.getPlanta())) {
			model.addAttribute("errorPlanta", "El campo planta tiene que ser numerico");
			error = true;
		}

		if (error) {
			return falloRegistro(model);
		}

		try {
			// TODO falta implementar
			Personal personal = new Personal();
			if (!StringUtils.isBlank(newUser.getUsuario())) {

				personal.setNombreUsuario(newUser.getUsuario());
			}
			if (!StringUtils.isBlank(newUser.getPassword())) {
				personal.setClave(newUser.getPassword());
			}

			personal.setNombre(newUser.getNombre());
			personal.setApellido1(newUser.getApellido());
			personal.setApellido2(newUser.getApellido2());
			personal.setDocumento(newUser.getDocumento());
			personal.setFechaNac(fechaNac);

			if (!StringUtils.isBlank(newUser.getTipoVia())) {
				personal.setTipoVia(newUser.getTipoVia());
			}
			if (!StringUtils.isBlank(newUser.getVia())) {
				personal.setVia(newUser.getVia());
			}
			if (!StringUtils.isBlank(newUser.getNumero())) {
				personal.setNumero(Integer.parseInt(newUser.getNumero()));
			}
			if (!StringUtils.isBlank(newUser.getPlanta())) {
				personal.setPlanta(Integer.parseInt(newUser.getPlanta()));
			}
			if (!StringUtils.isBlank(newUser.getPuerta())) {
				personal.setPuerta(newUser.getPuerta());
			}
			if (!StringUtils.isBlank(newUser.getIdCompania()) && newUser.getIdCompania() != "0") {
				Compania compania = companiaDAO.get(Integer.parseInt(newUser.getIdCompania()));
				personal.setCompania(compania);
			}
			if (!StringUtils.isBlank(newUser.getIdCargo()) && newUser.getIdCargo() != "0") {
				Cargo cargo = cargoDAO.get(Integer.parseInt(newUser.getIdCargo()));
				personal.setCargo(cargo);
			}
			if (!StringUtils.isBlank(newUser.getLicencia())) {
				personal.setLicencia(newUser.getLicencia());
			}
			if (!StringUtils.isBlank(newUser.getDocEmpresa())) {
				personal.setDocEmpresa(newUser.getDocEmpresa());
			}
			if (!StringUtils.isBlank(newUser.getEmail())) {
				personal.setEmail(newUser.getEmail());
			}
			personalDAO.saveOrUpdate(personal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return falloRegistro(model);
		}
		model.addAttribute("userName", newUser.getNombre());

		return "welcome";
	}

	@RequestMapping(value = "/registerCompania", method = RequestMethod.GET)
	public String registerCompania(Model model) {
		model.addAttribute("formularioCompania", new CompaniaJSP());

		return "registerCompania";
	}

	@RequestMapping(value = "/registerCompania", method = RequestMethod.POST)
	public String registerCompania(@Validated @ModelAttribute("formularioCompania") CompaniaJSP newCompania,
			BindingResult result, Model model) {
		boolean error = false;
		if (StringUtils.isBlank(newCompania.getNombre())) {
			model.addAttribute("errorNombre", "El Nombre no puede estar vacio");
			error = true;
		}
		if (StringUtils.isBlank(newCompania.getDocumento())) {
			model.addAttribute("errorDocumento", "El documento no puede estar vacio");
			error = true;
		}
		if (!StringUtils.isBlank(newCompania.getNumero()) && !esNumero(newCompania.getNumero())) {
			model.addAttribute("errorNumero", "El campo numero tiene que ser numerico");
			error = true;
		}

		if (!StringUtils.isBlank(newCompania.getPlanta()) && !esNumero(newCompania.getPlanta())) {
			model.addAttribute("errorPlanta", "El campo planta tiene que ser numerico");
			error = true;
		}

		if (error) {
			return falloRegistro(model);
		}
		try {
			// TODO falta implementar
			Compania compania = new Compania();

			compania.setNombre(newCompania.getNombre());
			if (!StringUtils.isBlank(newCompania.getTipoCompania()) && newCompania.getTipoCompania() != "0") {
				TipoCompania tipoCompania = tipoCompaniaDAO.get(Integer.parseInt(newCompania.getTipoCompania()));
				compania.setTipoCompania(tipoCompania);
			}
			compania.setDocumento(newCompania.getDocumento());
			if (!StringUtils.isBlank(newCompania.getTipoVia())) {
				compania.setTipoVia(newCompania.getTipoVia());
			}
			if (!StringUtils.isBlank(newCompania.getVia())) {
				compania.setVia(newCompania.getVia());
			}
			if (!StringUtils.isBlank(newCompania.getNumero())) {
				compania.setNumero(Integer.parseInt(newCompania.getNumero()));
			}
			if (!StringUtils.isBlank(newCompania.getPlanta())) {
				compania.setPlanta(Integer.parseInt(newCompania.getPlanta()));
			}
			if (!StringUtils.isBlank(newCompania.getPuerta())) {
				compania.setPuerta(newCompania.getPuerta());
			}

			companiaDAO.saveOrUpdate(compania);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "registerCompania";
		}

		return "welcome";

	}

	private boolean esNumero(String numero) {
		try {
			Integer.parseInt(numero);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	private String falloRegistro(Model model) {
		try {
			model.addAttribute("companias", companiaDAO.findAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			model.addAttribute("cargos", cargoDAO.findAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "register";
	}

	@RequestMapping(value = "/cancelar", method = { RequestMethod.GET, RequestMethod.POST })
	public String cancelar() {
		return "redirect:/";
	}

	private Date fechaCorrecta(String fecha) {

		String[] componentesFecha;

		if (fecha.contains("-")) {
			componentesFecha = fecha.split("-");
		} else if (fecha.contains("/")) {
			componentesFecha = fecha.split("/");
		} else {
			return null;
		}
		if (componentesFecha.length != 3) {
			return null;
		}
		String dia = componentesFecha[0];
		String mes = componentesFecha[1];
		String anho = componentesFecha[2];

		if (anho.length() == 1 || anho.length() == 3) {
			return null;
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
			return a.parse(anho + "-" + mes + "-" + dia);

		} catch (ParseException e) {
			return null;
		}

	}

	private boolean documentoCorrecto(String documento) {
		// TODO falta implementar
		return true;

	}

	private boolean usuarioCorrecto(String usuario) {
		Personal p = personalDAO.getPersonalByNameUser(usuario);
		return p == null;
	}

}