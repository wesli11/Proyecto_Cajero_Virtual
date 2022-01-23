package service.port;

import java.util.List;

import model.Cuenta;

public interface CuentasService {


	public void altaCuenta(Cuenta cuenta);
	public Cuenta buscarPorNumeroCuenta(int numeroCuenta);
	public List<Cuenta> listaCuentas();
	public void actualizarCuenta(Cuenta cuenta);
	public void borrarPorNumeroCuenta(int numeroCuenta);
	public List<Cuenta> cuentasDisponibles(int dni);
	//metodos esenciales del service
	public void ingresar(int numCuenta, double cantidad);
	public void extraer(int numCuenta,  double cantidad);
	public void transferir(int cuentaOrigen, int cuentaDestino, double cantidad);
	public double saldo(int numCuenta);
	
}
