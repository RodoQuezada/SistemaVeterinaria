package cl.sistema.dao;

import cl.sistema.model.Mascota;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rodo on 07-05-17.
 */
public interface MascotaRepository extends CrudRepository<Mascota,Integer> {


}
