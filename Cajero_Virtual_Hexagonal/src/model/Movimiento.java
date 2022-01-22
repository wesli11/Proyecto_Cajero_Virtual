package model;

import java.util.Date;
import java.util.List;

public class Movimiento {
	
	private int idMovimniento;
	private Date fecha;
	private double cantidad;
	private String operacion;
	private Cuenta cuenta;
	
	public Movimiento() {}

	public Movimiento(int idMovimniento, Date fecha, double cantidad, String operacion) {
		super();
		this.idMovimniento = idMovimniento;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.operacion = operacion;
	}

	public int getIdMovimniento() {
		return idMovimniento;
	}

	public void setIdMovimniento(int idMovimniento) {
		this.idMovimniento = idMovimniento;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	
	
	
	

}
