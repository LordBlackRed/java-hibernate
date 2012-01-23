package es.cea.chat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7689616854726618889L;
	private String nombre;
	private String nick;
	private String mail;
	private String clave;
	private List<Mensaje> mensajes;
	private Color color;
	private Long id;
	
	public Usuario(){
		this.nombre="";
		this.nick="";
		this.mail="";
		this.clave="";
		this.mensajes=new ArrayList<Mensaje>();
		this.color=null;
		this.id=0L;
	}
	public Usuario(String nombre, String nick, String mail, String clave,
			List<Mensaje> mensajes, Color color, Long id) {
		super();
		this.nombre = nombre;
		this.nick = nick;
		this.mail = mail;
		this.clave = clave;
		this.mensajes = mensajes;
		this.color = color;
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	@OneToMany(mappedBy="usuario")
	public List<Mensaje> getMensajes() {
		return mensajes;
	}
	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
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
		Usuario other = (Usuario) obj;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		return true;
	}
	
	
}
