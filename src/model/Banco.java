package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the banco database table.
 * 
 */
@Entity
@NamedQuery(name="Banco.findAll", query="SELECT b FROM Banco b")
public class Banco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ID_Banco;

	private String nombre_Banco;

	private int telefono_Banco;

	private String url_Banco;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="banco")
	private List<Pago> pagos;

	public Banco() {
	}

	public String getID_Banco() {
		return this.ID_Banco;
	}

	public void setID_Banco(String ID_Banco) {
		this.ID_Banco = ID_Banco;
	}

	public String getNombre_Banco() {
		return this.nombre_Banco;
	}

	public void setNombre_Banco(String nombre_Banco) {
		this.nombre_Banco = nombre_Banco;
	}

	public int getTelefono_Banco() {
		return this.telefono_Banco;
	}

	public void setTelefono_Banco(int telefono_Banco) {
		this.telefono_Banco = telefono_Banco;
	}

	public String getUrl_Banco() {
		return this.url_Banco;
	}

	public void setUrl_Banco(String url_Banco) {
		this.url_Banco = url_Banco;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Pago addPago(Pago pago) {
		getPagos().add(pago);
		pago.setBanco(this);

		return pago;
	}

	public Pago removePago(Pago pago) {
		getPagos().remove(pago);
		pago.setBanco(null);

		return pago;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID_Banco == null) ? 0 : ID_Banco.hashCode());
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
		Banco other = (Banco) obj;
		if (ID_Banco == null) {
			if (other.ID_Banco != null)
				return false;
		} else if (!ID_Banco.equals(other.ID_Banco))
			return false;
		return true;
	}
	
	

}