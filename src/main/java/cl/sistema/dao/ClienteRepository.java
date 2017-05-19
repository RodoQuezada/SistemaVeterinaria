package cl.sistema.dao;

import cl.sistema.model.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rodo on 07-05-17.
 */
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
