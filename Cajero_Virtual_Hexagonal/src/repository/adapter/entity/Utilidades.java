package repository.adapter.entity;

import model.Cliente;
import model.Cuenta;
import model.Movimiento;

public class Utilidades {
	
	public static Cliente convertToCliente(ClienteEntity entity) {
		return new Cliente(entity.getDni(),
				           entity.getNombre(),
				           entity.getDireccion(),
				           entity.getTelefono());
	}

	public static ClienteEntity convertToClienteEntity(Cliente cliente) {
		ClienteEntity entity=new ClienteEntity();
		entity.setDni(cliente.getDni());
		entity.setNombre(cliente.getNombre());
		entity.setDireccion(cliente.getDireccion());
		entity.setTelefono(entity.getTelefono());
		return entity;
	}
	
	public static Cuenta convertToCuenta(CuentaEntity entity) {
		return new Cuenta(entity.getNumeroCuenta(),
				          entity.getSaldo(),
				          entity.getTipocuenta());
		// posible impl de clientes
	}
	
	public static CuentaEntity convertToCuentaEntity(Cuenta cuenta) {
		CuentaEntity entity=new CuentaEntity();
		  entity.setNumeroCuenta(cuenta.getNumeroCuenta());
		  entity.setSaldo(cuenta.getSaldo());
		  entity.setTipocuenta(cuenta.getTipoCuenta());
		  return entity;
	}
	
	public static Movimiento convertToMovimiento(MovimientoEntity entity) {
		return new Movimiento(entity.getIdMovimiento(),
				              entity.getFecha(),
				              entity.getCantidad(),
				              entity.getOperacion());
		
	}
	
	public static MovimientoEntity convertToMovimientoEntity(Movimiento movimiento) {
		MovimientoEntity entity=new MovimientoEntity();
		  entity.setIdMovimiento(movimiento.getIdMovimniento());
		  entity.setCantidad(movimiento.getCantidad());
		  entity.setFecha(movimiento.getFecha());
		  entity.setOperacion(movimiento.getOperacion());
		  return entity;
	}
}
