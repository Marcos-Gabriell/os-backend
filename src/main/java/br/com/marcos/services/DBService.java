package br.com.marcos.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcos.domain.Cliente;
import br.com.marcos.domain.OS;
import br.com.marcos.domain.Tecnico;
import br.com.marcos.domain.enuns.Prioridade;
import br.com.marcos.domain.enuns.Status;
import br.com.marcos.repository.ClienteRepository;
import br.com.marcos.repository.OSRepository;
import br.com.marcos.repository.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private OSRepository osRepository;

	public void instaciaDB() {
		Tecnico t1 = new Tecnico(null, "Marcos Gabriel", "826.074.260-81", "(74) 96666-8958");
		Cliente c1 = new Cliente(null, "João", "604.943.160-47", "(78) 96666-5252");
		OS os1 = new OS(null, Prioridade.ALTA, "Teste create os", Status.ADAMENTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}
}
