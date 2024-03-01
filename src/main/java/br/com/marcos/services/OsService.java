package br.com.marcos.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcos.domain.Cliente;
import br.com.marcos.domain.OS;
import br.com.marcos.domain.Tecnico;
import br.com.marcos.domain.enuns.Prioridade;
import br.com.marcos.domain.enuns.Status;
import br.com.marcos.dtos.OSDTO;
import br.com.marcos.repository.OSRepository;
import br.com.marcos.services.exeptions.ObjectNotFoundException;

@Service
public class OsService {

	@Autowired
	private OSRepository repository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public OS findById(Integer id) {
		Optional<OS> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + "Tipo: " + OS.class.getName()));
	}
	
	public List<OS> findAll() {
		return repository.findAll();
	}

	public OS create(@Valid OSDTO obj) {
		return fromDTO(obj);
	}
	
	private OS fromDTO(OSDTO obj)  {
		OS newObj = new OS();
		newObj.setId(obj.getId());
		newObj.setObservacoes(obj.getObservacoes());
		newObj.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		newObj.setStatus(Status.toEnum(obj.getStatus()));
		
		Tecnico tec = tecnicoService.findById(obj.getTecnico());
		
		Cliente cli = clienteService.findById(obj.getCliente());
		
		newObj.setTecnico(tec);
		newObj.setCliente(cli);
		
		return repository.save(newObj);
	}
}
