package es.cea.inmobiliaria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Inmobiliaria implements Serializable{

	private String cif;
	private String nombre;
	private List<Ciudad> ciudades;
	private List<Barrio> barrios;
	private Long id;

	public Inmobiliaria(){
		this.cif = "";
		this.nombre ="";
		this.ciudades = new ArrayList<Ciudad>();
		this.barrios = new ArrayList<Barrio>();
		this.id = 0L;
	}
	@Id
	@GeneratedValue
	public long getIdInmobiliaria() {
		return id;
	}

	public void setIdInmobiliaria(Long idInmobiliaria) {
		this.id = idInmobiliaria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (id ^ (id >>> 32));
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
		Inmobiliaria other = (Inmobiliaria) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@ManyToMany
	@JoinTable(name="CIUDADES_INMOBILIARIAS", 
			joinColumns=
		    @JoinColumn(name="idInmobiliaria", referencedColumnName="idInmobiliaria"),
		    inverseJoinColumns=
		    @JoinColumn(name="idCiudad", referencedColumnName="idCiudad"))
	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	@OneToMany(mappedBy="inmobiliaria")
	public List<Barrio> getBarrios() {
		return barrios;
	}

	public void setBarrios(List<Barrio> barrios) {
		this.barrios = barrios;
	}

	public Inmobiliaria(String cif, String nombre, List<Ciudad> ciudades,
			List<Barrio> barrios, Long idInmobiliaria) {
		super();
		this.cif = cif;
		this.nombre = nombre;
		this.ciudades = ciudades;
		this.barrios = barrios;
		this.id = idInmobiliaria;
	}


}
