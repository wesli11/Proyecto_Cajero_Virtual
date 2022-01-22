package service.port;

import model.Cliente;

public interface ClientesService {

	public void altaCliente(Cliente cliente);
	public Cliente buscarPorDni(int dni);
	public void actualizarCliente(Cliente cliente);
	public void borrarPorDni(int dni);
}
