package br.com.crud.saladereuniao.repository;

import br.com.crud.saladereuniao.model.Sala;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends CrudRepository <Sala, Long>{
}
