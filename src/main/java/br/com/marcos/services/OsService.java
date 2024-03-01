package br.com.marcos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcos.domain.OS;
import br.com.marcos.repository.OSRepository;
import br.com.marcos.services.exeptions.ObjectNotFoundException;

@Service
public class OsService {

	@Autowired
	private OSRepository repository;
	
	public OS findById(Integer id) {
		Optional<OS> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + "Tipo: " + OS.class.getName()));
	}
}
