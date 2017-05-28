package cl.sistema.controller;

import cl.sistema.model.Cliente;
import cl.sistema.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by rodo on 21-05-17.
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Controll cliente

    @GetMapping("/lista-clientes")
    public String listaClientes (HttpServletRequest request){
        request.setAttribute("listaCliente", clienteService.findAll());
        request.setAttribute("mode","MODE_LISTA");
        return "index";
    }

    @GetMapping("/nuevo-clientes")
    public String nuevoCliente (HttpServletRequest request){
        request.setAttribute("mode","MODE_NUEVO");
        return "index";
    }

    @PostMapping("/salvar-clientes")
    public String salvarCliente (@ModelAttribute Cliente cliente, HttpServletRequest request){
        clienteService.save(cliente);
        request.setAttribute("listaCliente", clienteService.findAll());
        request.setAttribute("mode","MODE_LISTA");
        return "index";
    }


    @GetMapping("/actualizar-cliente")
    public String actualizarCliente (@RequestParam int rut, HttpServletRequest request){
        request.setAttribute("cliente", clienteService.buscarCliente(rut));
        request.setAttribute("mode","MODE_ACTUALIZAR");
        return "index";
    }

    @GetMapping("/borrar-cliente")
    public String borrarCliente (@RequestParam int rut, HttpServletRequest request){
        clienteService.delete(rut);
        request.setAttribute("listaCliente", clienteService.findAll());
        request.setAttribute("mode","MODE_LISTA");
        return "index";
    }


}
