package br.com.fiap.ads.dbe.aula05.repository;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import br.com.fiap.dbe.aula06.bo.NotaBOStub;
import br.com.fiap.dbe.aula06.bo.NotaBOStub.CalcPs;
import br.com.fiap.dbe.aula06.bo.NotaBOStub.CalcPsResponse;

//para acessar web service
public class NotaRepository {

	private NotaBOStub stub;
	
	public NotaRepository() throws AxisFault {
		
		stub = new NotaBOStub();
	}
	
	public float calcularPs(float am, float nac) throws RemoteException {
		
		
		CalcPs arg = new CalcPs();
		
			arg.setAm(am);
			arg.setNac(nac);
		
		CalcPsResponse resultado = stub.calcPs(arg);
		
		return resultado.get_return();
	}
}
