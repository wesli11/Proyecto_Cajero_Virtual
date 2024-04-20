package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Cliente;
import repository.port.ClientesRepository;
import service.port.ClientesService;

@Service
public class ClientesServiceImpl implements ClientesService {

	@Autowired
	ClientesRepository repository;
	
	@Override
	public void altaCliente(Cliente cliente) {
		if(repository.findByDni(cliente.getDni())==null) {
			repository.saveClient(cliente);

                  //MUJAJA
		}
      
	}

	@Override
	public Cliente buscarPorDni(int dni) {
		if( repository.findByDni(dni)!=null) {
			return repository.findByDni(dni);
		}
		return null;
	}

	@Override
	public void actualizarCliente(Cliente cliente) {
		repository.updateClient(cliente);
	}

	@Override
	public void borrarPorDni(int dni) {
       if(repository.findByDni(dni)!=null) {
    	   repository.deleteByDni(dni);
       }

	}

}
