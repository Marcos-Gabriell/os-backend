package br.com.marcos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marcos.domain.OS;

@Repository
public interface TecnicoRepository extends JpaRepository<OS, Integer>{

}
