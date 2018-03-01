package br.com.fiap.dbe.aula06.bo;

public class NotaBO {

	public float calcMedia (float nac, float am, float ps) {
		return (nac*0.2f) + (am*0.3f) + (ps*0.5f);
	}
	
	public float calcPs (float nac, float am) {
		return (6-(nac*0.2f + am*0.3f))*2;
	}
	

}

