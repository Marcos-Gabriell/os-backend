package br.com.marcos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcos.domain.Tecnico;import br.com.marcos.dtos.TecnicoDTO;
import br.com.marcos.repository.TecnicoRepository;
import br.com.marcos.services.exeptions.ObjectNotFoundException;


@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
			    "Objeto não encontrado! Id: " + id + ", Tipo: " + Tecnico.class.getName()));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}
	
	public Tecnico create(TecnicoDTO objDTO) {
		return repository.save(new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
	}
} 
