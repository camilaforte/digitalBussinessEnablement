package br.com.fiap.dbe.aula06.view;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import br.com.fiap.dbe.aula06.bo.NotaBOStub;
import br.com.fiap.dbe.aula06.bo.NotaBOStub.CalcMedia;
import br.com.fiap.dbe.aula06.bo.NotaBOStub.CalcMediaResponse;

public class ConsoleView {

	public static void main(String[] args) throws RemoteException, AxisFault {
		
		NotaBOStub stub = new NotaBOStub();

		//parametros para enviar ao web service
		//uso o nome da classe
		CalcMedia parametros = new CalcMedia();
		parametros.setAm(10);
		parametros.setNac(8);
		parametros.setPs(7);
		
		//chama o web service
		CalcMediaResponse resp = stub.calcMedia(parametros);
		
		//exibe o valor calculado no web service
		System.out.println(resp.get_return());
		
	}
}
