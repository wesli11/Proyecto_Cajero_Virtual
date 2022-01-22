package repository.port;

import model.Cliente;

public interface ClienteRepository {
	
	public void saveClient(Cliente cliente);
	public Cliente findByDni(int dni);
	public void updateClient(Cliente cliente);
	public void deleteByDni(int dni);

}
