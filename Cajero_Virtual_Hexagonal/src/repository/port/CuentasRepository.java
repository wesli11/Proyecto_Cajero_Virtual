package repository.port;

import java.util.List;

import model.Cuenta;

public interface CuentasRepository {

	public void saveAccount(Cuenta cuenta);
	public Cuenta findByNumeroCuenta(int numeroCuenta);
	public List<Cuenta> allAccounts();
	public void updateAccount(Cuenta cuenta);
	public void deleteByNumeroCuenta(int numeroCuenta);
	
}
