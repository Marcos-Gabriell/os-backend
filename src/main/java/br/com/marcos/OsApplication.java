package br.com.marcos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.marcos.domain.Cliente;
import br.com.marcos.domain.OS;
import br.com.marcos.domain.Tecnico;
import br.com.marcos.domain.enuns.Prioridade;
import br.com.marcos.domain.enuns.Status;
import br.com.marcos.repository.ClienteRepository;
import br.com.marcos.repository.OSRepository;
import br.com.marcos.repository.TecnicoRepository;

@SpringBootApplication
public class OsApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private OSRepository osRepository;

	public static void main(String[] args) {
		SpringApplication.run(OsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Tecnico t1 = new Tecnico(null, "Marcos Gabriel", "826.074.260-81", "(74) 96666-8958");
		Cliente c1 = new Cliente(null, "João", "826.074.260-88", "(78) 96666-5252");
		OS os1 = new OS(null, Prioridade.ALTA, "Teste create os", Status.ADAMENTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);
		
		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}
}
