/**
 * 
 */
package main.java.hotelAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import main.java.hotelAndes.negocio.Usuario;
import main.java.hotelAndes.negocio.VOUsuario.TIPO_USUARIO;

/**
 * @author Julián Mendoza
 *
 */
public class SQLUsuario 
{

	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaHotelAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaHotelAndes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLUsuario (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Usuario
	 */
	public long adicionarUsuario (PersistenceManager pm, String tipoDocumento, String documento, String tipo, String nombre, String correo, String login, String clave ) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaUsuario() + "(tipo_documento, documento, tipo, nombre, correo, login, clave) values (?, ?, ?,?,?,?,?)");
        q.setParameters(tipoDocumento, documento, tipo, nombre, correo, login, clave);
        return (long) q.executeUnique();
	}
	
	/**
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarUsuarioPorId (PersistenceManager pm, String tipoDocumento, String documento)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuario() + " WHERE tipo_documento = ? AND documento = ?");
        q.setParameters(tipoDocumento, documento);
        return (long) q.executeUnique();            
	}
	
	/**
	 * @return El objeto Usuario que tiene el identificador dado
	 */
	public Usuario darUsuarioPorId (PersistenceManager pm, String tipoDocumento, String documento) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario() + "  WHERE tipo_documento = ? AND documento = ?");
		q.setResultClass(Usuario.class);
		q.setParameters(tipoDocumento, documento);
		return (Usuario) q.executeUnique();
	}
	
	public List<Usuario> darUsuarios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario());
		q.setResultClass(Usuario.class);
		return (List<Usuario>) q.executeList();
	}
	
}
