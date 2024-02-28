package br.com.marcos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.marcos.domain.Tecnico;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{

	@Query("SELECT obj FROM Tecnico obj WHERE obj.cpf =:cpf")
	Tecnico findById(@Param("cpf") String cpf);

}
