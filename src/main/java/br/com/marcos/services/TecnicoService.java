package br.com.marcos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcos.domain.Tecnico;
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
} 
