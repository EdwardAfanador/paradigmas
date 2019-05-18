package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the login database table.
 * 
 */
@Entity
@NamedQuery(name="Login.findAll", query="SELECT l FROM Login l")
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String contraseña;

	private String ID_Arrendador;

	private String ID_Estudiante;

	private String tipo_Usuario;

	
	@Id
	private String usuario;

	public Login() {
	}

	public String getContraseña() {
		return this.contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getID_Arrendador() {
		return this.ID_Arrendador;
	}

	public void setID_Arrendador(String ID_Arrendador) {
		this.ID_Arrendador = ID_Arrendador;
	}

	public String getID_Estudiante() {
		return this.ID_Estudiante;
	}

	public void setID_Estudiante(String ID_Estudiante) {
		this.ID_Estudiante = ID_Estudiante;
	}

	public String getTipo_Usuario() {
		return this.tipo_Usuario;
	}

	public void setTipo_Usuario(String tipo_Usuario) {
		this.tipo_Usuario = tipo_Usuario;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Login other = (Login) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	
	
	

}