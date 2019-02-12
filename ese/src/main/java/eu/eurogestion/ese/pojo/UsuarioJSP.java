package eu.eurogestion.ese.pojo;

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

	public UsuarioJSP() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNacimientoDia() {
		return fechaNacimientoDia;
	}

	public void setFechaNacimientoDia(String fechaNacimientoDia) {
		this.fechaNacimientoDia = fechaNacimientoDia;
	}

	public String getFechaNacimientoMes() {
		return fechaNacimientoMes;
	}

	public void setFechaNacimientoMes(String fechaNacimientoMes) {
		this.fechaNacimientoMes = fechaNacimientoMes;
	}

	public String getFechaNacimientoAnho() {
		return fechaNacimientoAnho;
	}

	public void setFechaNacimientoAnho(String fechaNacimientoAnho) {
		this.fechaNacimientoAnho = fechaNacimientoAnho;
	}

}
