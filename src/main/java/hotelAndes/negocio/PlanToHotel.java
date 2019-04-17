/**
 * 
 */
package main.java.hotelAndes.negocio;

/**
 * @author jdmen
 *
 */
public class PlanToHotel implements VOPlanToHotel {

	private long idPlan;
	
	private long idHotel;
	
	public PlanToHotel()
	{
		this.idPlan= 0;
		
		this.idHotel=0;
	}

	public PlanToHotel(long idPlan, long idHotel) {
		super();
		this.idPlan = idPlan;
		this.idHotel = idHotel;
	}

	public long getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(long idPlan) {
		this.idPlan = idPlan;
	}

	public long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}
	
	
}
