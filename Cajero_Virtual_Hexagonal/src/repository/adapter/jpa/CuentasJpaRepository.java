package repository.adapter.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import repository.adapter.entity.CuentaEntity;

public interface CuentasJpaRepository extends JpaRepository<CuentaEntity, Integer> {

	@Query("Select c from CuentaEntity c join fetch c.clientes where c Not in ("
			+ "Select c from CuentaEntity c join c.clientes a where a.dni=?1")
	public List<CuentaEntity> listAccountNotClient(int dni);
}
