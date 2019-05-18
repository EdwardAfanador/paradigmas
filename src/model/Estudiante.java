package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the estudiante database table.
 * 
 */
@Entity
@NamedQuery(name="Estudiante.findAll", query="SELECT e FROM Estudiante e")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ID_Estudiante;

	private String apellido_Estudiante;

	private int edad_Estudiante;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_Ingreso;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_Salida;

	private String nombre_Estudiante;

	private int numero_Telefono;

	private String pais_Estudiante;

	private String universidad_Estudiante;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="estudiante")
	private List<Comentario> comentarios;

	//bi-directional many-to-one association to Arrendador
	@ManyToOne
	@JoinColumn(name="FK_ID_Arrendador")
	private Arrendador arrendador;

	//bi-directional many-to-many association to Evento
	@ManyToMany(mappedBy="estudiantes")
	private List<Evento> eventos;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="estudiante")
	private List<Pago> pagos;

	public Estudiante() {
	}

	public String getID_Estudiante() {
		return this.ID_Estudiante;
	}

	public void setID_Estudiante(String ID_Estudiante) {
		this.ID_Estudiante = ID_Estudiante;
	}

	public String getApellido_Estudiante() {
		return this.apellido_Estudiante;
	}

	public void setApellido_Estudiante(String apellido_Estudiante) {
		this.apellido_Estudiante = apellido_Estudiante;
	}

	public int getEdad_Estudiante() {
		return this.edad_Estudiante;
	}

	public void setEdad_Estudiante(int edad_Estudiante) {
		this.edad_Estudiante = edad_Estudiante;
	}

	public Date getFecha_Ingreso() {
		return this.fecha_Ingreso;
	}

	public void setFecha_Ingreso(Date fecha_Ingreso) {
		this.fecha_Ingreso = fecha_Ingreso;
	}

	public Date getFecha_Salida() {
		return this.fecha_Salida;
	}

	public void setFecha_Salida(Date fecha_Salida) {
		this.fecha_Salida = fecha_Salida;
	}

	public String getNombre_Estudiante() {
		return this.nombre_Estudiante;
	}

	public void setNombre_Estudiante(String nombre_Estudiante) {
		this.nombre_Estudiante = nombre_Estudiante;
	}

	public int getNumero_Telefono() {
		return this.numero_Telefono;
	}

	public void setNumero_Telefono(int numero_Telefono) {
		this.numero_Telefono = numero_Telefono;
	}

	public String getPais_Estudiante() {
		return this.pais_Estudiante;
	}

	public void setPais_Estudiante(String pais_Estudiante) {
		this.pais_Estudiante = pais_Estudiante;
	}

	public String getUniversidad_Estudiante() {
		return this.universidad_Estudiante;
	}

	public void setUniversidad_Estudiante(String universidad_Estudiante) {
		this.universidad_Estudiante = universidad_Estudiante;
	}

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Comentario addComentario(Comentario comentario) {
		getComentarios().add(comentario);
		comentario.setEstudiante(this);

		return comentario;
	}

	public Comentario removeComentario(Comentario comentario) {
		getComentarios().remove(comentario);
		comentario.setEstudiante(null);

		return comentario;
	}

	public Arrendador getArrendador() {
		return this.arrendador;
	}

	public void setArrendador(Arrendador arrendador) {
		this.arrendador = arrendador;
	}

	public List<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Pago addPago(Pago pago) {
		getPagos().add(pago);
		pago.setEstudiante(this);

		return pago;
	}

	public Pago removePago(Pago pago) {
		getPagos().remove(pago);
		pago.setEstudiante(null);

		return pago;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID_Estudiante == null) ? 0 : ID_Estudiante.hashCode());
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
		Estudiante other = (Estudiante) obj;
		if (ID_Estudiante == null) {
			if (other.ID_Estudiante != null)
				return false;
		} else if (!ID_Estudiante.equals(other.ID_Estudiante))
			return false;
		return true;
	}
	
	

}