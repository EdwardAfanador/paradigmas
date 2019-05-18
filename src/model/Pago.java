package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pagos database table.
 * 
 */
@Entity
@Table(name="pagos")
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ID_Pagos;

	private double cantidad;

	private String fecha_Pagos;

	private int tarjeta_Credito;

	//bi-directional many-to-one association to Banco
	@ManyToOne
	@JoinColumn(name="FK_ID_Banco")
	private Banco banco;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	@JoinColumn(name="FK_ID_Estudiante")
	private Estudiante estudiante;

	public Pago() {
	}

	public String getID_Pagos() {
		return this.ID_Pagos;
	}

	public void setID_Pagos(String ID_Pagos) {
		this.ID_Pagos = ID_Pagos;
	}

	public double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getFecha_Pagos() {
		return this.fecha_Pagos;
	}

	public void setFecha_Pagos(String fecha_Pagos) {
		this.fecha_Pagos = fecha_Pagos;
	}

	public int getTarjeta_Credito() {
		return this.tarjeta_Credito;
	}

	public void setTarjeta_Credito(int tarjeta_Credito) {
		this.tarjeta_Credito = tarjeta_Credito;
	}

	public Banco getBanco() {
		return this.banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID_Pagos == null) ? 0 : ID_Pagos.hashCode());
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
		Pago other = (Pago) obj;
		if (ID_Pagos == null) {
			if (other.ID_Pagos != null)
				return false;
		} else if (!ID_Pagos.equals(other.ID_Pagos))
			return false;
		return true;
	}
	
	

}