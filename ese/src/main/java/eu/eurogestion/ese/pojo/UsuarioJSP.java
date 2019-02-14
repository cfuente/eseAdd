package eu.eurogestion.ese.pojo;

import lombok.Data;

@Data
public class UsuarioJSP {
	private String usuario;
	private String password;
	private String passwordConfirm;
	private String documento;
	private String nombre;
	private String apellido;
	private String fechaNacimientoDia;
	private String fechaNacimientoMes;
	private String fechaNacimientoAnho;
	
}
