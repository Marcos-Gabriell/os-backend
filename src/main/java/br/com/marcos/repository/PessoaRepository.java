package br.com.marcos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.marcos.domain.Pessoa;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

	@Query("SELECT obj FROM Pessoa obj WHERE obj.cpf =:cpf")
	Pessoa findById(@Param("cpf") String cpf);

}