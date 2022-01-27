package repository.adapter.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Cliente;
import repository.adapter.entity.ClienteEntity;
import repository.adapter.entity.Utilidades;
import repository.port.ClientesRepository;

@Repository
public class ClientesRepositorySpringDataJpaImpl implements ClientesRepository {

	@Autowired
	ClientesJpaRepository repository;
	
	@Override
	public void saveClient(Cliente cliente) {
		repository.saveAndFlush(Utilidades.convertToClienteEntity(cliente));
	}

	@Override
	public Cliente findByDni(int dni) {
     ClienteEntity entity=repository.findById(dni).orElse(null);
     if(entity!=null) {
    	 return Utilidades.convertToCliente(entity);
     }
		return null;
	}

	@Override
	public void updateClient(Cliente cliente) {
        repository.saveAndFlush(Utilidades.convertToClienteEntity(cliente));
	}

	@Override
	public void deleteByDni(int dni) {
      ClienteEntity entity=repository.findById(dni).orElse(null);
      if(entity!=null) {
    	  repository.delete(entity);
      }
	}

}
