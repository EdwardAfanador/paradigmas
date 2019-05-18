package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the arrendador database table.
 * 
 */
@Entity
@NamedQuery(name="Arrendador.findAll", query="SELECT a FROM Arrendador a")
public class Arrendador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ID_Arrendador;

	private String apellido_Arrendador;

	private String nombre_Arrendador;

	private int numero_Arrendador;

	//bi-directional many-to-one association to Estudiante
	@OneToMany(mappedBy="arrendador")
	private List<Estudiante> estudiantes;

	//bi-directional many-to-one association to Vivienda
	@OneToMany(mappedBy="arrendador")
	private List<Vivienda> viviendas;

	public Arrendador() {
	}

	public String getID_Arrendador() {
		return this.ID_Arrendador;
	}

	public void setID_Arrendador(String ID_Arrendador) {
		this.ID_Arrendador = ID_Arrendador;
	}

	public String getApellido_Arrendador() {
		return this.apellido_Arrendador;
	}

	public void setApellido_Arrendador(String apellido_Arrendador) {
		this.apellido_Arrendador = apellido_Arrendador;
	}

	public String getNombre_Arrendador() {
		return this.nombre_Arrendador;
	}

	public void setNombre_Arrendador(String nombre_Arrendador) {
		this.nombre_Arrendador = nombre_Arrendador;
	}

	public int getNumero_Arrendador() {
		return this.numero_Arrendador;
	}

	public void setNumero_Arrendador(int numero_Arrendador) {
		this.numero_Arrendador = numero_Arrendador;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setArrendador(this);

		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setArrendador(null);

		return estudiante;
	}

	public List<Vivienda> getViviendas() {
		return this.viviendas;
	}

	public void setViviendas(List<Vivienda> viviendas) {
		this.viviendas = viviendas;
	}

	public Vivienda addVivienda(Vivienda vivienda) {
		getViviendas().add(vivienda);
		vivienda.setArrendador(this);

		return vivienda;
	}

	public Vivienda removeVivienda(Vivienda vivienda) {
		getViviendas().remove(vivienda);
		vivienda.setArrendador(null);

		return vivienda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID_Arrendador == null) ? 0 : ID_Arrendador.hashCode());
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
		Arrendador other = (Arrendador) obj;
		if (ID_Arrendador == null) {
			if (other.ID_Arrendador != null)
				return false;
		} else if (!ID_Arrendador.equals(other.ID_Arrendador))
			return false;
		return true;
	}

	
	
}