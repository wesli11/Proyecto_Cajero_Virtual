package repository.adapter.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Movimiento;
import repository.adapter.entity.MovimientoEntity;

public interface MovimientoJpaRepository extends JpaRepository<MovimientoEntity, Integer> {

	public List<MovimientoEntity> findByNumeroCuenta(int numeroCuenta);

	@Query("Select m from MovimientoEntity m where m.fecha> between ?1 and ?2")
	public List<MovimientoEntity> findByListMovements(Date f1, Date f2);

}