package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the eventos database table.
 * 
 */
@Entity
@Table(name="eventos")
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ID_Eventos;

	private String descripcion_Eventos;

	private String fecha_Eventos;

	private String hora_Eventos;

	private String ubicacion_Eventos;

	//bi-directional many-to-many association to Estudiante
	@ManyToMany
	@JoinTable(
		name="eventos_has_estudiante"
		, joinColumns={
			@JoinColumn(name="Eventos_ID_Eventos")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Estudiante_ID_Estudiante")
			}
		)
	private List<Estudiante> estudiantes;

	public Evento() {
	}

	public String getID_Eventos() {
		return this.ID_Eventos;
	}

	public void setID_Eventos(String ID_Eventos) {
		this.ID_Eventos = ID_Eventos;
	}

	public String getDescripcion_Eventos() {
		return this.descripcion_Eventos;
	}

	public void setDescripcion_Eventos(String descripcion_Eventos) {
		this.descripcion_Eventos = descripcion_Eventos;
	}

	public String getFecha_Eventos() {
		return this.fecha_Eventos;
	}

	public void setFecha_Eventos(String fecha_Eventos) {
		this.fecha_Eventos = fecha_Eventos;
	}

	public String getHora_Eventos() {
		return this.hora_Eventos;
	}

	public void setHora_Eventos(String hora_Eventos) {
		this.hora_Eventos = hora_Eventos;
	}

	public String getUbicacion_Eventos() {
		return this.ubicacion_Eventos;
	}

	public void setUbicacion_Eventos(String ubicacion_Eventos) {
		this.ubicacion_Eventos = ubicacion_Eventos;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID_Eventos == null) ? 0 : ID_Eventos.hashCode());
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
		Evento other = (Evento) obj;
		if (ID_Eventos == null) {
			if (other.ID_Eventos != null)
				return false;
		} else if (!ID_Eventos.equals(other.ID_Eventos))
			return false;
		return true;
	}
	
	

}