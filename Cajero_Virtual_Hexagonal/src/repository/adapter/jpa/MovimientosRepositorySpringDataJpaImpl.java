package repository.adapter.jpa;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Movimiento;
import repository.adapter.entity.MovimientoEntity;
import repository.adapter.entity.Utilidades;
import repository.port.MovimientosRepository;

@Repository
public class MovimientosRepositorySpringDataJpaImpl implements MovimientosRepository {

	@Autowired
	MovimientoJpaRepository repository;
	@Override
	public void saveMovimiento(Movimiento movimiento) {
       repository.saveAndFlush(Utilidades.convertToMovimientoEntity(movimiento));
	}

	@Override
	public List<Movimiento> listOfAccount(int numeroCuenta) {
		List<MovimientoEntity> entities=repository.findByNumeroCuenta(numeroCuenta);
		return entities
				   .stream()
				      .map(m->Utilidades.convertToMovimiento(m))
				        .collect(Collectors.toList());
	}

	@Override
	public List<Movimiento> listOfMovementsByFecha(Date f1, Date f2) {
		List<MovimientoEntity>entities= repository.findByListMovements(f1, f2);
	    return entities
	    		 .stream()
	    		    .map(m->Utilidades.convertToMovimiento(m))
	    		      .collect(Collectors.toList());
	}

}
