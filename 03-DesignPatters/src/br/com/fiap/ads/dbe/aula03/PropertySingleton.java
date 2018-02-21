package br.com.fiap.ads.dbe.aula03;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertySingleton {

	//para criar o log
	private static final Logger log = LoggerFactory.getLogger(PropertySingleton.class);

	// 1° - atributo estatico que mantem a unica instancia
	private static Properties prop;

	// 3° - crio um construtor privado
	private PropertySingleton() {
	}

	// 2° - metodo estatico getInstance que retorna a unica instancia
	public static Properties getInstance() {
		// caso não tenho sido criado, criara
		if (prop == null) {
			log.trace("Criando o objeto properties");											//criando log
			prop = new Properties();
			// carregar arquivo com as propriedade
			try {
				log.info("Carregando o arquivo de propriedade do sistema");
				prop.load(PropertySingleton.class.getResourceAsStream("/config.properties"));	//criando log
			} catch (IOException e) {
				log.error("Arquivo de configuração não carregado");								//criando log	
				e.printStackTrace();
			}
		}
		log.debug("Retornando as configurações do sistema");
		return prop;
	}

}
