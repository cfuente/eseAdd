package eu.eurogestion.ese.pojo;

import lombok.Data;

@Data
public class UsuarioJSP {
	private String documento;
	private String nombre;
	private String apellido;
	private String apellido2;
	private String fechaNacimiento;
	private String tipoVia;
	private String via;
	private String numero;
	private String planta;
	private String puerta;
	private String usuario;
	private String idCompania;
	private String idCargo;
	private String password;
	private String passwordConfirm;
	private String licencia;
	private String docEmpresa;
	private String email;
	private String idRol;
}
