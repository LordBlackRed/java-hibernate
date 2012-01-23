package es.cea.chat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Color implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7730202683606117365L;
	private String htmlCode;
	private String nombre;
	private List<Usuario> usuarios;
	private Long id;

	public Color() {
		this.htmlCode = "";
		this.nombre = "";
		this.usuarios = new ArrayList<Usuario>();
		this.id = 0L;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((htmlCode == null) ? 0 : htmlCode.hashCode());
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
		Color other = (Color) obj;
		if (htmlCode == null) {
			if (other.htmlCode != null)
				return false;
		} else if (!htmlCode.equals(other.htmlCode))
			return false;
		return true;
	}

	public String getHtmlCode() {
		return htmlCode;
	}

	public void setHtmlCode(String htmlCode) {
		this.htmlCode = htmlCode;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(mappedBy="color")
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Color(String htmlCode, String nombre, List<Usuario> usuarios, Long id) {
		super();
		this.htmlCode = htmlCode;
		this.nombre = nombre;
		this.usuarios = usuarios;
		this.id = id;
	}
}
