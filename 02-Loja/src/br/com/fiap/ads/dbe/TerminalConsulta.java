package br.com.fiap.ads.dbe;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.fiap.ads.dbe.bean.ProdutoTO;

public class TerminalConsulta {

	private static final Logger log = LoggerFactory.getLogger(TerminalConsulta.class);
	
	public static void main(String[] args) {
		log.info("Inicializando um sistema.");
		Scanner scn = new Scanner(System.in);

		int opcao;
		EstoqueBO bo = new EstoqueBO();

		do {
			// pegar data sistema
			Calendar calendar = Calendar.getInstance();
			// formatar data
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy  HH:mm");
			DecimalFormat df = new DecimalFormat("R$ #,###.00");
			
			
			
			System.out.println("FIAP              " + sdf.format(calendar.getTime()));
			System.out.println("*********************************");

			System.out.println("[1] ->  Pesquisar");
			System.out.println("[0] -> Sair");
			opcao = scn.nextInt();
			if (opcao == 1) {

				System.out.println("Código do produto: ");
				int codigo = scn.nextInt();
				ProdutoTO prod = bo.consultarProduto(codigo);
				if (prod == null) {
					System.out.println("Produto não cadastrado!");
				log.warn("Produto não encontrado");
				} else {
					System.out.println(prod.getNome());
					System.out.println(prod.getCodigo());
					System.out.println(df.format(prod.getPreco()));
				}
			}
			log.info("Saindo da aplicação");
		} while (opcao != 0);
		scn.close();
	}

}
