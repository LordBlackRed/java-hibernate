package libreria;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity()
public class Autor {
	
	Long id;
	String nombre;
	List<Libro> libros;
	
	
	
	public Autor() {
		super();
	}


	@Id()
	@GeneratedValue(strategy=GenerationType.TABLE)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@ManyToMany
	@JoinTable(name="LIBROS_AUTORES", 
			joinColumns=
		    @JoinColumn(name="autor_id", referencedColumnName="id"),
		    inverseJoinColumns=
		    @JoinColumn(name="libro_id", referencedColumnName="id"))
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	
}
