package repository.adapter.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import repository.adapter.entity.ClienteEntity;

public interface ClientesJpaRepository extends JpaRepository<ClienteEntity,Integer>{

}
