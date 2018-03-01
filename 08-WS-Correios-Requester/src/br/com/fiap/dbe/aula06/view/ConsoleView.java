package br.com.fiap.dbe.aula06.view;

import java.rmi.RemoteException;
import java.util.Scanner;

import org.apache.axis2.AxisFault;

import br.com.fiap.dbe.aula06.bo.CalcPrecoPrazoWSStub;
import br.com.fiap.dbe.aula06.bo.CalcPrecoPrazoWSStub.CalcPrazo;
import br.com.fiap.dbe.aula06.bo.CalcPrecoPrazoWSStub.CalcPrazoResponse;
import br.com.fiap.dbe.aula06.bo.CalcPrecoPrazoWSStub.CalcPrecoPrazo;

public class ConsoleView {

	public static void main(String[] args) throws RemoteException, AxisFault {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Digite teu CEP:");
		String cep = scn.next() + scn.nextLine();
		System.out.println("Digite o CEP de destino");
		String cepDest = scn.next() + scn.nextLine();
		scn.close();
		
		String codServico = "4014";
		
		CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
		
		CalcPrazo calc = new CalcPrazo();
		calc.setNCdServico(codServico);
		calc.setSCepOrigem(cep);
		calc.setSCepDestino(cepDest);
		
		CalcPrazoResponse resp = stub.calcPrazo(calc);
		
		System.out.println(resp.getCalcPrazoResult().getServicos().getCServico()[0].getDataMaxEntrega());
		
	}
}
