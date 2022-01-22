package service.port;

import java.util.List;

import model.Cuenta;

public interface CuentasService {


	public void altaCuenta(Cuenta cuenta);
	public Cuenta buscarPorNumeroCuenta(int numeroCuenta);
	public List<Cuenta> listaCuentas();
	public void actualizarCuenta(Cuenta cuenta);
	public void borrarPorNumeroCuenta(int numeroCuenta);
	
}
