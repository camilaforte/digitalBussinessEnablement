package br.com.fiap.ads.dbe.aula03;

public class teste {


	public static void main(String[] args) {
		//recupera informa��o do arquivo .properties
		String b = PropertySingleton.getInstance().getProperty("banco");
		System.out.println(b);
	}
}
