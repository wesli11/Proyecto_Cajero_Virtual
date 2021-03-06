package repository.adapter.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the movimientos database table.
 * 
 */
@Entity
@Table(name="movimientos")
@NamedQuery(name="MovimientoEntity.findAll", query="SELECT m FROM MovimientoEntity m")
public class MovimientoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMovimiento;

	private double cantidad;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private String operacion;

	//bi-directional many-to-one association to CuentaEntity
	@ManyToOne
	@JoinColumn(name="idCuenta",referencedColumnName="numeroCuenta")
	private CuentaEntity cuenta;

	public MovimientoEntity() {
	}

	public int getIdMovimiento() {
		return this.idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getOperacion() {
		return this.operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public CuentaEntity getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(CuentaEntity cuenta) {
		this.cuenta = cuenta;
	}

}