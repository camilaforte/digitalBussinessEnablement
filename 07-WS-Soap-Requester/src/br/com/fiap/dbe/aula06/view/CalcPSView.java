package br.com.fiap.dbe.aula06.view;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import br.com.fiap.dbe.aula06.bo.NotaBOStub;
import br.com.fiap.dbe.aula06.bo.NotaBOStub.CalcPs;
import br.com.fiap.dbe.aula06.bo.NotaBOStub.CalcPsResponse;

public class CalcPSView {

	public static void main(String[] args) throws RemoteException, AxisFault {
		
		
		NotaBOStub stub = new NotaBOStub();
		
		CalcPs parametros = new CalcPs();
		parametros.setAm(7);
		parametros.setNac(6);
		
		
		CalcPsResponse notaPS = stub.calcPs(parametros);
		
		System.out.println(notaPS.get_return());
		
	}
}
