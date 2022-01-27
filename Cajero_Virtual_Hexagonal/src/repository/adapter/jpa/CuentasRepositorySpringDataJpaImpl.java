package repository.adapter.jpa;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import model.Cuenta;
import repository.adapter.entity.CuentaEntity;
import repository.adapter.entity.Utilidades;
import repository.port.CuentasRepository;

public class CuentasRepositorySpringDataJpaImpl implements CuentasRepository {

	@Autowired
	CuentasJpaRepository repository;
	
	@Override
	public void saveAccount(Cuenta cuenta) {
		repository.saveAndFlush(Utilidades.convertToCuentaEntity(cuenta));
	  }

	@Override
	public Cuenta findByNumeroCuenta(int numeroCuenta) {
      CuentaEntity entity=repository.findById(numeroCuenta).orElse(null);
        if(entity!=null) {
        	return Utilidades.convertToCuenta(entity);
        }
		return null;
	}

	@Override
	public List<Cuenta> allAccounts() {
       List<CuentaEntity> cuentas=repository.findAll();
		return cuentas
				   .stream()
				     .map(c->Utilidades.convertToCuenta(c))
				        .collect(Collectors.toList());
	}

	@Override
	public void updateAccount(Cuenta cuenta) {
       repository.saveAndFlush(Utilidades.convertToCuentaEntity(cuenta));
	}

	@Override
	public void deleteByNumeroCuenta(int numeroCuenta) {
		CuentaEntity entity=repository.findById(numeroCuenta).orElse(null);
		repository.deleteById(entity.getNumeroCuenta());
	}

	@Override
	public List<Cuenta> accountDisponibility(int dni) {
       	  List<CuentaEntity>entities=repository.listAccountNotClient(dni);
       	  return entities
       			      .stream()
       			         .map(c->Utilidades.convertToCuenta(c))
       			            .collect(Collectors.toList());
	}

}
