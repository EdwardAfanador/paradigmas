package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comentarios database table.
 * 
 */
@Entity
@Table(name="comentarios")
@NamedQuery(name="Comentario.findAll", query="SELECT c FROM Comentario c")
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ID_Comentarios;

	private double calificacion_Vivienda;

	private String descripcion_Comentarios;

	private String estudiante_Comentarios;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	@JoinColumn(name="FK_ID_Estudiante")
	private Estudiante estudiante;

	//bi-directional many-to-one association to Vivienda
	@ManyToOne
	@JoinColumn(name="FK_ID_Vivienda")
	private Vivienda vivienda;

	public Comentario() {
	}

	public String getID_Comentarios() {
		return this.ID_Comentarios;
	}

	public void setID_Comentarios(String ID_Comentarios) {
		this.ID_Comentarios = ID_Comentarios;
	}

	public double getCalificacion_Vivienda() {
		return this.calificacion_Vivienda;
	}

	public void setCalificacion_Vivienda(double calificacion_Vivienda) {
		this.calificacion_Vivienda = calificacion_Vivienda;
	}

	public String getDescripcion_Comentarios() {
		return this.descripcion_Comentarios;
	}

	public void setDescripcion_Comentarios(String descripcion_Comentarios) {
		this.descripcion_Comentarios = descripcion_Comentarios;
	}

	public String getEstudiante_Comentarios() {
		return this.estudiante_Comentarios;
	}

	public void setEstudiante_Comentarios(String estudiante_Comentarios) {
		this.estudiante_Comentarios = estudiante_Comentarios;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Vivienda getVivienda() {
		return this.vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID_Comentarios == null) ? 0 : ID_Comentarios.hashCode());
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
		Comentario other = (Comentario) obj;
		if (ID_Comentarios == null) {
			if (other.ID_Comentarios != null)
				return false;
		} else if (!ID_Comentarios.equals(other.ID_Comentarios))
			return false;
		return true;
	}
	
	

}