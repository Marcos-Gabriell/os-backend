package br.com.marcos.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcos.domain.Pessoa;
import br.com.marcos.domain.Cliente;
import br.com.marcos.dtos.ClienteDTO;
import br.com.marcos.repository.PessoaRepository;
import br.com.marcos.repository.ClienteRepository;
import br.com.marcos.services.exeptions.DataIntegratyViolationExeception;
import br.com.marcos.services.exeptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente create(ClienteDTO objDTO) {
		if (findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationExeception("CPF já cadastrado na base de dados!");
		}
		return repository.save(new Cliente(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
	}

	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		Cliente oldObj = findById(id);

		if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new DataIntegratyViolationExeception("CPF já cadastrado na base de dados!");
		}

		oldObj.setNome(objDTO.getNome());
		oldObj.setCpf(objDTO.getCpf());
		oldObj.setTelefone(objDTO.getTelefone());
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Cliente obj = findById(id);
		if(obj.getList().size() > 0) {
			throw new DataIntegratyViolationExeception("Cliente possui ordens de serviço, não pode ser deletado!");
		}
		 String mensagem = "Cliente com ID " + id + " foi excluído com sucesso!";
		repository.deleteById(id);
	}

	private Pessoa findByCPF(ClienteDTO objDTO) {
		Pessoa obj = pessoaRepository.findById(objDTO.getCpf());
		
		if (obj != null) {
			return obj;
		}
		return null;
	}
}
