package br.com.fiap.ads.dbe.view;

import java.util.List;

import br.com.fiap.ads.dbe.service.PacienteService;
import br.com.fiap.ads.dbe.to.Paciente;

public class ListaView {

	public static void main(String[] args) {

		PacienteService service = new PacienteService();
		List<Paciente> lista;

		try {
			lista = service.listar();
			for (Paciente paciente : lista) {
				System.out.println(paciente.getNome());
				System.out.println(paciente.getCodigo());
				System.out.println(paciente.getDataNascimento());
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
