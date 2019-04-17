/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author Julián Mendoza
 *
 */
public class Usuario implements VOUsuario {

	private long id;
	
	private String login;

	private String nombre;
	
	private String documento;

	private String clave;

	private TIPO_USUARIO tipoUsuario;

	private String tipoDocumento;
	
	private String correo;

	/**
	 * @param id
	 * @param login
	 * @param nombre
	 * @param documento
	 * @param clave
	 * @param tipoUsuario
	 * @param tipoDocumento
	 * @param correo
	 */
	public Usuario(long id, String login, String nombre, String documento, String clave, TIPO_USUARIO tipoUsuario,
			String tipoDocumento, String correo) {
		this.id = id;
		this.login = login;
		this.nombre = nombre;
		this.documento = documento;
		this.clave = clave;
		this.tipoUsuario = tipoUsuario;
		this.tipoDocumento = tipoDocumento;
		this.correo = correo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public TIPO_USUARIO getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TIPO_USUARIO tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
}
