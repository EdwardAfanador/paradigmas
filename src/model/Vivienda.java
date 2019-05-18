package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vivienda database table.
 * 
 */
@Entity
@NamedQuery(name="Vivienda.findAll", query="SELECT v FROM Vivienda v")
public class Vivienda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ID_Vivienda;

	private double costo_Vivienda;

	private String descripcion_Vivienda;

	private String direccion_Vivienda;

	private String tipo_Vivienda;

	

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="vivienda")
	private List<Comentario> comentarios;

	//bi-directional many-to-one association to Arrendador
	@ManyToOne
	@JoinColumn(name="FK_ID_Arrendador")
	private Arrendador arrendador;

	public Vivienda() {
	}

	public String getID_Vivienda() {
		return this.ID_Vivienda;
	}

	public void setID_Vivienda(String ID_Vivienda) {
		this.ID_Vivienda = ID_Vivienda;
	}

	public double getCosto_Vivienda() {
		return this.costo_Vivienda;
	}

	public void setCosto_Vivienda(double costo_Vivienda) {
		this.costo_Vivienda = costo_Vivienda;
	}

	public String getDescripcion_Vivienda() {
		return this.descripcion_Vivienda;
	}

	public void setDescripcion_Vivienda(String descripcion_Vivienda) {
		this.descripcion_Vivienda = descripcion_Vivienda;
	}

	public String getDireccion_Vivienda() {
		return this.direccion_Vivienda;
	}

	public void setDireccion_Vivienda(String direccion_Vivienda) {
		this.direccion_Vivienda = direccion_Vivienda;
	}

	public String getTipo_Vivienda() {
		return this.tipo_Vivienda;
	}

	public void setTipo_Vivienda(String tipo_Vivienda) {
		this.tipo_Vivienda = tipo_Vivienda;
	}


	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Comentario addComentario(Comentario comentario) {
		getComentarios().add(comentario);
		comentario.setVivienda(this);

		return comentario;
	}

	public Comentario removeComentario(Comentario comentario) {
		getComentarios().remove(comentario);
		comentario.setVivienda(null);

		return comentario;
	}

	public Arrendador getArrendador() {
		return this.arrendador;
	}

	public void setArrendador(Arrendador arrendador) {
		this.arrendador = arrendador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID_Vivienda == null) ? 0 : ID_Vivienda.hashCode());
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
		Vivienda other = (Vivienda) obj;
		if (ID_Vivienda == null) {
			if (other.ID_Vivienda != null)
				return false;
		} else if (!ID_Vivienda.equals(other.ID_Vivienda))
			return false;
		return true;
	}

	
	
}