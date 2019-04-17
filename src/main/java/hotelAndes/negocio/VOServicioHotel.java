package main.java.hotelAndes.negocio;

public interface VOServicioHotel {
	
	public long getId();
	
	public String getNombre();
	 
	public String getDescripcion();
	
	public int getCapacidad();
	
	public int getOcupacionActual();
	
	public boolean isEnMantenimiento();
	
	public String getHorario();

}
