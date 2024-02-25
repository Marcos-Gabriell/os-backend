package br.com.marcos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marcos.domain.Tecnico;

@Repository
public interface OSRepository extends JpaRepository<Tecnico, Integer>{

}
