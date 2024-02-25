package br.com.marcos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.marcos.domain.Cliente;
import br.com.marcos.domain.OS;
import br.com.marcos.domain.Tecnico;
import br.com.marcos.domain.enuns.Prioridade;
import br.com.marcos.domain.enuns.Status;

@SpringBootApplication
public class OsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Tecnico t1 = new Tecnico(null, "Marcos Gabriel", "826.074.260-81", "(74) 96666-8958");
		Cliente c1 = new Cliente(null, "João", "826.074.260-88", "(78) 96666-5252");
		OS  os1 = new OS(null, Prioridade.ALTA, "Teste create os", Status.ADAMENTO, t1, c1);
		
	}

}
