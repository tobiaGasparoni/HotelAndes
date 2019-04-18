package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileReader;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import main.java.hotelAndes.negocio.HotelAndes;
import main.java.hotelAndes.negocio.VOTipoHabitacion;

public class TipoHabitacionTest
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(TipoHabitacionTest.class.getName());
	
	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos: La unidad de persistencia existe y el esquema de la BD también
	 */
	private static final String CONFIG_TABLAS = "./src/main/resources/config/tablas.json";
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
    /**
     * Objeto JSON con los nombres de las tablas de la base de datos que se quieren utilizar
     */
    private JsonObject tableConfig;
    
	/**
	 * La clase que se quiere probar
	 */
    private HotelAndes hotelAndes;
	
    /* ****************************************************************
	 * 			Métodos de prueba para la tabla TipoHabitacion - Creación y borrado
	 *****************************************************************/
	/**
	 * Método que prueba las operaciones sobre la tabla TipoHabitacion
	 * 1. Adicionar un tipo de habitacion
	 * 2. Listar el contenido de la tabla con 0, 1 y 2 registros insertados
	 * 3. Borrar un tipo de habitacion por su identificador
	 * 4. Borrar un tipo de habitacion por su nombre
	 */
    @Test
	public void CRDTipoBebidaTest() 
	{
    	BasicConfigurator.configure();
    	// Probar primero la conexión a la base de datos
		try
		{
			log.info ("Probando las operaciones CRD sobre TipoHabitacion");
			hotelAndes = new HotelAndes(openConfig ("Interfaz", CONFIG_TABLAS));
		}
		catch (Exception e)
		{
//			e.printStackTrace();
			log.info ("Prueba de CRD de TipoHabitacion incompleta. No se pudo conectar a la base de datos !!. La excepción generada es: " + e.getClass ().getName ());
			log.info ("La causa es: " + e.getCause ().toString ());

			String msg = "Prueba de CRD de TipoHabitacion incompleta. No se pudo conectar a la base de datos !!.\n";
			msg += "Revise el log de hotelAndes y el de datanucleus para conocer el detalle de la excepción";
			System.out.println (msg);
			fail (msg);
		}
		
		// Ahora si se pueden probar las operaciones
    	try
		{
			// Lectura de los tipos de habitacion con la tabla vacía
			List <VOTipoHabitacion> lista = hotelAndes.darVOTipoHabitacion();
			assertEquals ("No debe haber tipos de habitacion creados!!", 0, lista.size ());

			// Lectura de los tipos de habitacion con un tipo de bebida adicionado
			String nombreTipoHabitacion1 = "Presidencial";
			String descripcionTipoHabitacion1 = "Descripcion de la habitacion Presidencial";
			VOTipoHabitacion tipoHabitacion1 = hotelAndes.adicionarTipoHabitacion(nombreTipoHabitacion1, descripcionTipoHabitacion1);
			lista = hotelAndes.darVOTipoHabitacion();
			assertEquals ("Debe haber un tipo de habitacion creado !!", 1, lista.size ());
			assertEquals ("El objeto creado y el traido de la BD deben ser iguales !!", tipoHabitacion1, lista.get(0));

			// Lectura de los tipos de habitacion con dos tipos de habitacion adicionados
			String nombreTipoHabitacion2 = "PresidencialBis";
			String descripcionTipoHabitacion2 = "Descripcion de la habitacion PresidencialBis";
			VOTipoHabitacion tipoHabitacion2 = hotelAndes.adicionarTipoHabitacion(nombreTipoHabitacion2, descripcionTipoHabitacion2);
			lista = hotelAndes.darVOTipoHabitacion();
			assertEquals ("Debe haber dos tipos de habitacion creado !!", 2, lista.size ());
			assertEquals ("El objeto creado y el traido de la BD deben ser iguales !!", tipoHabitacion2, lista.get(1));
			
			// Prueba de eliminación de un tipo de habitacion, dado su identificador
			long tbEliminados = hotelAndes.eliminarTipoHabitacionPorId (tipoHabitacion1.getId());
			assertEquals ("Debe haberse eliminado un tipo de habitacion !!", 1, tbEliminados);
			lista = hotelAndes.darVOTipoHabitacion();
			assertEquals ("Debe haber un solo tipo de habitacion !!", 1, lista.size ());
			assertFalse ("El primer tipo de habitacion adicionado NO debe estar en la tabla", tipoHabitacion1.equals (lista.get (0)));
			assertTrue ("El segundo tipo de habitacion adicionado debe estar en la tabla", tipoHabitacion2.equals (lista.get (0)));
			
			// Prueba de eliminación de un tipo de habitacion, dado su identificador
			tbEliminados = hotelAndes.eliminarTipoHabitacionPorId (tipoHabitacion2.getId());
			assertEquals ("Debe haberse eliminado un tipo de habitacion !!", 1, tbEliminados);
			lista = hotelAndes.darVOTipoHabitacion();
			assertEquals ("La tabla debió quedar vacía !!", 0, lista.size ());
		}
		catch (Exception e)
		{
//			e.printStackTrace();
			String msg = "Error en la ejecución de las pruebas de operaciones sobre la tabla TipoHabitacion.\n";
			msg += "Revise el log de hotelAndes y el de datanucleus para conocer el detalle de la excepción";
			System.out.println (msg);

    		fail ("Error en las pruebas sobre la tabla TipoHabitacion");
		}
		finally
		{
			hotelAndes.limpiarHotelAndes ();
			hotelAndes.cerrarUnidadPersistencia ();    		
		}
	}

    /**
     * Método de prueba de la restricción de unicidad sobre el nombre de TipoHabitacion
     */
	/*@Test
	public void unicidadTipoBebidaTest() 
	{
    	// Probar primero la conexión a la base de datos
		try
		{
			log.info ("Probando la restricción de UNICIDAD del nombre del tipo de bebida");
			parranderos = new Parranderos (openConfig (CONFIG_TABLAS_A));
		}
		catch (Exception e)
		{
//			e.printStackTrace();
			log.info ("Prueba de UNICIDAD de Tipobebida incompleta. No se pudo conectar a la base de datos !!. La excepción generada es: " + e.getClass ().getName ());
			log.info ("La causa es: " + e.getCause ().toString ());

			String msg = "Prueba de UNICIDAD de Tipobebida incompleta. No se pudo conectar a la base de datos !!.\n";
			msg += "Revise el log de parranderos y el de datanucleus para conocer el detalle de la excepción";
			System.out.println (msg);
			fail (msg);
		}
		
		// Ahora si se pueden probar las operaciones
		try
		{
			// Lectura de los tipos de bebida con la tabla vacía
			List <VOTipoBebida> lista = parranderos.darVOTiposBebida();
			assertEquals ("No debe haber tipos de bebida creados!!", 0, lista.size ());

			// Lectura de los tipos de bebida con un tipo de bebida adicionado
			String nombreTipoBebida1 = "Vino tinto";
			VOTipoBebida tipoBebida1 = parranderos.adicionarTipoBebida (nombreTipoBebida1);
			lista = parranderos.darVOTiposBebida();
			assertEquals ("Debe haber un tipo de bebida creado !!", 1, lista.size ());

			VOTipoBebida tipoBebida2 = parranderos.adicionarTipoBebida (nombreTipoBebida1);
			assertNull ("No puede adicionar dos tipos de bebida con el mismo nombre !!", tipoBebida2);
		}
		catch (Exception e)
		{
//			e.printStackTrace();
			String msg = "Error en la ejecución de las pruebas de UNICIDAD sobre la tabla TipoBebida.\n";
			msg += "Revise el log de parranderos y el de datanucleus para conocer el detalle de la excepción";
			System.out.println (msg);

    		fail ("Error en las pruebas de UNICIDAD sobre la tabla TipoBebida");
		}    				
		finally
		{
			parranderos.limpiarParranderos ();
    		parranderos.cerrarUnidadPersistencia ();    		
		}
	}*/

	/* ****************************************************************
	 * 			Métodos de configuración
	 *****************************************************************/
    /**
     * Lee datos de configuración para la aplicación, a partir de un archivo JSON o con valores por defecto si hay errores.
     * @param tipo - El tipo de configuración deseada
     * @param archConfig - Archivo Json que contiene la configuración
     * @return Un objeto JSON con la configuración del tipo especificado
     * 			NULL si hay un error en el archivo.
     */
    private JsonObject openConfig (String tipo, String archConfig)
    {
    	JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);			 
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			log.info ("Se encontró un archivo de configuración válido: " + tipo);
		} 
		catch (Exception e)
		{
			e.printStackTrace ();
			log.info ("NO se encontró un archivo de configuración válido");			
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "HotelAndes", JOptionPane.ERROR_MESSAGE);
		}	
        return config;
    }	
}
