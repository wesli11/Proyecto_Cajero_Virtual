package repository.port;

import java.util.Date;
import java.util.List;

import model.Movimiento;

public interface MovimientosRepository {
	
	public void saveMovimiento(Movimiento movimiento);
    public List<Movimiento> listOfAccount(int numeroCuenta);
    public List<Movimiento> listOfMovementsByFecha(Date f1,Date f2);
}
