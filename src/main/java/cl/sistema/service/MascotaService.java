package cl.sistema.service;

import cl.sistema.dao.MascotaRepository;
import cl.sistema.model.Mascota;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodo on 07-05-17.
 */
@Service
@Transactional
public class MascotaService {
    // comentario
    public final MascotaRepository mascotaRepository;


    public MascotaService(MascotaRepository mascotaRepository) {
        super();
        this.mascotaRepository = mascotaRepository;
    }
    // comentario
    public List<Mascota> findAll() {
        List<Mascota> listaMascota = new ArrayList<>();
        for (Mascota c : mascotaRepository.findAll()) {
            listaMascota.add(c);
        }
        return listaMascota;
    }

    public void save(Mascota mascota) {
        mascotaRepository.save(mascota);
    }

    public void delete(int id) {
        mascotaRepository.delete(id);
    }

    public Mascota buscarMascota(int id) {
        return mascotaRepository.findOne(id);
    }




}
