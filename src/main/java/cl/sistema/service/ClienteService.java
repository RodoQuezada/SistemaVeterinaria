package cl.sistema.service;

import cl.sistema.dao.ClienteRepository;
import cl.sistema.model.Cliente;
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
public class ClienteService {
    // comentario
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        super();
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll() {
        List<Cliente> listaCliente = new ArrayList<>();
        for (Cliente c : clienteRepository.findAll()) {
            listaCliente.add(c);
        }
        return listaCliente;
    }

    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void delete(int rut) {
        clienteRepository.delete(rut);
    }

    public Cliente buscarCliente(int rut) {
        return clienteRepository.findOne(rut);
    }


}

