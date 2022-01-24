package repository.adapter.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")
@NamedQuery(name="ClienteEntity.findAll", query="SELECT c FROM ClienteEntity c")
public class ClienteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int dni;

	private String direccion;

	private String nombre;

	private int telefono;

	//bi-directional many-to-many association to CuentaEntity
	@ManyToMany
	@JoinTable(name="titulares",
	 joinColumns=@JoinColumn(name="idCliente",referencedColumnName="dni"),
	 inverseJoinColumns=@JoinColumn(name="idCuenta",referencedColumnName="numeroCuenta"))
	private List<CuentaEntity> cuentas;

	public ClienteEntity() {
	}

	public int getDni() {
		return this.dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public List<CuentaEntity> getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(List<CuentaEntity> cuentas) {
		this.cuentas = cuentas;
	}

}