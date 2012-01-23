package es.cea.inmobiliaria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Barrio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9059511315088004983L;
	private String nombre;
	private Long id;
	private Inmobiliaria inmobiliaria;
	private Ciudad ciudad;
	private List<Casa> casas;
	
	public Barrio(){
		this.nombre = "";
		this.id = 0L;
		this.inmobiliaria = null;
		this.ciudad = null;
		this.casas = new ArrayList<Casa>();
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
		Barrio other = (Barrio) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public Barrio(String nombre, Long idBarrio, Inmobiliaria inmobiliaria,
			Ciudad ciudad, List<Casa> casas) {
		super();
		this.nombre = nombre;
		this.id = idBarrio;
		this.inmobiliaria = inmobiliaria;
		this.ciudad = ciudad;
		this.casas = casas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Id
	@GeneratedValue
	public Long getIdBarrio() {
		return id;
	}
	public void setIdBarrio(Long idBarrio) {
		this.id = idBarrio;
		
	}@ManyToOne(cascade=CascadeType.ALL)
	public Inmobiliaria getInmobiliaria() {
		return inmobiliaria;
	}
	public void setInmobiliaria(Inmobiliaria inmobiliaria) {
		this.inmobiliaria = inmobiliaria;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	@OneToMany(mappedBy="barrio")
	public List<Casa> getCasas() {
		return casas;
	}
	public void setCasas(List<Casa> casas) {
		this.casas = casas;
	}

}
