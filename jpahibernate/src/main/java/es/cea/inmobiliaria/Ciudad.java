package es.cea.inmobiliaria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Ciudad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -152093378927720704L;
	private String codigo;
	private List<Inmobiliaria> inmobiliarias;
	private List<Barrio> barrios;
	private Long idCiudad;
	
	public Ciudad(String codigo, List<Inmobiliaria> inmobiliarias,
			List<Barrio> barrios, Long idCiudad) {
		super();
		this.codigo = codigo;
		this.inmobiliarias = inmobiliarias;
		this.barrios = barrios;
		this.idCiudad = idCiudad;
	}
	public Ciudad(){
		this.codigo = "";
		this.inmobiliarias = new ArrayList<Inmobiliaria>();
		this.barrios= new ArrayList<Barrio>();
		this.idCiudad = 0L;
	}

	@Id
	@GeneratedValue
	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}

	@ManyToMany
	@JoinTable(name="CIUDADES_INMOBILIARIAS", 
			joinColumns=
		    @JoinColumn(name="idCiudad", referencedColumnName="idCiudad"),
		    inverseJoinColumns=
		    @JoinColumn(name="idInmobiliaria", referencedColumnName="idInmobiliaria"))
	public List<Inmobiliaria> getInmobiliarias() {
		return inmobiliarias;
	}

	public void setInmobiliarias(List<Inmobiliaria> inmobiliarias) {
		this.inmobiliarias = inmobiliarias;
	}

	public String getCodigo() {
		return codigo;
	}

	@OneToMany(mappedBy="ciudad")
	public List<Barrio> getBarrios() {
		return barrios;
	}

	public void setBarrios(List<Barrio> barrios) {
		this.barrios = barrios;
	}

	

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idCiudad ^ (idCiudad >>> 32));
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
		Ciudad other = (Ciudad) obj;
		if (idCiudad != other.idCiudad)
			return false;
		return true;
	}

	

}
