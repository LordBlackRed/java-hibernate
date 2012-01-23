package es.cea.inmobiliaria;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Habitacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6231397430108033732L;
	private boolean tieneVentana;
	private Casa casa;
	private Long id;

	public Habitacion() {
		this.tieneVentana = false;
		this.casa = null;
		this.id = 0L;
	}

	public boolean isTieneVentana() {
		return tieneVentana;
	}

	public void setTieneVentana(boolean tieneVentana) {
		this.tieneVentana = tieneVentana;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	@Id
	@GeneratedValue
	public Long getIdHabitacion() {
		return id;
	}

	public void setIdHabitacion(Long idHabitacion) {
		this.id = idHabitacion;
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
		Habitacion other = (Habitacion) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Habitacion(boolean tieneVentana, Casa casa, Long idHabitacion) {
		super();
		this.tieneVentana = tieneVentana;
		this.casa = casa;
		this.id = idHabitacion;
	}

}
