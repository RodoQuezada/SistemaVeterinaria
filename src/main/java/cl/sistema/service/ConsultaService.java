package cl.sistema.service;

import cl.sistema.dao.ConsultaRepository;
import cl.sistema.model.Consulta;
import cl.sistema.model.Mascota;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodo on 13-05-17.
 */
@Service
@Transactional
public class ConsultaService {


    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        super();
        this.consultaRepository = consultaRepository;
    }

    public List<Consulta> findAll(){
        List<Consulta> listaConsultas = new ArrayList<>();
        for (Consulta consulta: consultaRepository.findAll()) {
            listaConsultas.add(consulta);
        }
        return listaConsultas;
    }

    public void save(Consulta consulta){
        consultaRepository.save(consulta);
    }

    public void delete(int id){
        consultaRepository.delete(id);
    }

    public Consulta buscarConsultaPorRut(int rut){
        return consultaRepository.findOne(rut);
    }


}
