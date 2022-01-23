package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Cuenta;
import repository.port.CuentasRepository;
import service.port.CuentasService;
@Service
public class CuentasServiceImpl implements CuentasService {

	@Autowired
	CuentasRepository repository;
	
	@Override
	public void altaCuenta(Cuenta cuenta) {
      if(repository.findByNumeroCuenta(cuenta.getNumeroCuenta())==null) {
    	  repository.saveAccount(cuenta);
      }
	}

	@Override
	public Cuenta buscarPorNumeroCuenta(int numeroCuenta) {
        if(repository.findByNumeroCuenta(numeroCuenta)!=null) {
        	return repository.findByNumeroCuenta(numeroCuenta);
        }
		return null;
	}

	@Override
	public List<Cuenta> listaCuentas() {
		return repository.allAccounts();
	}

	@Override
	public void actualizarCuenta(Cuenta cuenta) {
	   if(repository.findByNumeroCuenta(cuenta.getNumeroCuenta())!=null) {
         repository.updateAccount(cuenta);
	}
	}

	@Override
	public void borrarPorNumeroCuenta(int numeroCuenta) {
	   if(repository.findByNumeroCuenta(numeroCuenta)!=null) {
		   repository.deleteByNumeroCuenta(numeroCuenta);
	}
	}

	@Override
	public void ingresar(int numCuenta, double cantidad) {
       Cuenta cuenta=repository.findByNumeroCuenta(numCuenta);
       if(cuenta!=null) {
    	   cuenta.setSaldo(cuenta.getSaldo()+cantidad);
    	   repository.updateAccount(cuenta); 
       }
	}

	@Override
	public void extraer(int numCuenta, double cantidad) {
		 Cuenta cuenta=repository.findByNumeroCuenta(numCuenta);
	       if(cuenta!=null && cuenta.getSaldo()>=cantidad) {
	    	   cuenta.setSaldo(cuenta.getSaldo()-cantidad);
	    	   repository.updateAccount(cuenta); 
	       }
	}

	@Override
	public void transferir(int cuentaOrigen, int cuentaDestino, double cantidad) {
        this.extraer(cuentaOrigen, cantidad);	
        this.ingresar(cuentaDestino, cantidad);
	}

	@Override
	public double saldo(int numCuenta) {
	   Cuenta cuenta=repository.findByNumeroCuenta(numCuenta);
	   if(cuenta!=null) {
		   return cuenta.getSaldo();
	   }
		return 0;
	}
}
