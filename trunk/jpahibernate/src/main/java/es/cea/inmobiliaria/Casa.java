package es.cea.inmobiliaria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Casa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8327685350655310081L;
	private String direccion;
	private int cp;
	private List<Habitacion> habitaciones;
	private Long id;
	private Barrio barrio;
	
	public Casa(){
		this.direccion="";
		this.cp = 0;
		this.habitaciones = new ArrayList<Habitacion>();
		this.id= 0L;
		this.barrio= null;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}
	
	@OneToMany(mappedBy="casa")
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	@Id
	@GeneratedValue
	public Long getIdCasa() {
		return id;
	}

	public void setIdCasa(Long idCasa) {
		this.id = idCasa;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	public Barrio getBarrio() {
		return barrio;
	}

	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}

	public Casa(String direccion, int cp, List<Habitacion> habitaciones,
			Long id, Barrio barrio) {
		super();
		this.direccion = direccion;
		this.cp = cp;
		this.habitaciones = habitaciones;
		this.id = id;
		this.barrio = barrio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Casa other = (Casa) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
