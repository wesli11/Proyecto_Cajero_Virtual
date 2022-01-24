package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Movimiento;
import repository.port.CuentasRepository;
import repository.port.MovimientosRepository;
import service.port.MovimientosService;

@Service
public class MovimientosServiceImpl implements MovimientosService {
	@Autowired
	MovimientosRepository mrepository;
	
	@Autowired
	CuentasRepository repository;

	@Override
	public void altaMovimiento(Movimiento movimiento) {
		mrepository.saveMovimiento(movimiento);
	}

	@Override
	public List<Movimiento> listaCuentas(int numeroCuenta) {
       if(repository.findByNumeroCuenta(numeroCuenta)!=null) {
    	   return mrepository.listOfAccount(numeroCuenta);
       }
		return null;
	}

	@Override
	public List<Movimiento> consultaMovimientoPorFecha(String f1, String f2) {
     try {
	   Date fechaIni=(new SimpleDateFormat()).parse(f1);
       Date fechaFin=(new SimpleDateFormat()).parse(f2);
      if(fechaIni.before(fechaFin)) {
    	  return mrepository.listOfMovementsByFecha(fechaIni, fechaFin);
      }
     }catch(ParseException e) {
    	 e.printStackTrace();
     }
		return null;
	}


}
