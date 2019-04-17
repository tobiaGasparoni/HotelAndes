/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * Interfaz para los métodos get de USUARIO.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * @author Julián Mendoza
 *
 */
public interface VOUsuario 
{
	/* ****************************************************************
	 * 			ENUMERACION
	 *****************************************************************/
	public enum TIPO_USUARIO {
	    CLIENTE,
	    RECEPCIONISTA,
	    EMPLEADO,
	    ADMINISTRADOR,
	    GERENTE,
	    ORGANIZADOR_EVENTOS	
	  }
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	public long getId();
	
	/**
	 * 
	 * @return El login del usuario
	 */
	public String getLogin();
	
	public String getNombre();
	
	/**
	 * 
	 * @return El documento del usuario
	 */
	public String getDocumento();
	
	/**
	 * 
	 * @return La clave del usuario
	 */
	public String getClave();
	/**
	 * 
	 * @return El tipo del usuario.
	 */
	public TIPO_USUARIO getTipoUsuario();
	
	
	/**
	 * 
	 * @return El tipo de documento del usuario.
	 */
	public String getTipoDocumento();

	
	/**
	 * 
	 * @return El correo del usuario.
	 */
	public String getCorreo();
	
	
}
