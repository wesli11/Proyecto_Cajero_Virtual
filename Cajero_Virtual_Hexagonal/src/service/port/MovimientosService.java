package service.port;

import java.util.List;

import model.Movimiento;

public interface MovimientosService {


	public void altaMovimiento(Movimiento movimiento);
    public List<Movimiento> listaCuentas(int numeroCuenta);
    public List<Movimiento> consultaMovimientoPorFecha(String f1,String f2);
}
