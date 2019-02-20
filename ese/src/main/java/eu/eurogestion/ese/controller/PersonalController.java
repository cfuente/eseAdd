package eu.eurogestion.ese.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eu.eurogestion.ese.pojo.PersonalJSP;
import eu.eurogestion.ese.repository.CargoDAO;
import eu.eurogestion.ese.repository.PersonalDAO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author alvaro
 *
 */
@Slf4j
@Controller
public class PersonalController {

	/**
	 * Repositorio de la clase de dominio Personal
	 */
	@Autowired
	public PersonalDAO personalDAO;

	/**
	 * Repositorio de la clase de dominio Cargo
	 */
	@Autowired
	public CargoDAO cargoDAO;

	/**
	 * Metodo que busca en base de datos el usuario y la contraseña introducidos en
	 * pantalla para ver si existe en el sistema y rellena el objeto usuario de la
	 * sesion
	 * 
	 * @param usuarioLogin
	 * @param model
	 * @param session
	 * @return
	 */

	@RequestMapping(value = "/informePersonal", method = RequestMethod.POST)
	public String login(@ModelAttribute("formularioPersonal") PersonalJSP personal, Model model, HttpSession session) {

		try {
			System.out.println(personal.toString());

			return "welcome";

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("error", "La combinación de Usuario y Contraseña no es correcta.");
		return "welcome";
	}

	/**
	 * Metodo que inicializa el formulario de personal
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/personal", method = RequestMethod.GET)
	public String login(Model model) {
		try {
			model.addAttribute("cargos", cargoDAO.findAll());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		try {
			model.addAttribute("personas", personalDAO.obtenerPersonal());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		model.addAttribute("formularioPersonal", new PersonalJSP());
		return "personal";
	}

	@RequestMapping(value = "/filtrarPersonal", method = RequestMethod.POST)
	public String filtrarPersonal(@ModelAttribute("formularioPersonal") PersonalJSP personal, Model model,
			HttpSession session) {

		try {
			model.addAttribute("personas", personalDAO.obtenerPersonalByFilters(personal.getIdCargo(),
					personal.getNombre(), personal.getApellido()));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		try {
			model.addAttribute("cargos", cargoDAO.findAll());
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return "personal";
	}

	@RequestMapping(value = "/borrarFiltrosPersonal", method = RequestMethod.POST)
	public String borrarFiltrosPersonal(@ModelAttribute("formularioPersonal") PersonalJSP personal, Model model,
			HttpSession session) {
		personal.setNombre(null);
		personal.setApellido(null);
		personal.setIdCargo(null);
		personal.setListIdPersonal(null);

		try {
			model.addAttribute("personas", personalDAO.obtenerPersonal());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		try {
			model.addAttribute("cargos", cargoDAO.findAll());
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return "personal";
	}

}